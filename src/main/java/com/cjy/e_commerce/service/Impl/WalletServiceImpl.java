package com.cjy.e_commerce.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjy.e_commerce.entity.Detail;
import com.cjy.e_commerce.entity.User;
import com.cjy.e_commerce.entity.Wallet;
import com.cjy.e_commerce.mapper.WalletMapper;
import com.cjy.e_commerce.service.IDetailService;
import com.cjy.e_commerce.service.IWalletService;
import com.cjy.e_commerce.utils.Result;
import com.cjy.e_commerce.utils.UserHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements IWalletService {
    @Resource
    private WalletMapper walletMapper;
    @Resource
    private IDetailService detailService;
    @Override
    public Result search() {
        Long uid = UserHolder.getUser().getId();
        if(uid==null){
            return Result.error("未登录");
        }
        LambdaQueryWrapper<Wallet> walletLambdaQueryWrapper = new LambdaQueryWrapper<>();
        walletLambdaQueryWrapper.eq(Wallet::getUid,uid);
        Wallet wallet = getOne(walletLambdaQueryWrapper);
        return Result.success(wallet);
    }

    @Override
    @Transactional
    public Result consume(double n) {
        Long uid = UserHolder.getUser().getId();
        if(uid==null){
            Result.error("未登录");
        }
        Result result = search();
        Wallet wallet = (Wallet) result.getData();
        //根据不同线程id上锁
        synchronized (uid.toString()){
            //判断余额是否可以消费
            if (wallet.getBalance()<n){
                return Result.error("余额不足");
            }
            walletMapper.opsMoney(n,wallet.getId());
        }
        Detail detail = new Detail();
        detail.setUid(uid);
        detail.setDescription("消费");
        detailService.save(detail);

        return Result.ok();
    }

    @Override
    @Transactional
    public Result refund(double number) {
        Long uid = UserHolder.getUser().getId();
        if(uid==null){
            Result.error("未登录");
        }
        Result result = search();
        Wallet wallet = (Wallet) result.getData();
        walletMapper.opsMoney(number,wallet.getId());
        Detail detail = new Detail();
        detail.setUid(uid);
        detail.setDescription("退款成功");
        detailService.save(detail);
        return Result.ok();
    }

}

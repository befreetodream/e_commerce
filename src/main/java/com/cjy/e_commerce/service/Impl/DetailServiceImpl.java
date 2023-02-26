package com.cjy.e_commerce.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjy.e_commerce.entity.Detail;
import com.cjy.e_commerce.mapper.DetailMapper;
import com.cjy.e_commerce.service.IDetailService;
import com.cjy.e_commerce.utils.Result;
import com.cjy.e_commerce.utils.UserHolder;
import org.springframework.stereotype.Service;



@Service
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail> implements IDetailService {
    @Override
    public Result<Page> dPage(int page, int pageSize) {
        Long uid = UserHolder.getUser().getId();
        if(uid==null){
            Result.error("未登录");
        }
        Page pageinfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Detail> detailLambdaQueryWrapper = new LambdaQueryWrapper<>();
        detailLambdaQueryWrapper.eq(Detail::getUid,uid);
        Page page1 = page(pageinfo, detailLambdaQueryWrapper);
        return Result.success(page1);
    }
}

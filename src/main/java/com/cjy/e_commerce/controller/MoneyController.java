package com.cjy.e_commerce.controller;

import com.cjy.e_commerce.service.IDetailService;
import com.cjy.e_commerce.service.IWalletService;
import com.cjy.e_commerce.service.Impl.WalletServiceImpl;
import com.cjy.e_commerce.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/money")
public class MoneyController {
    /**
     * 1.  查询用户钱包余额
     * 2. 用户消费100元的接口
     * 3. 用户退款20元接口
     * 4. 查询用户钱包金额变动明细的接口
     */
    @Resource
    private IWalletService walletService;

    @Resource
    private IDetailService detailService;

    //查询用户钱包余额
    @GetMapping("/serarch")
    public Result search(){
        return walletService.search();
    }

    //消费100
    @GetMapping("/consume100")
    public Result consume100(){
        return walletService.consume(-100);
    }
    //退款20
    @GetMapping("/refund20")
    public Result refund20(){
        return walletService.refund(20);
    }

    //分页查询明细
    @GetMapping("/page")
    public Result page(int page,int size){
        return detailService.dPage(page,size);
    }

}

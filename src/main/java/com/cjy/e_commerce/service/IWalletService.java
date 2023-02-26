package com.cjy.e_commerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjy.e_commerce.entity.Wallet;
import com.cjy.e_commerce.utils.Result;

public interface IWalletService extends IService<Wallet> {
    public Result search();
    //消费
    public Result consume(double number);
    //退款
    public Result refund(double number);
}

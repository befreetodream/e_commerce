package com.cjy.e_commerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cjy.e_commerce.entity.Wallet;

public interface WalletMapper extends BaseMapper<Wallet> {
    //操作金钱接口
    public boolean opsMoney(double n,Long id);
}

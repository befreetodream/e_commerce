package com.cjy.e_commerce.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cjy.e_commerce.entity.Detail;
import com.cjy.e_commerce.utils.Result;

public interface IDetailService extends IService<Detail> {
    //分页查询
    public Result<Page> dPage(int page, int pageSize);

}

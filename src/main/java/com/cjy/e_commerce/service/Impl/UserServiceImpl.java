package com.cjy.e_commerce.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjy.e_commerce.entity.User;
import com.cjy.e_commerce.mapper.UserMapper;
import com.cjy.e_commerce.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}

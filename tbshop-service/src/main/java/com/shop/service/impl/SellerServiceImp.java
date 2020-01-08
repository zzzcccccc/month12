package com.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.shop.mapper.TbUserMapper;
import com.shop.pojo.TbUser;
import com.shop.service.SellerService;
@Service
public class SellerServiceImp implements SellerService{
	@Autowired
	private TbUserMapper userMapper;
	
	public TbUser findName(String username) {
		System.out.println(123);
		return userMapper.findName(username);
	}

}

package com.shop.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shop.common.AliyunOSSClientUtils;
import com.shop.pojo.PageResult;
import com.shop.pojo.Result;
import com.shop.pojo.TbDing;
import com.shop.pojo.TbShop;
import com.shop.service.ShopService;

@RestController
@RequestMapping("/month")
public class ShopController {
	@Reference
	private ShopService shopService;
	/**
	 * 商品列表+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/shopList")
	public PageResult shopList(Integer page,Integer rows){
		return shopService.shopList(page,rows);
	}
	/**
	 * 状态修改
	 * @param shop
	 * @return
	 */
	@RequestMapping("/changeZt")
	public Result changeZt(@RequestBody TbShop shop){
		try {
			shopService.changeZt(shop);
			return new Result(true, "状态success");
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, "状态error");
		}
		
	}
	/**
	 * 上传
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload")
	public Result upload(MultipartFile file){
		try {
			AliyunOSSClientUtils ossClientUtils = new AliyunOSSClientUtils();
			String img = ossClientUtils.uploadImg2Oss(file);
			String imgUrl = ossClientUtils.getImgUrl(img);
			return new Result(true, imgUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Result(false, "error");
		}
	}
	//添加
	@RequestMapping("/add")
	public Result add(@RequestBody TbShop shop){
		shopService.add(shop);
		return new Result(true, "添加成功");
	}
	//获取登陆人权限
	@RequestMapping("/findUser")
	public Collection<? extends GrantedAuthority> findUser(){
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println(authorities);
		return authorities;
	}
	/**
	 * 订单列表
	 * @return
	 */
	@RequestMapping("/dingList")
	public List<TbDing> dingList(){
		return shopService.dingList();
	}
	/**
	 * 回显商品
	 */
	@RequestMapping("/shopHui")
	public TbShop shopHui(Integer sid){
		return shopService.shopHui(sid);
	}
	@RequestMapping("/shopAdd")
	public Result shopAdd(@RequestBody TbDing ding){
		shopService.shopAdd(ding);
		return new Result(true, "success");
	}
}

package com.shop.service;

import java.util.List;

import com.shop.pojo.PageResult;
import com.shop.pojo.TbDing;
import com.shop.pojo.TbShop;

public interface ShopService {

	PageResult shopList(Integer page, Integer rows);

	void changeZt(TbShop shop);

	void add(TbShop shop);

	List<TbDing> dingList();

	TbShop shopHui(Integer sid);

	void shopAdd(TbDing ding);

}

package com.shop.service.impl;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.netty.handler.queue.BufferedWriteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.mapper.TbDingMapper;
import com.shop.mapper.TbShopMapper;
import com.shop.pojo.PageResult;
import com.shop.pojo.TbDing;
import com.shop.pojo.TbShop;
import com.shop.service.ShopService;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;
@Service
public class ShopServiceImp implements ShopService{

	@Autowired
	private TbShopMapper shopMapper;
	@Autowired
	private TbDingMapper dingMapper;
	@Autowired
	private FreeMarkerConfig freeMarkerConfig;
	@Value("${pagedir}")
	private String pagedir;
	
	//shop商品列表
	public PageResult shopList(Integer page,Integer rows) {
		PageHelper.startPage(page, rows);
		PageInfo<TbShop> pageInfo = new PageInfo<TbShop>(shopMapper.selectByExample(null));
		return new PageResult(pageInfo.getTotal(), pageInfo.getList());
	}
	//修改商品状态+静态页面
	public void changeZt(TbShop shop) {
		Integer sid = shop.getSid();
		if(shop.getZt().equals("0")){
			shop.setZt("1");
			try {
				Configuration configuration = freeMarkerConfig.getConfiguration();
				Template template = configuration.getTemplate("item.ftl");
				Map map=new HashMap();
				TbShop shop2 = shopMapper.selectByPrimaryKey(sid);
				map.put("shop2", shop2);
				Writer writer= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pagedir+sid+".html"),"UTF-8"));
				template.process(map, writer);
				writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else{
			shop.setZt("0");
		}
		shopMapper.updateByPrimaryKey(shop);
	}
	//添加
	public void add(TbShop shop) {
		shop.setZt("0");
		shopMapper.insert(shop);
	}
	//订单列表
	public List<TbDing> dingList() {
		return dingMapper.selectByExample(null);
	}
	//shangpin回显
	public TbShop shopHui(Integer sid) {
		return shopMapper.selectByPrimaryKey(sid);
	}
	public void shopAdd(TbDing ding) {
		ding.setZt("0");
		dingMapper.insert(ding);
	}

}

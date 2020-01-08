package com.shop.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shop.pojo.TbUser;

public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private SellerService sellerService;
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ArrayList<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		TbUser tbUser = sellerService.findName(username);
		if(tbUser!=null){
			if(tbUser.getRole().equals("0")){
				authority.add(new SimpleGrantedAuthority("ROLE_SELLER"));
				return new User(username,tbUser.getPassword(),authority);
			}else{
				authority.add(new SimpleGrantedAuthority("ROLE_USER"));
				return new User(username,tbUser.getPassword(),authority);
			}
		}
		return null;
	}
}

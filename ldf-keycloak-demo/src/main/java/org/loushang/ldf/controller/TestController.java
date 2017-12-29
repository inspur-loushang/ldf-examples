package org.loushang.ldf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sdk.security.authc.AuthenticationProvider;
import sdk.security.authz.AuthorizationProvider;
import sdk.security.menu.MenuProvider;
import sdk.security.userinfo.UserProvider;
import sdk.security.util.SecurityProvider;

@RestController
@RequestMapping("/service/test")
public class TestController {
	
	@RequestMapping("/all")
	public void all(){
		System.out.println("********测试  security-sdk 接口********");
		System.out.println("获取当前登录用户标识 : "+AuthenticationProvider.getLoginUserId());
		System.out.println("获取当前登录用户Token : "+AuthenticationProvider.getToken());
		System.out.println("获取当前登录用户信息 : "+AuthenticationProvider.getLoginUserInfo());
		System.out.println("获取当前登录用户有权限的菜单"+MenuProvider.getAuthzMenu(null));
		System.out.println("获取当前登录用户所有菜单"+MenuProvider.getMenu(null));
		System.out.println("判断当前登录用户对资源id为queryuser的资源是否有权限 : "+AuthorizationProvider.hasPermission("queryuser"));
		System.out.println("判断当前登录用户对资源id为modifyuser的资源是否有权限 : "+AuthorizationProvider.hasPermission("modifyuser"));
		System.out.println("获取当前登录用户有权限的资源信息 : "+AuthorizationProvider.getResources(null));
		System.out.println("获取当前登录用户有权限的且类型为menu资源信息 : "+AuthorizationProvider.getResources("menu"));
		System.out.println("根据用户ID获取详细信息 : "+UserProvider.getUserInfo("zhangsan"));
		System.out.println("获取安全中心的服务根地址 : "+SecurityProvider.getSecurityContextUrl());
		System.out.println("获取注销url : "+SecurityProvider.getLogoutUrl("index.html"));
		System.out.println("************************************");
	}
}

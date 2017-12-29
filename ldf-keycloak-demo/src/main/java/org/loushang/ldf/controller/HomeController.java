package org.loushang.ldf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import sdk.security.authc.AuthenticationProvider;
import sdk.security.authz.AuthorizationProvider;
import sdk.security.menu.MenuProvider;
import sdk.security.util.SecurityProvider;

@RestController
@RequestMapping("/service/home")
public class HomeController {

	@SuppressWarnings("unchecked")
	@RequestMapping("/getMenu")
	public List<Map<String, Object>> getMenu(){
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String menu = MenuProvider.getAuthzMenu(null);
		Gson gson = new Gson();
		list = gson.fromJson(menu, List.class);
		return list;
	}
	@RequestMapping("/getUser")
	public Map<String,String> getUser(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("userId", AuthenticationProvider.getLoginUserId());
		return map;
	}
	@RequestMapping("/getLogout")
	public Map<String,String> getLogout(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("logoutUrl", SecurityProvider.getLogoutUrl("index.html"));
		return map;
	}
	@RequestMapping("/getOpt/{resourceId}")
	public boolean getOpt(@PathVariable String resourceId){
		return AuthorizationProvider.hasPermission(resourceId);
	}
}

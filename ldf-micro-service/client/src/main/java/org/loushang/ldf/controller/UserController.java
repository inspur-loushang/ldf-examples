package org.loushang.ldf.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.loushang.framework.util.RestRequestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/framework/demo/user")
public class UserController {

	/**
	 * 跳转用户列表页面
	 * 
	 * @return 用户列表页面
	 */
	@RequestMapping
	public String getPage() {
		return "user/queryuser";
	}

	/**
	 * 查询用户列表
	 * 
	 * @param parameters
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(@RequestBody Map<String, Object> parameters) {
		String url = "http://loushang/service/framework/demo/userend/query";
		return RestRequestUtils.postForObject(url, parameters, Map.class);
	}

	/**
	 * 查询用户详细信息
	 * 
	 * @return
	 */
	@RequestMapping("/getUserDetailsById")
	@ResponseBody
	public Map<String, Object> getUserDetailsById(HttpServletRequest req) {
		String url = "http://loushang/service/framework/demo/userend/getUserDetailsById/{id}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", req.getParameter("id"));
		return RestRequestUtils.getForObject(url, Map.class, params);
	};

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> deleteUser(@PathVariable String id) {
		String url = "http://loushang/service/framework/demo/userend/delete/{id}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		RestRequestUtils.delete(url, params);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		return map;
	}

	/**
	 * 用户修改页面的跳转
	 * 
	 * @param id
	 *            [主键ID
	 * 
	 * @return Map key为 <code>user<code>[User对象]
	 * 
	 */
	@RequestMapping("/edit")
	public String editPage(@RequestParam(value = "id", required = false) String id) {
		return "user/modifyuser";
	}

	/**
	 * 保存操作
	 * 
	 * @param user
	 * 
	 * @return
	 * 
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public Map<String, Object> saveUser(@RequestBody Map<String, Object> user) {
		String url = "http://loushang/service/framework/demo/userend/save";
		return RestRequestUtils.postForObject(url, user, Map.class);
	}
}

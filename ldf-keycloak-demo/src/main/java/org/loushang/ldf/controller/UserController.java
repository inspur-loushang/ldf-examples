package org.loushang.ldf.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.loushang.ldf.data.User;
import org.loushang.ldf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/service/user")
public class UserController {

	@Autowired
	IUserService userService;

	/**
	 * 查询用户列表
	 * 
	 * @param parameters
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public Map<String, Object> query(@RequestBody Map<String, Object> parameters) {

		return userService.selectAll(parameters);
	}

	/**
	 * 查询用户详细信息
	 * 
	 * @return
	 */
	@RequestMapping("/getUserDetailsById")
	@ResponseBody
	public Map<String, Object> getUserDetailsById(HttpServletRequest req) {

		return userService.getUserDetailsById(req.getParameter("id"));
	};

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Map<String, Object> deleteUser(@PathVariable String id) {

		return userService.deleteById(id);
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
	public Map<String, Object> saveUser(@RequestBody User user) {

		return userService.save(user);
	}
}

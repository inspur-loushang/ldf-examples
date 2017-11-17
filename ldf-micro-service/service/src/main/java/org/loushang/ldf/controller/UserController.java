package org.loushang.ldf.controller;

import java.util.Map;

import org.loushang.ldf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/framework/demo/userend")
public class UserController {

	@Autowired
	IUserService userService;


	/**
	 * 查询用户列表
	 * 
	 * @param parameters
	 * @return
	 */
	@RequestMapping(value ="/query" ,method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> query(@RequestBody Map<String, Object> parameters) {

		return userService.selectAll(parameters);
	}

	/**
	 * 查询用户详细信息
	 * 
	 * @return
	 */
	@RequestMapping("/getUserDetailsById/{id}")
	@ResponseBody
	public Map<String, Object> getUserDetailsById(@PathVariable String id) {

		return userService.getUserDetailsById(id);
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
	public Map<String, Object> saveUser(@RequestBody Map<String, Object> user) {

		return userService.save(user);
	}
}

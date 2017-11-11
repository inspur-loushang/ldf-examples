package org.loushang.ldf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.loushang.ldf.data.User;
import org.loushang.ldf.data.UserArchive;
import org.loushang.ldf.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

	public Map<String, Object> save(User user) {
	    // todo: 待处理
		return null;
	}

	/**
	 * 分页查询所有用户
	 * 
	 * @param parameters
	 * @return
	 */
	public Map<String, Object> selectAll(Map<String, Object> parameters) {
		Map<String, Object> data = new HashMap<String, Object>();
		List<User> list = new ArrayList<User>();
		User user =new User();
        user.setId("A0001");
        user.setUserId("A0001");
        user.setUserName("张三");
        user.setNickname("张三");
        user.setPassword("111111");
        user.setStatus("N");
        list.add(user);
        user =new User();
        user.setId("A0002");
        user.setUserId("A0002");
        user.setUserName("李四");
        user.setNickname("李四");
        user.setPassword("222222");
        user.setStatus("N");
        list.add(user);
		data.put("data", list);
		data.put("total", list.size());
		return data;
	}

	/**
	 * 根据id获取用户详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> getUserDetailsById(String id) {
		Map<String, Object> data = new HashMap<String, Object>();
		if (id != null && !"".equals(id)) {
		    User user =new User();
	        user.setId("A0001");
	        user.setUserId("A0001");
	        user.setUserName("张三");
	        user.setNickname("张三");
	        user.setPassword("111111");
	        user.setStatus("N");
			UserArchive userArchive = new UserArchive();
			userArchive.setId("A0001");
			userArchive.setSchool("山东大学");
			user.setArchive(userArchive);
			if (user != null) {
				data.put("id", user.getId());
				data.put("userId", user.getUserId());
				data.put("userName", user.getUserName());
				data.put("nickname", user.getNickname());
				data.put("password", user.getPassword());
				data.put("status", user.getStatus());
				if (userArchive != null) {
					Map<String, Object> archivData = new HashMap<String, Object>();
					archivData.put("gender", userArchive.getGender());
					archivData.put("birthday", userArchive.getBirthday());
					archivData.put("education", userArchive.getEducation());
					archivData.put("school", userArchive.getSchool());
					archivData.put("email", userArchive.getEmail());
					data.put("archive", archivData);
				}
			}
		}
		return data;
	}

	public Map<String, Object> deleteById(String id) {
	    // todo: 待处理
		return null;
	}

	/**
	 * 根据ID获取用户信息
	 * 
	 * @param id
	 *            [ID主键]
	 * 
	 * @return User
	 * 
	 */
	public User findOne(String id) {
		User user =new User();
		user.setId("A0001");
		user.setUserId("A0001");
		user.setUserName("张三");
		user.setNickname("张三");
		user.setPassword("111111");
		user.setStatus("N");
		return user;
	}

}

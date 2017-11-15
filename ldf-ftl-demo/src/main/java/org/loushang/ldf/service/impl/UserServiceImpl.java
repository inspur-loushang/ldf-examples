package org.loushang.ldf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.loushang.framework.mybatis.PageUtil;
import org.loushang.ldf.dao.ArchiveMapper;
import org.loushang.ldf.dao.UserMapper;
import org.loushang.ldf.data.User;
import org.loushang.ldf.data.UserArchive;
import org.loushang.ldf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ArchiveMapper archiveMapper;

	@Transactional
	public Map<String, Object> save(User user) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("success", false);
		try {
			if (user.getId() != null && !"".equals(user.getId())) {
				// 更新用户信息
				userMapper.update(user);
				// 更新用户档案信息
				user.getArchive().setId(user.getId());
				archiveMapper.update(user.getArchive());
			} else {
				// 保存用户信息
				user.setId(UUID.randomUUID().toString());
				userMapper.insert(user);
				// 保存用户档案信息
				user.getArchive().setId(user.getId());
				archiveMapper.insert(user.getArchive());
			}
			data.put("success", true);
		} catch (Exception e) {
			data.put("msg", e.getMessage());
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * 分页查询所有用户
	 * 
	 * @param parameters
	 * @return
	 */
	public Map<String, Object> selectAll(Map<String, Object> parameters) {
		Map<String, Object> data = new HashMap<String, Object>();
//		PageHelper.startPage((Integer) parameters.get("start"), (Integer) parameters.get("limit"));
//		PageInfo<User> userPage = new PageInfo<User>();
		List<User> list = userMapper.query(parameters);
		data.put("data", list);
		// 获取总记录条数
        int total = PageUtil.getTotalCount();
		data.put("total", total);      
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
			User user = userMapper.get(id);
			UserArchive userArchive = archiveMapper.get(id);
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

	@Transactional
	public Map<String, Object> deleteById(String id) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("success", false);
		try {
			if (id != null && !"".equals(id)) {
				String[] idArray = id.split(",");
				for (int i = 0; i < idArray.length; i++) {
					archiveMapper.delete(idArray[i]);
					userMapper.delete(idArray[i]);
				}
				data.put("success", true);
			} else {
				data.put("msg", "id为空!");
			}
		} catch (Exception e) {
			data.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return data;
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
		User user = userMapper.get(id);
		if (user != null) {
			user.setArchive(archiveMapper.get(id));
		}
		return user;
	}

}

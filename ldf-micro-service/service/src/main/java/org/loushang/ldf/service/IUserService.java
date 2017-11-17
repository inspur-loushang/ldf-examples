package org.loushang.ldf.service;

import java.util.Map;

import org.loushang.ldf.data.User;

public interface IUserService {
	/**
	 * 保存新增和修改后的用户信息
	 * 
	 * @param user
	 * @return
	 */
	public Map<String, Object> save(Map<String, Object> user);

	/**
	 * 分页查询所有用户
	 * 
	 * @param parameters
	 * @return
	 */
	public Map<String, Object> selectAll(Map<String, Object> parameters);

	/**
	 * 根据id查询用户详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> getUserDetailsById(String id);

	/**
	 * 根据id删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	public Map<String, Object> deleteById(String id);
	
	/**
     * 根据ID获取用户信息
     * 
     * @param id [ID主键]
     * 
     * @return User
     * 
     */
    public User findOne(String id);

}
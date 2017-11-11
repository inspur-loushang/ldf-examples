package org.loushang.ldf.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "demo_user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "user_name")
	private String userName;

	private String nickname;

	private String password;

	@Column(name = "act_status")
	private String status = "N";

	@Transient
	private UserArchive archive;

	public UserArchive getArchive() {
		return archive;
	}

	public void setArchive(UserArchive archive) {
		this.archive = archive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

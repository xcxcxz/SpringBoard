package com.test.board.vo;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberVO implements UserDetails, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String birthdate;
	private String regdate;
	private String authkey;
	private String authstatus;
	private Collection<GrantedAuthority> authorities;
	
	
	public MemberVO() {}


	public MemberVO(String id, String pw, String name, String phone, String email, String birthdate, String regdate,
			String authkey, String authstatus) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthdate = birthdate;
		this.regdate = regdate;
		this.authkey = authkey;
		this.authstatus = authstatus;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public String getAuthkey() {
		return authkey;
	}


	public void setAuthkey(String authkey) {
		this.authkey = authkey;
	}


	public String getAuthstatus() {
		return authstatus;
	}


	public void setAuthstatus(String authstatus) {
		this.authstatus = authstatus;
	}


	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", birthdate=" + birthdate + ", regdate=" + regdate + ", authkey=" + authkey + ", authstatus="
				+ authstatus + "]";
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}


	@Override
	public String getPassword() {
		return pw;
	}


	@Override
	public String getUsername() {
		return id;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		
		int i = Integer.parseInt(authstatus);
		boolean auth = (i !=0);
		
		return auth;
	}

	
	
}

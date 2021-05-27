package com.test.board.dao;


import java.util.Map;

import com.test.board.vo.MemberVO;

public interface MemberDao {
	
	public int insertMember(MemberVO member);
	
	public MemberVO login(MemberVO member);
	
	public int deleteMember(String id);
	
	public int updateAuthKey(Map<String, String> map);

}

package com.test.board.service;

import com.test.board.vo.MemberVO;

public interface MemberService {
	
	public int insertMember(MemberVO member);
	
	public MemberVO login(MemberVO member);
	
	public int deleteMember(String id);
	

}

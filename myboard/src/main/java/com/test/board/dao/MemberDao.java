package com.test.board.dao;

import com.test.board.vo.MemberVO;

public interface MemberDao {
	
	public int insertMember(MemberVO member);
	
	public MemberVO login(MemberVO member);

}

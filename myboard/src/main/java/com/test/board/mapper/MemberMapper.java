package com.test.board.mapper;

import com.test.board.vo.MemberVO;

public interface MemberMapper {
	
	public int insertMember(MemberVO member);
	public MemberVO login(MemberVO member);
	public int deleteMember(String id);

}

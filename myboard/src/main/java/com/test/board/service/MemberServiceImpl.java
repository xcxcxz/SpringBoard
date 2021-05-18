package com.test.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.MemberDao;
import com.test.board.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	public int insertMember(MemberVO member) {
		return memberDao.insertMember(member);
	}
	public MemberVO login(MemberVO member) {
		return memberDao.login(member);
	}

}

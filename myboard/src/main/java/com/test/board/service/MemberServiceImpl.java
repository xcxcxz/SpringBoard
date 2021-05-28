package com.test.board.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.BoardDao;
import com.test.board.dao.MemberDao;
import com.test.board.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	BoardDao boardDao;
	
	public int insertMember(MemberVO member) {
		return memberDao.insertMember(member);
	}
	public MemberVO login(MemberVO member) {
		return memberDao.login(member);
	}
	
	public int deleteMember(String id) {
		int result1=boardDao.deleteAllBoard(id);
		int result2=memberDao.deleteMember(id);
		
		if(result1==1&&result2==1) {
			return 1;
		}else {
			return 0;
		}
	}
	@Override
	public int updateAuthKey(MemberVO member) {
		return memberDao.updateAuthKey(member);
	}
	
	
}

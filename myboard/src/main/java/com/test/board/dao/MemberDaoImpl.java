package com.test.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.mapper.MemberMapper;
import com.test.board.vo.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertMember(MemberVO member) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			result = mapper.insertMember(member);
		}catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		
		return result;
	}
	
	public MemberVO login(MemberVO member) {
		MemberVO result=null;
		
		MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.login(member);
		}catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		
		return result;
		
	}

	@Override
	public int deleteMember(String id) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			result = mapper.deleteMember(id);
		}catch(Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	

}

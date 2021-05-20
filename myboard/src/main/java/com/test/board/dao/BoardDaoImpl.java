package com.test.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.mapper.BoardMapper;
import com.test.board.vo.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertContent(BoardVO board) {
		
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertContent(board);
		}catch(Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public ArrayList<BoardVO> selectAll(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			list = mapper.selectAll();
		}catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}
	
	public BoardVO selectOne(String boardSeq) {
		BoardVO result = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			result = mapper.selectOne(boardSeq);
		}catch(Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	

}

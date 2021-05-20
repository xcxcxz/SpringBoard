package com.test.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.BoardDao;
import com.test.board.vo.BoardVO;

@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	BoardDao boardDao;

	@Override
	public int insertContent(BoardVO board) {
		return boardDao.insertContent(board);
	}

	@Override
	public ArrayList<BoardVO> selectAll() {
		return boardDao.selectAll();
	}

	@Override
	public BoardVO selectOne(String boardSeq) {
		return boardDao.selectOne(boardSeq);
	}
	

}

package com.test.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.BoardDao;
import com.test.board.page.Paging;
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
	public ArrayList<BoardVO> selectAll(Paging navi) {
		return boardDao.selectAll(navi);
	}

	@Override
	public BoardVO selectOne(String boardSeq) {
		return boardDao.selectOne(boardSeq);
	}

	@Override
	public int deleteContent(String boardSeq) {
		return boardDao.deleteContent(boardSeq);
	}

	@Override
	public int updateBoard(BoardVO board) {
		return boardDao.updateBoard(board);
	}

	@Override
	public int selectCount() {
		return boardDao.selectCount();
	}
	
	
	
	

}

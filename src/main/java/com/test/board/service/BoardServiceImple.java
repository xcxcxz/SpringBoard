package com.test.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.BoardDao;
import com.test.board.page.Paging;
import com.test.board.vo.BoardVO;
import com.test.board.vo.FileVO;
import com.test.board.vo.ReplyVO;

@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	BoardDao boardDao;

	@Override
	public int insertContent(BoardVO board) {
		return boardDao.insertContent(board);
	}

	@Override
	public ArrayList<BoardVO> selectAll(String searchWord, Paging navi) {
		return boardDao.selectAll(searchWord, navi);
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
	public int selectCount(String searchWord) {
		return boardDao.selectCount(searchWord);
	}

	@Override
	public int insertReply(ReplyVO reply) {
		return boardDao.insertReply(reply);
	}

	@Override
	public ArrayList<HashMap<String, String>> selectReply(String boardSeq) {
		return boardDao.selectReply(boardSeq);
	}

	@Override
	public int insertFile(FileVO fvo) {
		return boardDao.insertFile(fvo);
	}

	@Override
	public FileVO selectFile(String boardSeq) {
		return boardDao.selectFile(boardSeq);
	}

	@Override
	public FileVO selectFileBySeq(String fileSeq) {
		return boardDao.selectFileBySeq(fileSeq);
	}
	
	
	
	
	

}

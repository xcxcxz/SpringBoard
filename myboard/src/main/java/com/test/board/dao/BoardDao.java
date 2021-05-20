package com.test.board.dao;

import java.util.ArrayList;

import com.test.board.vo.BoardVO;

public interface BoardDao {
	
	//게시글 작성
	public int insertContent(BoardVO board);
	//게시글 전체조회
	public ArrayList<BoardVO> selectAll();
	//게시글 상세
	public BoardVO selectOne(String boardSeq);

}

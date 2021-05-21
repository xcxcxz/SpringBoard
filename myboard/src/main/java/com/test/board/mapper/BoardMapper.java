package com.test.board.mapper;

import java.util.ArrayList;

import com.test.board.vo.BoardVO;

public interface BoardMapper {
	public int insertContent(BoardVO board);
	public ArrayList<BoardVO> selectAll();
	public BoardVO selectOne(String boardSeq);
	public int deleteContent(String boardSeq);
}

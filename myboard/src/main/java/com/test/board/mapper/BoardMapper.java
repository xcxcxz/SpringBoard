package com.test.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.test.board.vo.BoardVO;

public interface BoardMapper {
	public int insertContent(BoardVO board);
	public ArrayList<BoardVO> selectAll();
	public BoardVO selectOne(String boardSeq);
	public int updateBoard(BoardVO board);
	public int deleteContent(String boardSeq);
	public int deleteAllBoard(String id);
	public int boardListCnt();
	public ArrayList<BoardVO> selectAll(RowBounds rb);
}

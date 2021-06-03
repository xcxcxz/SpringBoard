package com.test.board.service;

import java.util.ArrayList;

import com.test.board.page.Paging;
import com.test.board.vo.BoardVO;

public interface BoardService {
	
	public int insertContent(BoardVO board);
	
	public ArrayList<BoardVO> selectAll(String searchWord, Paging navi);
	
	public BoardVO selectOne(String boardSeq);
	
	public int deleteContent(String boardSeq);
	
	public int updateBoard(BoardVO board);
	
	public int selectCount(String searchWord);
	
	

}

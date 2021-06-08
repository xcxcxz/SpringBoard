package com.test.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.test.board.page.Paging;
import com.test.board.vo.BoardVO;
import com.test.board.vo.FileVO;
import com.test.board.vo.ReplyVO;

public interface BoardService {
	
	public int insertContent(BoardVO board);
	
	public ArrayList<BoardVO> selectAll(String searchWord, Paging navi);
	
	public BoardVO selectOne(String boardSeq);
	
	public int deleteContent(String boardSeq);
	
	public int updateBoard(BoardVO board);
	
	public int selectCount(String searchWord);
	
	public int insertReply(ReplyVO reply);
	
	public ArrayList<HashMap<String,String>> selectReply(String boardSeq);
	
	public int insertFile(FileVO fvo);
	
	public FileVO selectFile(String boardSeq);
	
	public FileVO selectFileBySeq(String fileSeq);
	
	

}

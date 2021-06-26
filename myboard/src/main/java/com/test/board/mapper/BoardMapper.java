package com.test.board.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.test.board.vo.BoardVO;
import com.test.board.vo.FileVO;
import com.test.board.vo.ReplyVO;

public interface BoardMapper {
	public int insertContent(BoardVO board);
	public ArrayList<BoardVO> selectAll();
	public BoardVO selectOne(String boardSeq);
	public int updateBoard(BoardVO board);
	public int deleteContent(String boardSeq);
	public int deleteAllBoard(String id);
	public int boardListCnt(String searchWord);
	public ArrayList<BoardVO> selectAll(String searchWork, RowBounds rb);
	public int insertReply(ReplyVO reply);
	public ArrayList<HashMap<String,String>> selectReply(String boardSeq);
	public int insertFile(FileVO fvo);
	public FileVO selectFile(String boardSeq);
	public FileVO selectFileBySeq(String FileSeq);
}

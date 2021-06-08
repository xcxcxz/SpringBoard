package com.test.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.test.board.page.Paging;
import com.test.board.vo.BoardVO;
import com.test.board.vo.FileVO;
import com.test.board.vo.ReplyVO;

public interface BoardDao {
	
	//게시글 작성
	public int insertContent(BoardVO board);
	//게시글 전체조회
	public ArrayList<BoardVO> selectAll(String searchWord, Paging navi);
	//게시글 상세
	public BoardVO selectOne(String boardSeq);
	//게시글 삭제
	public int deleteContent(String boardSeq);
	//게시글 수정
	public int updateBoard(BoardVO board);
	//회원탈퇴시 모든게시물 수정
	public int deleteAllBoard(String id);
	//게시물 개수
	public int selectCount(String searchWord);

	public ArrayList<HashMap<String,String>> selectReply(String boardSeq);
	
	public int insertReply(ReplyVO reply);
	
	public int insertFile(FileVO fvo);
	
	public FileVO selectFile(String boardSeq);
	
	public FileVO selectFileBySeq(String fileSeq);
		
}

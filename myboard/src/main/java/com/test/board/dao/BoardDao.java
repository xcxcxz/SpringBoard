package com.test.board.dao;

import java.util.ArrayList;

import com.test.board.page.Paging;
import com.test.board.vo.BoardVO;

public interface BoardDao {
	
	//게시글 작성
	public int insertContent(BoardVO board);
	//게시글 전체조회
	public ArrayList<BoardVO> selectAll(Paging navi);
	//게시글 상세
	public BoardVO selectOne(String boardSeq);
	//게시글 삭제
	public int deleteContent(String boardSeq);
	//게시글 수정
	public int updateBoard(BoardVO board);
	//회원탈퇴시 모든게시물 수정
	public int deleteAllBoard(String id);
	//게시물 개수
	public int selectCount();

}

package com.test.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.mapper.BoardMapper;
import com.test.board.page.Paging;
import com.test.board.vo.BoardVO;
import com.test.board.vo.FileVO;
import com.test.board.vo.ReplyVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	SqlSession sqlSession;

	public int insertContent(BoardVO board) {

		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.insertContent(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public ArrayList<BoardVO> selectAll(String searchWord, Paging navi) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());
			list = mapper.selectAll(searchWord, rb);
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		}
		return list;
	}

	public BoardVO selectOne(String boardSeq) {
		BoardVO result = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.selectOne(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public int updateBoard(BoardVO board) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public int deleteContent(String boardSeq) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteContent(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public int deleteAllBoard(String id) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.deleteAllBoard(id);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public int selectCount(String searchWord) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.boardListCnt(searchWord);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public ArrayList<HashMap<String, String>> selectReply(String boardSeq) {
		ArrayList<HashMap<String, String>> result = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			result = mapper.selectReply(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public int insertReply(ReplyVO reply) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.insertReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public int insertFile(FileVO fvo) {
		int result = 0;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.insertFile(fvo);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public FileVO selectFile(String boardSeq) {
		FileVO result = null;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.selectFile(boardSeq);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}

		return result;
	}

	@Override
	public FileVO selectFileBySeq(String fileSeq) {
		FileVO result = null;

		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try {
			result = mapper.selectFileBySeq(fileSeq);
		}catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

}

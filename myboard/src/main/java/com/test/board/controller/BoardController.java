package com.test.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.board.page.Paging;
import com.test.board.service.BoardService;
import com.test.board.vo.BoardVO;
import com.test.board.vo.ReplyVO;

@Controller
public class BoardController {

	private static final int COUNTPERPAGE = 10;
	private static final int PAGEPERGROUP = 10;
	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO board, Model model, HttpSession session) {

		if (session.getAttribute("loginId") == null) {

			return "login";
		} else {
			String id = (String) session.getAttribute("loginId");
			board.setId(id);
			boardService.insertContent(board);
		}

		return "redirect:/getBoardlist";
	}

	@RequestMapping(value = "/getBoardlist", method = RequestMethod.GET)
	public String getBoard(Model model, @RequestParam(value="page", defaultValue="1") int page, String searchWord) {
		Paging navi= new Paging(COUNTPERPAGE, PAGEPERGROUP, page, boardService.selectCount(searchWord));
		model.addAttribute("list", boardService.selectAll(searchWord, navi));
		model.addAttribute("navi", navi);
		model.addAttribute("searchWord", searchWord);
		return "list";
	}

	@RequestMapping(value = "/contentDetail", method = RequestMethod.GET)
	public String boardDetail(String boardSeq, Model model) {

		model.addAttribute("board", boardService.selectOne(boardSeq));
		model.addAttribute("reply", boardService.selectReply(boardSeq));

		return "content";
	}

	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public String goUpdateBoard(String boardSeq, Model model) {
		model.addAttribute("board", boardService.selectOne(boardSeq));

		return "write";
	}

	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String boardUpdate(BoardVO board, HttpSession session) {

		if (session.getAttribute("loginId") == null) {
			return "login";
		} else {
			String loginId = (String) session.getAttribute("loginId");
			String id = boardService.selectOne(board.getBoardSeq()).getId();
			if (loginId.equals(id)) {	
				boardService.updateBoard(board);
			} else {
				return "redirect:/getBoardlist";
			}
		}
		return "redirect:/getBoardlist";
	}

	@RequestMapping(value = "/deleteContent", method = RequestMethod.POST)
	public String deleteContent(String boardSeq, HttpSession session) {
		if (session.getAttribute("loginId") == null) {
			return "login";
		} else {
			String loginId = (String) session.getAttribute("loginId");
			String id = boardService.selectOne(boardSeq).getId();
			if (loginId.equals(id)) {
				boardService.deleteContent(boardSeq);
			} else {
				return "redirect:/getBoardlist";
			}
		}
		return "redirect:/getBoardlist";
	}
	
	@RequestMapping(value = "/insertReply", method = RequestMethod.POST)
	public String insertReply(ReplyVO reply, HttpSession session) {
		if(session.getAttribute("loginId") == null) {
			return "login";
		}else {
			String id = (String) session.getAttribute("loginId");
			
			reply.setId(id);
			boardService.insertReply(reply);
			return "redirect:/contentDetail?boardSeq=" + reply.getBoardSeq();
			
		}
	}
}

package com.test.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.board.service.BoardService;
import com.test.board.vo.BoardVO;

@Controller
public class BoardController {

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
	public String getBoard(Model model) {
		model.addAttribute("list", boardService.selectAll());
		return "main";
	}

	@RequestMapping(value = "/contentDetail", method = RequestMethod.GET)
	public String boardDetail(String boardSeq, Model model) {

		model.addAttribute("board", boardService.selectOne(boardSeq));

		return "content";
	}
}

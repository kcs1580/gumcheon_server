package rptPjt.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import rptPjt.com.mapper.BoardMapper;
import rptPjt.com.model.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardMapper mapper;

	@RequestMapping("board.do")
	public String board(ModelMap modelMap) {
	int count = mapper.selectBoardCount();
	List<BoardVO> boards = mapper.selectBoards();
	
	modelMap.addAttribute("count",count);
	modelMap.addAttribute("boards",boards);
	return "board";
	}
	
	@RequestMapping("addBoard.do")
	public String addBoard(String title, String content, String writer) {
		mapper.insertBoard(title, content, writer);
		return "boardAdd";
	}
	
	@RequestMapping("setBoard.do")
	public String setBoard(int idx, String title, String content, String writer) {
		mapper.updateBoard(idx, title, content, writer);		
		return "boardSet";
	}
	
	@RequestMapping("removeBoard.do")
	public String removeBoard(int idx) {
		mapper.deleteBoard(idx);
		return "boardRemove";
	}
	
}

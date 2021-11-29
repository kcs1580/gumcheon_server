package rptPjt.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rptPjt.com.mapper.BoardMapper;
import rptPjt.com.model.BoardVO;

@Controller
public class RestBoardController {
	@Autowired
	private BoardMapper mapper;
	
	@RequestMapping("getBoards.do")
	@ResponseBody
	public List<BoardVO> getBoards(){ 		
	List<BoardVO> boards = mapper.selectBoards();
	return boards;
	}
	
	@RequestMapping("getBoard.do")
	@ResponseBody
	public BoardVO getBoard(int idx){ 		
	BoardVO board = mapper.selectBoard(idx);
	return board;
	}
	
	@RequestMapping("addBoard2.do")
	@ResponseBody
	public List<BoardVO> addBoard(){ 		
	List<BoardVO> boards = mapper.selectBoards();
	return boards;
	}
	
	@RequestMapping("setBoard3.do")
	@ResponseBody
	public List<BoardVO> setBoard(){ 		
	List<BoardVO> boards = mapper.selectBoards();
	return boards;
	}
	
	@RequestMapping("removeBoard4.do")
	@ResponseBody
	public List<BoardVO> removeBoard(){ 		
	List<BoardVO> boards = mapper.selectBoards();
	return boards;
	}
	
}

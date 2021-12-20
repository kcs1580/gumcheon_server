package gvoc.gfmc.kr.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gvoc.gfmc.kr.model.BoardVO;
import gvoc.gfmc.kr.service.serviceInterface.BoardService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 게시판 전체 조회
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<BoardVO>> getBoards() {

		ResponseEntity<List<BoardVO>> entity = null;
		try {
			entity = new ResponseEntity<>(boardService.selectBoards(), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

	// 게시판 읽기
	@RequestMapping(value = "{idx}", method = RequestMethod.GET)
	public ResponseEntity<BoardVO> getBoard(@PathVariable("idx") int idx) {
		ResponseEntity<BoardVO> entity = null;
		try {
			entity = new ResponseEntity<>(boardService.selectBoard(idx), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	// 게시판 등록
	@PostMapping(value = "/write")
	public ResponseEntity<String> addBoard(@RequestBody BoardVO vo) {
		ResponseEntity<String> entity = null;
		try {

			boardService.insertBoard(vo.getTitle(), vo.getContent(), vo.getWriter());
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 게시판 수정
	@RequestMapping(value="{idx}",method= {RequestMethod.PUT, RequestMethod.PATCH})
	
	public ResponseEntity<String> setBoard(@PathVariable("idx") int idx, @RequestBody BoardVO vo) {
		
		ResponseEntity<String> entity = null;
		try {
			vo.setIdx(idx);
			boardService.updateBoard(vo.getIdx(), vo.getTitle(), vo.getContent(), vo.getWriter());
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

	// 게시판 삭제
	@RequestMapping(value="{idx}", method=RequestMethod.DELETE)
	
	public ResponseEntity<String> removeBoard(@PathVariable("idx") int idx) {
		
		ResponseEntity<String> entity = null;
		try {
			
			boardService.deleteBoard(idx);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	
		return entity;
	}

	// 게시판 조회수증가
	@RequestMapping(value = "updateViewCnt/{idx}", method = RequestMethod.GET)
	public ResponseEntity<String> updateViewCnt(@PathVariable("idx") int idx) {

		ResponseEntity<String> entity = null;
		try {
			boardService.updateViewCnt(idx);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

}

package rptPjt.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rptPjt.com.mapper.BoardMapper;
import rptPjt.com.model.BoardVO;
import rptPjt.com.service.serviceInterface.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public int selectBoardCount() throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.selectBoardCount();
	}

	@Override
	public List<BoardVO> selectBoards() throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.selectBoards();
	}

	@Override
	public BoardVO selectBoard(int idx) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.selectBoard(idx);
	}

	@Override
	public int insertBoard(String title, String content, String writer) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.insertBoard(title, content, writer);
	}

	@Override
	public int updateBoard(int idx, String title, String content, String writer) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.updateBoard(idx, title, content, writer);
	}

	@Override
	public int deleteBoard(int idx) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.deleteBoard(idx);
	}

	@Override
	public int updateViewCnt(int idx) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.updateViewCnt(idx);
	}

}

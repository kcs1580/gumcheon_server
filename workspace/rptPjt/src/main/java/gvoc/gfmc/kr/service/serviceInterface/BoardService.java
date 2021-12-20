package gvoc.gfmc.kr.service.serviceInterface;

import java.util.List;

import gvoc.gfmc.kr.model.BoardVO;


public interface BoardService {

	int selectBoardCount() throws Exception;

	List<BoardVO> selectBoards() throws Exception;

	BoardVO selectBoard(int idx) throws Exception;

	int insertBoard(String title, String content, String writer) throws Exception;

	int updateBoard(int idx, String title, String content, String writer) throws Exception;

	int deleteBoard(int idx) throws Exception;

	int updateViewCnt(int idx) throws Exception;
}

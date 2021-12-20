package gvoc.gfmc.kr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import gvoc.gfmc.kr.model.BoardVO;

@Mapper
public interface BoardMapper {
	
	
	public int selectBoardCount();

	public List<BoardVO> selectBoards();

	public BoardVO selectBoard(@Param("idx") int idx);

	public int insertBoard(@Param("title") String title, @Param("content") String content,
			@Param("writer") String writer);

	public int updateBoard(@Param("idx") int idx, @Param("title") String title, @Param("content") String content,
			@Param("writer") String writer);

	public int deleteBoard(int idx);
	
	public int updateViewCnt(int idx);
}

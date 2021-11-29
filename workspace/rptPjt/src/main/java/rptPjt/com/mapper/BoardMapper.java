package rptPjt.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import rptPjt.com.model.BoardVO;

@Mapper
public interface BoardMapper {
public int selectBoardCount();
public List<BoardVO> selectBoards();
public BoardVO selectBoard(@Param("idx") int idx);

public void insertBoard(
	@Param("title") String title,
	@Param("content") String content,
	@Param("writer") String writer
);
public void updateBoard(@Param("idx") int idx, @Param("title") String title, @Param("content") String content,@Param("writer") String writer);
public void deleteBoard(int idx);
}

package rptPjt.com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import rptPjt.com.model.UserVO;

@Mapper
public interface UserMapper {
	public int selectUserCount();

	public List<UserVO> selectUsers();

	public UserVO selectUser(@Param("id") String id);

	public int insertUser(@Param("id") String id, @Param("password") String password,
			@Param("name") String name);

	public int updateUser(@Param("id") String id, @Param("password") String password, @Param("name") String name
		);

	public int deleteUser(String id);
	
}

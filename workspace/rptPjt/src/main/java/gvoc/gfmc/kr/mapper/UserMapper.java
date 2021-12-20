package rptPjt.com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import rptPjt.com.model.UserVO;

@Mapper
public interface UserMapper {
	

	public int deleteUser(@Param("id") String id);

	public UserDetails findById(@Param("id") String id);

	public UserDetails findByUsername(@Param("userNm") String userNm);

	public int insertUser(@Param("user") UserVO user);
	
}

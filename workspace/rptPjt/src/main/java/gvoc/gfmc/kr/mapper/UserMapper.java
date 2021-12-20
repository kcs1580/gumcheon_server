package gvoc.gfmc.kr.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import gvoc.gfmc.kr.model.UserInfoVO;

@Mapper
public interface UserMapper {
	

	public int deleteUser(@Param("id") String id);

	public UserDetails findById(@Param("id") String id);

	public UserDetails findByUsername(@Param("userNm") String userNm);

	public int insertUser(@Param("user") UserInfoVO user);
	
}

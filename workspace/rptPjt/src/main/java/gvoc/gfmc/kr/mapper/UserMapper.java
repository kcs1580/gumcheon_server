package gvoc.gfmc.kr.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import gvoc.gfmc.kr.model.UserInfoVO;

@Mapper
public interface UserMapper {
	
	public int deleteUser(@Param("id") String id);

	public UserInfoVO findById(@Param("id") String id);

	public UserInfoVO findByUsername(@Param("userNm") String userNm);

	public int insertUser(@Param("user") UserInfoVO user);

	public int pwInitApply(@Param("user") UserInfoVO user);
	
	public int chPw(@Param("user") UserInfoVO user);
	
	
	
	
}

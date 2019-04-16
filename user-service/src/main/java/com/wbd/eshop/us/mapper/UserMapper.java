package com.wbd.eshop.us.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.wbd.eshop.us.model.User;

/**
 * mybatis crud½Ó¿ÚÀà 
 * @author zgh
 *
 */
@Mapper
public interface UserMapper {
	
	@Select("select * from tb_user")
	public List<User> findAllUser();

}

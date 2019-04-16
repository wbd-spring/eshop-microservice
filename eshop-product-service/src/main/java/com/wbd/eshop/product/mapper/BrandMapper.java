package com.wbd.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wbd.eshop.product.model.Brand;

/**
 * 品牌curd
 * @author zgh
 *
 */
@Mapper
public interface BrandMapper {

	@Insert("insert into tb_brand(name,description) values(#{name},#{description})")
	public void add(Brand brand);
	
	@Update("update tb_brand set name=#{name},description=#{description} where id=#{id}")
	public void update(Brand brand);
	
	@Delete("delete from tb_brand where id=#{id}")
	public void deleteBrandById(Integer id);
	
	@Select("select * from tb_brand where id=#{id}")
	public Brand findBrandById(Integer id);
	
}

package com.wbd.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.wbd.eshop.product.model.Product;

/**
 * 品牌crud
 * @author zgh
 *
 */
@Mapper
public interface ProductMapper {

	@Insert("insert into tb_product(name,category_id,brand_id) values(#{name},#{categoryId},#{brandId})")
	@SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
	public void add(Product product);
	
	@Update("update tb_product set name=#{name},category_id=#{categoryId},brand_id=#{brandId} where id=#{id}")
	public void update(Product product);
	
	@Delete("delete from tb_product where id=#{id}")
	public void deleteProductById(Integer id);
	
	@Select("select * from tb_product where id=#{id}")
	@Results({
		@Result(column = "category_id",property = "categoryId"),
		@Result(column = "brand_id",property = "brandId")
	})
	public Product findProductById(Integer id);
}

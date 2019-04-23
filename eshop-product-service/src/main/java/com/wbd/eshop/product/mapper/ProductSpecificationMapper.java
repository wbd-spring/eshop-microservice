package com.wbd.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.wbd.eshop.product.model.ProductSpecification;

@Mapper
public interface ProductSpecificationMapper {
	@Insert("insert into tb_product_specification(name,value,product_id) values(#{name},#{value},#{productId})")
	@SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
	public void add(ProductSpecification productSpecification);
	
	@Update("update tb_product_specification set name=#{name},value=#{value},product_id=#{productId} where id=#{id}")
	public void update(ProductSpecification productSpecification);
	
	@Delete("delete from tb_product_specification where id=#{id}")
	public void deleteProductSpecificationById(Integer id);
	
	@Select("select * from tb_product_specification where id=#{id}")
	@Results({
		@Result(column ="product_id",property = "productId" )
	})
	public ProductSpecification getProductSpecificationById(Integer id);
}

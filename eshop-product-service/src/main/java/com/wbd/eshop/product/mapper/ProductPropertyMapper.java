package com.wbd.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wbd.eshop.product.model.ProductProperty;

@Mapper
public interface ProductPropertyMapper {

	
	
	@Insert("insert into tb_product_property(name,value,product_id) values(#{name},#{value},#{productId})")
    public void add(ProductProperty productProperty);
	
	@Update("update tb_product_property set name=#{name},value=#{value},product_id=#{productId} where id=#{id}")
	public void update(ProductProperty productProperty);
	
	@Delete("delete from tb_product_property where id=#{id}")
	public void deleteProductPropertyById(Integer id);
	
	@Select("select * from tb_product_property where id=#{id}")
	@Results({
		@Result(column = "product_id",property = "productId")
	})
	public ProductProperty getProductPropertyById(Integer id);
}

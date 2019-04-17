package com.wbd.eshop.price.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wbd.eshop.price.model.ProductPrice;

@Mapper
public interface ProductPriceMapper {

	@Insert("insert into tb_product_price(value,product_id) values(#{value},#{productId})")
	public void add(ProductPrice productPrice);
	
	@Update("update tb_product_price set value=#{value},product_id=#{productId} where id=#{id}")
	public void update(ProductPrice productPrice);
	
	@Delete("delete from tb_product_price where id=#{id}")
	public void deleteProductPriceById(Integer id);
	
	@Select("select * from tb_product_price where id=#{id}")
	@Results({
		@Result(column = "product_id",property = "productId")
	})
	public ProductPrice selectProductPriceById(Integer id);
	
}

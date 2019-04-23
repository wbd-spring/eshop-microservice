package com.wbd.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.wbd.eshop.product.model.ProductIntro;

@Mapper
public interface ProductIntroMapper {
	
	@Insert("insert into tb_product_intro(content,product_id) values(#{content},#{productId})")
	@SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    public void add(ProductIntro productIntro);
	
	@Update("update tb_product_intro set content=#{content},product_id=#{productId} where id=#{id}")
	public void update(ProductIntro productIntro);
	
	@Delete("delete from tb_product_intro where id=#{id}")
	public void deleteProductIntroById(Integer id);
	
	@Select("select * from tb_product_intro where id=#{id}")
	@Results({
		@Result(column = "product_id",property = "productId")
	})
	public ProductIntro getProductIntroById(Integer id);
}

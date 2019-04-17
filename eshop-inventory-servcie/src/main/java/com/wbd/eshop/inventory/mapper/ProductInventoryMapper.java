package com.wbd.eshop.inventory.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wbd.eshop.inventory.model.ProductInventory;

@Mapper
public interface ProductInventoryMapper {
	
	@Insert("insert into tb_product_inventory(value,product_id) values(#{value},#{productId})")
	public void add(ProductInventory productInventory);
	
	@Update("update tb_product_inventory set value=#{value},product_id=#{productId} where id=#{id}")
	public void update(ProductInventory productInventory);
	
	@Delete("delete from tb_product_inventory where id=#{id}")
	public void deleteProductInventoryById(Integer id);
	
	@Select("select *  from tb_product_inventory where id=#{id}")
	@Results({
		@Result(column = "product_id",property = "productId")
	})
	public ProductInventory selectProductInventoryById(Integer id);

}

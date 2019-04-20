package com.wbd.eshop.product.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.wbd.eshop.product.model.Category;

/**
 * 分类crud
 * @author zgh
 *
 */
@Mapper
public interface CategoryMapper {
	
  @Insert("insert into tb_category(name,description) values(#{name},#{description})")
  @SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
  public void add(Category category);
  
  @Update("update tb_category set name=#{name},description=#{description} where id=#{id}")
  public  void update(Category category);
  
  @Delete("delete from tb_category where id=#{id}")
  public void deleteCategoryById(Integer id);
  
  @Select("select * from tb_category where id=#{id}")
  public Category findCategoryById(Integer id);
  
  

}

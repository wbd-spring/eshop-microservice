package com.wbd.eshop.datasync.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * feign接口， 调用eshop-product-service对应的Controller的方法
 * @author jwh
 *
 */
@FeignClient(value="eshop-product-service")
public interface ProductService {

	@RequestMapping(value="/brand/findById",method=RequestMethod.GET)
	String findBrandById(@RequestParam("id") Integer id);
	
	@RequestMapping(value="/category/findById",method=RequestMethod.GET)
	String findCategoryById(@RequestParam("id") Integer id);

	@RequestMapping(value="/product/findById",method=RequestMethod.GET)
	String findProductById(@RequestParam("id") Integer id);
	
	@RequestMapping(value="/product-intro/findById",method=RequestMethod.GET)
	String findProductIntroById(@RequestParam("id") Integer id);
	
	@RequestMapping(value="/product-property/findById",method=RequestMethod.GET)
	String findProductPropertyById(@RequestParam("id") Integer id);
	
	@RequestMapping(value="/product-specification/findById",method=RequestMethod.GET)
	String findSpecificationById(@RequestParam("id") Integer id);
}

package com.wbd.eshop.product.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbd.eshop.product.model.Brand;
import com.wbd.eshop.product.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService bs;

	@RequestMapping("/add")
	public String add(Brand brand) {
		try {

			bs.addBrand(brand);

		} catch (Exception e) {
			return "add brand failure";
		}

		return "add brand success";
	}

	@RequestMapping("/update")
	public String update(Brand brand) {
		try {
			bs.updateBrand(brand);
		} catch (Exception e) {
			// TODO: handle exception
			return "update brand failure";
		}
		return "update brand success";
	}

	@RequestMapping("/delete")
	public String deleteBrandById(Integer id) {

		try {
			bs.removeBrandById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return "delete brand failure";
		}
		return "delete brand success";
	}
	
	@RequestMapping("/findById")
	public Brand findBrandById(Integer id) {
		return bs.getBrandById(id);
	}
}

package com.mapex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/add")
	public String addComplexKey() {
		ComplexKey complexKey = ComplexKey.builder().locale("de").name("att1").build();
		Map<ComplexKey, String> attributes = new HashMap<>();
		attributes.put(complexKey, "val1");

		Product pro = Product.builder().attributes(attributes).build();

		productRepository.saveAndFlush(pro);
		return "added";
	}

	@RequestMapping("/all")
	public List<Product> allComplexKey() {
		return productRepository.findAll();
	}

}

package demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.dao.ProductRepository;
import demo.entities.Product;
@CrossOrigin("*")
@RestController
public class ProductRestService {
	@Autowired
	private ProductRepository productRepository;
	@GetMapping(value = "/listProducts")
	public List<Product> listProduct(){
		return productRepository.findAll();
	}
	
	@GetMapping(value = "/listProducts/{id}")
	public Product getProduct(@PathVariable(name = "id")Long id){
		return productRepository.findById(id).get();
	}
	
	@PatchMapping(value = "/listProducts/{id}")
	public Product update(@PathVariable(name = "id")Long id,@RequestBody Product p){
		p.setId(id);
		return productRepository.save(p);
	}
	
	@PostMapping(value = "/listProducts")
	public Product save( Product p){
		return productRepository.save(p);
	}
	
	@DeleteMapping(value = "/listProducts/{id}")
	public void delete(@PathVariable(name = "id")Long id){
		productRepository.deleteById(id);
	}




}

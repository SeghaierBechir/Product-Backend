package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import demo.dao.ProductRepository;
import demo.entities.Product;

@SpringBootApplication
public class P1PoductCatApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RepositoryRestConfiguration configuration;

	public static void main(String[] args) {
		SpringApplication.run(P1PoductCatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Product.class);
		// TODO Auto-generated method stub
		productRepository.save(new Product(null,"MAC PRO",5200,12));
		productRepository.save(new Product(null,"PC HP",1400,23));
		productRepository.save(new Product(null,"Imprimantes HP",650,30));
		productRepository.save(new Product(null,"Smart PHONE S9",2300,13));
		productRepository.save(new Product(null,"IPHONE 8 PLUS",2500,8));
		
		productRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
		
	}

}

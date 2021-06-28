package demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import demo.entities.Product;
@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	@RestResource(path = "/byDesignation")
	public List<Product> findByDesignationContains(@Param("mc")String des);
	@RestResource(path = "/byDesignationPage")
	public Page<Product> findByDesignationContains(@Param("mc") String des,Pageable pageable);

}

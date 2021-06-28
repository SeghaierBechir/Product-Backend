package demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1",types = Product.class)
public interface ProductProjection {
	public double getPrice();
	public String getDesignation();

}

package springmvc_product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_product.model.Product;
import springmvc_product.repository.ProductRepository;

@Service
public class ProductService
{
	@Autowired
	private ProductRepository productrepo;
	
	public void saveProduct(Product pro)
	{
		productrepo.saveProduct(pro);
		
	}
	
	public List<Product> displayProduct()
	{
		List<Product> list = productrepo.displayAll();
		return list;
	}

	public void updateProduct(int pId,String pName, int pPrice)
	{
		productrepo.updateProductById(pId, pName, pPrice);
	}
	
	public void deleteProduct(int pId)
	{
		productrepo.deleteProductById(pId);
	}
	
}

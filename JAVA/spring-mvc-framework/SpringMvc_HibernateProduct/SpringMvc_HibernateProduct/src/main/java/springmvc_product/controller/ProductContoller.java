package springmvc_product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc_product.model.Product;
import springmvc_product.service.ProductService;

@Controller
public class ProductContoller
{
	@Autowired
	private ProductService productService;
	
	//save
	@RequestMapping( value = "/saveProduct",method = RequestMethod.POST)
	public String saveProduct(HttpServletRequest req,HttpServletResponse res)
	{
		int productId=Integer.parseInt(req.getParameter("productId"));
		String productName=req.getParameter("productName");
		int productPrice=Integer.parseInt(req.getParameter("productPrice"));
		
		Product pro=new Product();
		pro.setProductId(productId);
		pro.setProductName(productName);
		pro.setProductPrice(productPrice);                      
		
		productService.saveProduct(pro);
		
		//ModelAndView mView = new ModelAndView();
		//mView.addObject("message", "Successufully Inserted..!");
		//mView.setViewName("success.jsp");
		return "redirect:/displayProduct";
		
		
	}
	
	//display all products
	@RequestMapping("/displayProduct")
	public ModelAndView displayAll() 
	{
		List<Product> product = productService.displayProduct();	
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("product", product);
		mView.addObject("message", "Product Details....!");
		mView.setViewName("display.jsp");
		return mView;
	}
	
	//update
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String update(HttpServletRequest req, HttpServletResponse res)
	{
		int productId=Integer.parseInt(req.getParameter("productId"));
		String productName=req.getParameter("productName");
		int productPrice=Integer.parseInt(req.getParameter("productPrice"));
		
		productService.updateProduct(productId, productName, productPrice);
		
		//ModelAndView mView = new ModelAndView();
		//mView.addObject("message", "Updated successfully..!");
		//mView.setViewName("success.jsp");
		return "redirect:/displayProduct";
	}
	
	
	//update
	@RequestMapping("/deletProduct")
	public String delete(HttpServletRequest req, HttpServletResponse res)
	{
		int productId=Integer.parseInt(req.getParameter("productId"));
		
		productService.deleteProduct(productId);
		
		//ModelAndView mView = new ModelAndView();
		//mView.addObject("message", "Deleted successfully..!");
		//mView.setViewName("success.jsp");
		return "redirect:/displayProduct";
	}
	
	
	@RequestMapping("/home")
	public String m1()
	{
		System.out.println("m1 method");
		return "redirect:/enjoy";
	}

	@RequestMapping("/enjoy")
	public String m2()
	{
		System.out.println("m2 method");
		return "";
	}
}

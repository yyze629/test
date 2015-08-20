package com.chao98.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import com.chao98.domain.Category;
import com.chao98.domain.Product;
import com.chao98.domain.User;
import com.chao98.service.interfaces.CategoryServiceInter;
import com.chao98.service.interfaces.ProductServiceInter;

 
public class Test  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext aContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		 	//测试spring包是否可用
		/* TestService ts  =(TestService) applicationContext.getBean("testService");
	   System.out.println(ts.getName());
	*/
		//测试hibernate包是否可用
		SessionFactory sessionFactory=(SessionFactory) aContext.getBean("sessionFactory");
		Session session=sessionFactory.openSession();
		 Transaction transaction=session.beginTransaction();
		 
		 /*	Product p=new Product();
		p.setPrice(30);
		p.setProductName("手机步步高");
		p.setRegisterDate(new Date());
		p.setRemark("很好很实惠");
		User user=new User();
		user.setPassword("admin");
		user.setUserid(114);
		user.setUsername("admin");
		session.save(user);
		transaction.commit();
		session.close();
	  */
		//测试接口
	 	ProductServiceInter productService=(ProductServiceInter) aContext.getBean("productService");
	 	CategoryServiceInter categoryService=(CategoryServiceInter) aContext.getBean("categoryService");
	 	Product p=new Product();
	 	p.setPrice(4000);
		p.setProductname("步步高手机");
		p.setRegisterdate(new Date());
		p.setRemark("真实惠");
		 Category category=new Category(); 
	 	 category.setCategoryname("内衣服饰"); 
		 // category.setProduct(p);
	  // categoryService.addCategory(category);
	//	productService.addProduct(p);  
	  }
	}

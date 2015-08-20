package com.chao98.service.imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource; 
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.chao98.basic.BasicService;
import com.chao98.domain.Product;
import com.chao98.domain.User;
import com.chao98.service.interfaces.ProductServiceInter;
@Transactional
public class ProductService extends BasicService implements ProductServiceInter {
	//验证用户登录
	public User checkUser(User u) { 
		String hql="from User where userid=? and password=?";
	    Object [] parameters={u.getUserid(),u.getPassword()};
		List list=this.executeQuery(hql, parameters);
	    if(list.size()==1){
			return (User) list.get(0);
		}else{
            return null;
		}
	}
	//显示所有商品信息
	 public List showProductList(int pageSize,int pageNow){
		 String hql="from Product order by productid"; 
		 return this.executeQueryByPage(hql, null, pageNow, pageSize) ;
	 }
 
     public int getPageCount(int pageSize){
    	 String hql="select count(*) from Product";
    	  this.getPageCount(hql, null, pageSize);
    	 return pageSize;
     }
	public void delProduct(Serializable id) {
        
	}

	public List<Product> showProduct() {
		 
		return null;
	}

	public void updProduct(Product p) { 

	}
	@SuppressWarnings("unchecked")
	public ArrayList<Product> selectByPname(String productname) { 
		String hql="from Product p where p.productname like '%" + productname + "%'"; 
		 ArrayList<Product>	productlist=(ArrayList<Product>) this.executeQuery(hql, null);
		return productlist;
	}
 
}

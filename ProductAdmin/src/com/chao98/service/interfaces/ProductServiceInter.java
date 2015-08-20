package com.chao98.service.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.chao98.basic.BasicServiceInter;
import com.chao98.domain.Product;
import com.chao98.domain.User;

public interface ProductServiceInter extends BasicServiceInter {
 //声明方法
	 public User checkUser(User u); 
	 public List showProductList(int pageSize,int pageNow);
	 public int getPageCount(int pageSize);
	//通过产品名称查询
	 public ArrayList<Product> selectByPname(String productname);
}

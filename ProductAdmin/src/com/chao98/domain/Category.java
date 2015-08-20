package com.chao98.domain;

import java.util.Set; 
public class Category implements  java.io.Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  private Integer categoryid;
  private String categoryname;
  @SuppressWarnings("unused")
  private Set<Product> product;
 
public Integer getCategoryid() {
	return categoryid;
}
public void setCategoryid(Integer categoryid) {
	this.categoryid = categoryid;
}
public String getCategoryname() {
	return categoryname;
}
public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}
public static long getSerialVersionUID() {
	return serialVersionUID;
}
public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}
   
  
}

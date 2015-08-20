package com.chao98.web.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {
   private Integer userid;
   private String password;
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
//------------------------------
private Integer productid ;   //这个是自增长的
private String productname;
private float price;
private String remark;
private Date registerdate;
private String categoryid;  
 
public Integer getProductid() {
	return productid;
}
public void setProductid(Integer productid) {
	this.productid = productid;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Date getRegisterdate() {
	return registerdate;
}
public void setRegisterdate(Date registerdate) {
	this.registerdate = registerdate;
}
public String getCategoryid() {
	return categoryid;
}
public void setCategoryid(String categoryid) {
	this.categoryid = categoryid;
}
 
 
   
}

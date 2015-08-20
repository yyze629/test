package com.chao98.domain;

import java.util.Date;

import com.chao98.domain.Category;
 public class Product implements  java.io.Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer productid; 
		private String productname;
		private float price;
		private String remark;
	    private Date registerdate;
	    private Category category;
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
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public static long getSerialVersionUID() {
			return serialVersionUID;
		}
 
  
}

package com.chao98.web.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SelectByNameForm extends ActionForm {
   private String productname;

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
  } 
}

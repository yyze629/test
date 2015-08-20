package com.chao98.web.actions;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping; 
import com.chao98.service.interfaces.CategoryServiceInter;
import com.chao98.service.interfaces.ProductServiceInter;
import com.chao98.web.forms.SelectByNameForm;

public class SelectByNameAction extends Action {
	   private ProductServiceInter productService ;
	    private CategoryServiceInter categoryService;

	    public CategoryServiceInter getCategoryService() {
			return categoryService;
		}
		public void setCategoryService(CategoryServiceInter categoryService) {
			this.categoryService = categoryService;
		}
		public ProductServiceInter getProductService() {
	    	return productService;
	    }
	    public void setProductService(ProductServiceInter productService) {
	    	this.productService = productService;
	    }
    @SuppressWarnings("unchecked")
	@Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    		throws Exception {
     	SelectByNameForm sbf=(SelectByNameForm)form;
   	    String productname=sbf.getProductname();  
    	request.setCharacterEncoding("GBK");response.setContentType("text/jsp;charset=GBK");
        System.out.println(productname); 
    	System.out.println(productname);
    	sbf.setProductname(null);
    	 ArrayList<com.chao98.domain.Product> productlist=productService.selectByPname(productname);
    	HttpSession session = request.getSession(); 
    	if(productname!=null){
    		session.setAttribute("productlist", productlist);
    	}else if(productlist.isEmpty() || productlist==null){
    		productlist=(ArrayList<com.chao98.domain.Product>) productService.showProductList(3, 1);
    		 
    		session.setAttribute("productlist", productlist);
    	}
       return mapping.findForward("success");
    }
}

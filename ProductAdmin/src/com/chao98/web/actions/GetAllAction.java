package com.chao98.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.chao98.domain.Product;
import com.chao98.service.interfaces.CategoryServiceInter;
import com.chao98.service.interfaces.ProductServiceInter;

public class GetAllAction extends Action {
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
	 
	  String s_pageNow=request.getParameter("pageNow");
		System.out.println(s_pageNow);
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		 
		 List<Product> productList=productService.showProductList(12,  pageNow);
		//  productService.getPageCount(3);//调用接口的pageCount接口--在去调用pageCount方法--然后去查询基础类的那个方法
		 request.getSession().setAttribute("productlist", productList);
        HttpSession session = request.getSession();
        session.setAttribute("productlist", productList);
		 int pageCount=productService.getPageCount(6);
	     	 session.setAttribute("pageCount", pageCount); 
	     	 request.setAttribute("pageCount", pageCount);
		  return mapping.findForward("getAll");
  }
}

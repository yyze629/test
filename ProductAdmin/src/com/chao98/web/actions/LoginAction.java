package com.chao98.web.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.chao98.domain.Category;
import com.chao98.domain.Product;
import com.chao98.domain.User;
import com.chao98.service.interfaces.CategoryServiceInter;
import com.chao98.service.interfaces.ProductServiceInter;
import com.chao98.web.forms.UserForm;

public class LoginAction extends DispatchAction {
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
 
 
public ActionForward login(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception { 
	UserForm uf=(UserForm)form;
	 
	 User user=new User();
	 user.setUserid(uf.getUserid());
	 user.setPassword(uf.getPassword());
	 user=productService.checkUser(user); 
	String password= uf.getPassword();
	 // System.out.println(uf.getPassword()+"\t"+uf.getUserid());
	if(user!=null){
		request.getSession().setAttribute("user", user);
		return mapping.findForward("ok");
	}else{
		return mapping.findForward("err");
	}
   }
//退出登录
public ActionForward logout(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {  
	  request.removeAttribute("user"); 
	 return mapping.findForward("logout");
   }
   public ActionForward addProUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {  
		 return mapping.findForward("goAddProUi");
	   }
   //添加商品
public ActionForward addPro(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
         UserForm uf=(UserForm)form; 
         System.out.println("price="+uf.getPrice());
         System.out.println("remark="+uf.getRemark());
         System.out.println("product_name=:"+uf.getProductname());
         System.out.println("category_id="+uf.getCategoryid());
        // Category category=new Category();
         Product product=new Product();
         product.setPrice((Float)uf.getPrice());//这里也可能出错
         product.setRegisterdate(new java.util.Date()); 
         product.setRemark(uf.getRemark());
         product.setProductname(uf.getProductname());
         product.setCategory((Category)categoryService.findById(Category.class, Integer.parseInt(uf.getCategoryid())));	 
         try{
         productService.add(product);
         }catch (Exception e) { 
            return mapping.findForward("operErr"); 
         }
            return mapping.findForward("operOk");
	 }
//返回主界面
public ActionForward goMainFrame(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception { 
	String user=(String) request.getAttribute("user");
	if(user!=null){
	     return mapping.findForward("ok");
	}else{
		return mapping.findForward("err");
	   }
	 }
//显示商品列表
@SuppressWarnings("unchecked")
public ActionForward goListPro(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)
	throws Exception {  
	String s_pageNow=request.getParameter("pageNow");
	System.out.println(s_pageNow);
	int pageNow=1;
	if(s_pageNow!=null){
		pageNow=Integer.parseInt(s_pageNow);
	}
	 List<Product> productList=productService.showProductList(6,  pageNow);
	//  productService.getPageCount(6);//调用接口的pageCount接口--在去调用pageCount方法--然后去查询基础类的那个方法
	 request.setAttribute("productlist", productList);
	 int pageCount=productService.getPageCount(6); 
	  request.setAttribute("pageCount", pageCount);
	 return mapping.findForward("goListPro");
 }
 //删除商品
 public ActionForward delPro(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
	   String delId=request.getParameter("id");  
	   System.out.println(delId);
	  String user=(String) request.getAttribute("user");
    try{
	 //  if(user!=null){
	          productService.delById(Product.class, Integer.parseInt(delId));
		// }else{
			// return mapping.findForward("err");
		// }
	 }catch (Exception e) {
		  return mapping.findForward("operErr");
	}
	      return mapping.findForward("operOk");
  }
//跳转到修改商品界面UpdPro
 public ActionForward goUpdProUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
	 String id=request.getParameter("id");
	 Product product=(Product) productService.findById(Product.class, Integer.parseInt(id));
	    request.setAttribute("product", product);
	 return mapping.findForward("goUpdProUi");
		 }
 //修改商品
    public ActionForward UpdPro(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception { 
	 	    UserForm uf=(UserForm)form;
	 	   //看看能不能取到值 
	 	    System.out.println("categoryid="+uf.getCategoryid());
	 	    System.out.println("productname"+uf.getProductname());
	 	    System.out.println("price="+uf.getPrice());
	 	    System.out.println("remark="+uf.getRemark());
	 	    System.out.println("registerdate="+uf.getRegisterdate()); 
	 	    Product product=new Product();
	 	     product.setProductid(uf.getProductid());  
	         product.setProductname(uf.getProductname());
	         product.setPrice((Float)uf.getPrice()); 
	         product.setRemark(uf.getRemark());
	         product.setRegisterdate(new java.util.Date()); 
	         product.setCategory((Category)categoryService.findById(Category.class, Integer.parseInt(uf.getCategoryid())));	 
	         //String user=(String) request.getAttribute("user");
	         try{ 
	           productService.update(product); 
	       }catch (Exception e) { 
	    	   return mapping.findForward("operErr");
		   } 
	         return mapping.findForward("operOk");
		 } 
}

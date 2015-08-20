package com.chao98.basic;

import java.io.Serializable;
import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public abstract class BasicService implements BasicServiceInter {
    private SessionFactory sessionFactory;
    
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	  public Object uniqueQuery(String hql,Object []parameters){
		 Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		  if(parameters!=null && parameters.length>0){
			  for(int i=0;i<parameters.length;i++){
				  query.setParameter(i, parameters[i]);
			  }
		  }
		 return query.uniqueResult();
}
 // 得到hql,返回pageCount
		public int getPageCount(String hql, Object[] paramaters, int pageSize) {
		   Object object=this.uniqueQuery(hql, paramaters);
		   int rowCount=Integer.parseInt((object.toString()));
		      if(rowCount%pageSize==0){ 
			      return (rowCount-1)/pageSize;
		      }else{ 
			      return (rowCount-1)/pageSize+1;
		      }
		}
//实现BasicServiceInter接口
	public void add(Object object) { 
        this.sessionFactory.getCurrentSession().save(object);
	}
//查询
	public List executeQuery(String hql, Object[] parameters) { 
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		 if(parameters!=null&&parameters.length>0){
			 for(int i=0;i<parameters.length;i++){
				 query.setParameter(i, parameters[i]);
			 }
		 }
		return query.list();
	}
//分页
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageNow, int pageSize) { 
		Query query=this.sessionFactory.openSession().createQuery(hql);
		 if(parameters!=null&&parameters.length>0){
			 for(int i=0;i<parameters.length;i++){
				 query.setParameter(i, parameters[i]);
			 }
		 }
		return query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize).list(); 
	}
  public void delById(Class clazz ,java.io.Serializable id){
	  Session session=this.sessionFactory.getCurrentSession();
	  session.delete(this.findById(clazz, id));
  }
	    
	public List executeUpdate(String hql, Object[] parameters) {  
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		 this.sessionFactory.getCurrentSession().createQuery(hql); 
		return null; 
	}

	public Object findById(Class clazz, Serializable id) { 
		return this.sessionFactory.getCurrentSession().get(clazz, id);
	 } 
	  public void update(Object object){
		   this.sessionFactory.getCurrentSession().update(object);
	  }
}

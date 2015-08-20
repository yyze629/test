package com.chao98.basic;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public interface BasicServiceInter {
 //声明一些常用方法  
	//通过id获取一个对象
	 public Object findById(Class clazz,java.io.Serializable id);
	//查询方法
	  public List executeQuery(String hql,Object [] parameters);
	 //分页
	  public List executeQueryByPage(String hql,Object [] parameters,int pageNow,int paegSize);
	  //添加
	   public void add(Object object);
	   //修改一个对象
	   public void update(Object object);
	   public List executeUpdate(String hql,Object []paramaters);
     // 返回一个对象的操作
	   public Object uniqueQuery(String hql,Object []parameters);
	     //得到hql返回pageCount
	   public int getPageCount(String hql,Object []paramaters,int pageSize);
	   //根据id删除对象
	    public void delById(Class clazz,java.io.Serializable id);
	    
  }

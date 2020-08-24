package com.neusoft.elm.dao;

import com.neusoft.elm.po.Admin;

import java.sql.SQLException;

public interface IAdminDao
{
/**
 *1.管理员登录
 *   0)管理员添加---
 *   1）管理员登录
 **/
   public int add(Admin admin);
   public Admin findByName(String name);

}

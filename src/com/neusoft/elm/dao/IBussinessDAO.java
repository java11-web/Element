package com.neusoft.elm.dao;

import com.neusoft.elm.po.Bussiness;

public interface IBussinessDAO {
    public int add(Bussiness bussiness);
    public Bussiness findByName(String name);


}

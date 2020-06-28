package com.spring.mvc.impel;

import com.spring.mvc.service.IDataService;

/**
 * 真实业务类
 */
public class UserImpel implements IDataService {
    @Override
    public void add() {
        System.out.println("添加一则用户数据");
    }

    @Override
    public void modify() {
        System.out.println("修改一则用户数据");
    }

    @Override
    public void delete() {
        System.out.println("删除一则用户数据");
    }

    @Override
    public void search() {
        System.out.println("查找一则用户数据");
    }
}

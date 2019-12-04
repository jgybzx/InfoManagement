package com.jgybzx.service;

import com.jgybzx.dao.PeoDao;
import com.jgybzx.entity.People;

import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/4 10:48
 * @Description: 对dao层读出的数据进行操作
 * @version:
 */
public class PeoService {
    private static PeoDao dao = new PeoDao();

    public  void add(People people) {
        dao.insert(people);
    }

    public  void delete(String id) {
        dao.delete(id);
    }

    public  void update(People people) {
        dao.update(people);
    }
    public List<People>  select(){
        List<People> list = dao.select();
        return list;
    }
    public  People selectById(String id){
        People people = dao.selectById(id);
        return people;
    }
}

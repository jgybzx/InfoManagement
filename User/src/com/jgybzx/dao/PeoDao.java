package com.jgybzx.dao;

import com.jgybzx.Utils.dataUtils;
import com.jgybzx.entity.People;
import sun.plugin.javascript.navig.LinkArray;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: guojy
 * @date: 2019/11/30 20:57
 * @Description: 从文件中获取数据
 * @version:
 */
public class PeoDao {
    private static final String PATH = "E:\\heimaIt\\JavaSE就业\\FileIO操作目录\\三层架构用户信息展示\\信息存储.txt";

    //因为每次都需要 读 dataUtils.read(PATH, People.class);
    // 写dataUtils.writeList(PATH, list).所以可以把这俩封装成两个方法
    private List<People> get() {
        return dataUtils.read(PATH, People.class);
    }

    private void set(List<People> list) {
        dataUtils.write(list, PATH);
    }

    //查询全部
    public List<People> select() {
        return get();
    }

    //根据用户id查询
    public People selectById(String id) {
        List<People> list = get();
        People p = list.stream().filter(people -> people.getUserId().equals(id)).findFirst().orElse(null);
        return p;
    }

    //新增
    public void insert(People people){
        List<People> list = get();
        list.add(people);
        set(list);
    }
    //删除
    public void delete(String id){
        List<People> list = get();
        list.removeIf(people -> people.getUserId().equals(id));
        set(list);
    }
    //修改
    public void update(People people){
        List<People> list = get();
        list = list.stream().map(p -> p.getUserId().equals(people.getUserId()) ? people : p).collect(Collectors.toList());
        set(list);
    }
}

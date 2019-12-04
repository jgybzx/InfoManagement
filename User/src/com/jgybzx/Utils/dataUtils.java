package com.jgybzx.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgybzx.Constant.Constant;
import com.jgybzx.entity.People;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: guojy
 * @date: 2019/12/4 9:37
 * @Description: 将对象集合转化为json格式字符串, 储存在文件中
 * @version:
 */
public class dataUtils {
    private static ObjectMapper jackson = new ObjectMapper();
    private static final String PATH = "E:\\heimaIt\\JavaSE就业\\FileIO操作目录\\三层架构用户信息展示\\信息存储.txt";

    /**
     * 将对象集合转化为json格式字符串, 储存在文件中
     *
     * @param list 集合对象
     * @param path 文件路径
     * @param <T>  集合对象类型
     */
    public static <T> void write(List<T> list, String path) {
        //将集合转化为json
        try {
            String objStr = jackson.writeValueAsString(list);
            //将字符串写入文件
            FileUtils.writeStringToFile(new File(path), objStr, Constant.CHARSET);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("写入成功");
    }

    /**
     * 获取文件中 对象的json 格式字符串,转换为list对象
     *
     * @param path   文件路径
     * @param tClass 预计要转换的list中的对象元素的类型
     * @param <T>    泛型
     * @return 集合
     */
    public static <T> List<T> read(String path, Class<T> tClass) {
        List<T> list = null;
        try {
            String objStr = FileUtils.readFileToString(new File(path), Constant.CHARSET);
            //获取文件中 对象的类型
            JavaType javaType = jackson.getTypeFactory().constructParametricType(List.class, tClass);
            list = jackson.readValue(objStr, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //启动测试
    @Test//添加
    public void add() {
        //准备测试数据
        List<People> list = new ArrayList<>();
        list.add(new People("1", "刘一", "123", 10));
        list.add(new People("2", "张三", "133", 10));
        list.add(new People("3", "李四", "123", 10));

        //调用方法
        dataUtils.write(list, PATH);
        System.out.println("添加成功");
    }

    @Test//删除,查出全部数据,按照条件删除,再写入全部数据
    public void delete(){
        //按照id删除
        String id =  "1";
        List<People> list = dataUtils.read(PATH, People.class);
        list.removeIf(people -> people.getUserId().equals(id));
        //写入
        dataUtils.write(list,PATH);
        System.out.println("删除成功");
    }
    @Test//修改
    public void update(){
        //准备修改的对象
        People people = new People("3", "李四第二次修改", "jgybzx", 10);
        //读出全部 数据
        List<People> list = dataUtils.read(PATH, People.class);
        //修改数据
        //list=list.stream().map(people1 -> people.getUserId().equals(people1.getUserId())?people:people1).collect(Collectors.toList());
        for (People p : list) {
            if (p.getUserId().equals(people.getUserId())){
                p.setUserName(people.getUserName());
                p.setUserPass(people.getUserPass());
                p.setUserAge(people.getUserAge());
            }
        }
        dataUtils.write(list,PATH);
        System.out.println("修改成功");
    }
    @Test//全部查询
    public void select(){
        List<People> list = dataUtils.read(PATH, People.class);
        System.out.println(list);
    }
    @Test//按照id查询
    public void selectById(){
        String id = "1";
        List<People> list = dataUtils.read(PATH, People.class);
        People p = list.stream().filter(people -> people.getUserId().equals(id)).findFirst().orElse(null);
        System.out.println(p);
    }
}

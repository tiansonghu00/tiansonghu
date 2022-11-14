package com.tian;

import org.junit.Test;

import java.util.*;

public class Homework015 {
    //定义泛型类DAO<T>,在其中定义一个Map成员变量，Map键为String类型，值为T类型
    //分别创建以下方法public void save(String id T entity)保存T类型对象到Map成员变量中
    //public T get(String id)从map中获取id对应的对象
    //public void update(String id , T entity)替换map中key为id的内容，改为entity对象
    //public List<T> list()返回map中存放的所有T对象
    //public void delete(String id)删除指定id对象
    public static void main(String[] args) {

    }
    @Test
    public void testList() {
        DAO<User> dao = new DAO<>();
        dao.save("001",new User(1,20,"jack"));
        dao.save("002",new User(2,30,"tom"));
        dao.save("003",new User(3,40,"smith"));
        List<User> list = dao.list();
        System.out.println(list);
    }
//创建DAO对象，分别调用其方法来操作user对象
class DAO<T> {
    private Map<String, T> map = new HashMap<>();
    public T get(String id) {
        return map.get(id);
    }
    public void update(String id , T entity) {
        map.put(id, entity);
    }
    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            list.add(get(key));
        }
        return list;
    }
    public void delete(String id) {
        map.remove(id);
    }
    public void save(String id,T entity) {
        map.put(id, entity);
    }
}
//定义一个user类，成员变量int类型，id，年龄，string类型名字
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
}
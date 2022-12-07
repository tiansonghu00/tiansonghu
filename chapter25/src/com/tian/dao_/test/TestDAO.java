package com.tian.dao_.test;

import com.tian.dao_.dao.ActorDAO;
import com.tian.dao_.domain.Actor;
import org.testng.annotations.Test;

import java.util.List;

public class TestDAO {
    //测试ActorDAO对actor表CRUD操作
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        //查询
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?",Actor.class,1);
        System.out.println("=========查询结果==========");
        for (Actor actor :actors) {
            System.out.println(actor);
        }
        //查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class,2);
        System.out.println("========查询单行结果============");
        System.out.println(actor);

        //查询单行单列
        Object o = actorDAO.queryScalar("select * from actor where id = ?",2);
        System.out.println("==========查询单行单列========");
        System.out.println(o);
        //dml操作
        int update = actorDAO.update("insert into actor values(null,'张三','男','1987-06-04','2561')");
        System.out.println(update > 0?"成功":"失败");
    }
}

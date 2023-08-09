package com.tjetc;


import com.tjetc.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class Test2 {
    @Autowired
    private RedisTemplate<String ,Object> redisTemplate;
    @Test
    public void testPerson(){
        ValueOperations opsForValuse = redisTemplate.opsForValue();
        Person p = new Person();
        p.setName("张三");
        p.setAge(20);
        opsForValuse.set("p1",p);
//        取值
        Person p1 = (Person) opsForValuse.get("p1");
        System.out.println(p1);
    }
}

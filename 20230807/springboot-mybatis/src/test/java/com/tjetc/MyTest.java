package com.tjetc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.*;

@SpringBootTest
public class MyTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString() {
//        可以操作string类型key和value
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
//        set
        opsForValue.set("str", "123");
//        get
        String value = opsForValue.get("str");
        System.out.println(value);
    }

    @Test
    public void testList() {
        ListOperations<String, String> opsForList = stringRedisTemplate.opsForList();
        opsForList.leftPush("myList", "10");
        opsForList.leftPushAll("myList", "20", "30", "40");
        opsForList.rightPushAll("myList", "100", "200", "300");
//        获取所有（从第一个开始到最后一个）
        List<String> myList = opsForList.range("myList", 0, -1);
        System.out.println(myList);
    }

    @Test
    public void testHash() {
        //hash类型
        HashOperations<String, Object, Object> opsForHash = stringRedisTemplate.opsForHash();
        opsForHash.put("person", "id", 1);
        Map<String, String> map = new HashMap<>();
        map.put("name", "zhang");
        map.put("age", "20");
        map.put("email", "dsadsa@163.com");
        opsForHash.putAll("person", map);
//       根据key和多个字段名获取多个字段值
        List<Object> fieldNames = Arrays.asList("id", "name", "age", "email");
        List<Object> personFiledValues = opsForHash.multiGet("person", fieldNames);
        System.out.println(personFiledValues);
    }

    @Test
    public void testSet() {
        //set类型
        SetOperations<String, String> opsForSet = stringRedisTemplate.opsForSet();
        opsForSet.add("mySet", "k1", "k2", "k3", "k4", "k1", "k2");
        Set<String> mySet = opsForSet.members("mySet");
        for (String s : mySet) {
            System.out.println(s);
        }
    }

    @Test
    public void testZSet() {
//        zset类型
        ZSetOperations<String, String> opsForZSet = stringRedisTemplate.opsForZSet();
        opsForZSet.add("myZSet", "苹果手机", 100);
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();
        DefaultTypedTuple tuple1 = new DefaultTypedTuple("华为手机", 120.0);
        DefaultTypedTuple tuple2 = new DefaultTypedTuple("小米手机", 90.0);
        tuples.add(tuple1);
        tuples.add(tuple2);
        opsForZSet.add("myZSet",tuples);
        Set<ZSetOperations.TypedTuple<String >> myZSetValues = opsForZSet.rangeWithScores("myZSet",0,-1);
        for (ZSetOperations.TypedTuple<String > myZSetValue : myZSetValues) {
            System.out.println(myZSetValue);
        }
    }
}

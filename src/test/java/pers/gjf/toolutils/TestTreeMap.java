package pers.gjf.toolutils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import pers.gjf.toolutils.bean.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>File: TestTreeMap.java </p>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Create By: 2021/06/02 08:58 </p>
 * <p>Company: nbnope.cn </p>
 *
 * @author gjf.gu/921208155@qq.com
 * @version 1.0
 */
public class TestTreeMap
{
    public List<User> createUser()
    {
        List<User> users = new ArrayList<>();
        User user;
        int j = 1;
        Long k = 1L;
//        for (int i = 0; i <= 40; i++)
//        {
//            user = new User();
//            user.setId(1L);
//            user.setName("1");
//            user.setBirthDay("2010-01-0" + j);
//            users.add(user);
//            if (0 == i % 5)
//            {
//                j++;
//            }
//        }
//        for (int i = 0; i < 60; i++)
//        {
//            user = new User();
//            user.setId(1L);
//            user.setName("1");
//            user.setBirthDay("2010-01-" + j);
//            users.add(user);
//            if (0 == i % 5)
//            {
//                j++;
//            }
//        }
        for(int i = 0; i<100;i++)
        {
            user = new User();
            user.setId(k);
            user.setName("1");
            user.setBirthDay("2010-01-01");
            users.add(user);
            if(0==i%5)
            {
                k++;
            }
        }
        return users;
    }

    @Test
    public void TestTreeGroup() throws Exception
    {
        List<User> users = this.createUser();
        //根据id分组并进行倒序排序
        TreeMap<Long, List<User>> collect2 = users.parallelStream().collect(Collectors.groupingBy(User::getId, () -> new TreeMap<>((o1, o2) -> Math.toIntExact(o2 - o1)), Collectors.toList()));
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        for (Long key : collect2.keySet())
        {
            jsonObject = new JSONObject();
            jsonObject.put("time", key);
            jsonObject.put("data", collect2.get(key));
            jsonArray.add(jsonObject);
        }
        System.out.println(JSON.toJSONString(jsonArray));
    }

    @Test
    public void TestContttain()
    {
        Set<Object> set = new HashSet<>();
        for (int i = 0; i <= Integer.MAX_VALUE; i++){
            //时间复杂度为O(1)
            if (set.contains(i)){
                System.out.println("list contains "+ i);
            }
        }
    }
}

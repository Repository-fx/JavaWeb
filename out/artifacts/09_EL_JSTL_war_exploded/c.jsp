<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/9/29
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person=new Person();
        person.setName("安德鲁维金斯");
        person.setPhone(new String[]{"18610548989","13209907878","14387679753"});
        List<String> cities = new ArrayList<>();
        cities.add("北京");
        cities.add("上海");
        cities.add("南京");
        person.setCity(cities);
        Map<String,Object> map=new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("p",person);
    %>

    输出perosn： ${p} <br>
    输出person的name属性： ${p.name} <br>
    输出person的phone数组属性值：${p.phone[0]} <br>
    输出person的cities集合的元素值：${p.city} <br>
    输出person的cities集合中的个别元素值：${p.city[1]} <br>
    输出person的map集合：${p.map} <br>
    输出person的map中某个key的值：${p.map.key1}
</body>
</html>

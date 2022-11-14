package com.atguigu.pojo;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author fxStart
 * @create 2022-09-21-13:39
 */
public class Dom4jTest {
    @Test
    public void test1()  {
        //创建一个SAXReader输入流，去读取xml配置文件，生成document对象
        SAXReader saxReader=new SAXReader();
        try {
            Document doc = saxReader.read("src/books.xml");
            System.out.println(doc);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    //读取xml文件生成book类
    @Test
    public void test2() throws Exception {
        //1、读取books.xml文件
        SAXReader reader = new SAXReader();
        //在junit测试中，相对路径是用模块名开始算
        Document doc = reader.read("src/books.xml");
        //2、通过Document对象获取根元素
        Element rootElement = doc.getRootElement();
        System.out.println(rootElement);
        //3、通过根元素获取book标签对象
        //element和elements都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        //4、遍历，处理每个book标签转换为Book类
        for (Element book:books){
            Element nameElement = book.element("name");
//            System.out.println(nameElement.asXML());
            String nameText = nameElement.getText();
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            String snValue = book.attributeValue("sn");

            System.out.println(new Book(snValue,nameText, BigDecimal.valueOf(Double.parseDouble(priceText)),authorText));
        }
    }
}

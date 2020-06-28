package com.spring.mvc.test;

import com.spring.mvc.beans.HeiseiRider;
import com.spring.mvc.impel.UserImpel;
import com.spring.mvc.service.IDataService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Map;

public class SpringDemo {
    public static void main(String[] args) {
        String path = "web" + File.separator + "WEB-INF" + File.separator + "applicationContext.xml";
//        File file = new File(path);
//        try {
//            InputStream is = new FileInputStream(file);
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            is.transferTo(baos);
//            System.out.println(baos.toString());
//            baos.close();
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //File file = new File("res" + File.separator + "c3p0-config.xml");
        //System.out.println(file.exists());
        //todo ClassPathXmlApplicationContext 读取：要求 .xml 文件放在 src 文件夹下，编译成功会在输出 classes 文件夹下生成对应 .xml 文件
        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //todo FileSystemXmlApplicationContext 读取：是依据项目根目录（项目名），
        ApplicationContext context = new FileSystemXmlApplicationContext(path);
//        HeiseiRider rider1 = (HeiseiRider) context.getBean("heiseiRider1");
//        rider1.love();
//        //是依据项目根目录（项目名） deprecated
//        Resource resource = new FileSystemResource(path);
//        BeanFactory bf = new XmlBeanFactory(resource);
//        HeiseiRider rider = (HeiseiRider) bf.getBean("heiseiRider1");
//        rider.love();
//        HeiseiRider rider2 = (HeiseiRider) context.getBean("heiseiRider2");
//        Map<String, Integer> enemyNums = rider2.getEnemyNums();
//        for (Map.Entry<String, Integer> entry: enemyNums.entrySet()){
//            System.out.println(entry.getKey() + "'s number is " + entry.getValue());
//        }
//        rider2.love();
//        rider2.play();
//
//        HeiseiRider rider3 = (HeiseiRider) context.getBean("staticFactory1");
//        rider3.setMaleOwner("门矢士");
//        rider3.setFemaleOwner("光夏海");
//        rider3.love();
//
//        HeiseiRider rider4 = (HeiseiRider) context.getBean("staticFactory2");
//        rider4.setMaleOwner("如月弦太郎");
//        rider4.setFemaleOwner("美咲抚子");
//        rider4.love();

        //Spring 实现 AOP
        IDataService service = (IDataService) context.getBean("userImpel");
        service.add();

    }
}

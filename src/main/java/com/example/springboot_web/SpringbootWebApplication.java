package com.example.springboot_web;

import com.example.springboot_web.Config.MyConfig;
import com.example.springboot_web.bean.Pet;
import com.example.springboot_web.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootWebApplication {

    public static void main(String[] args) {
        //1.返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootWebApplication.class, args);
        //2.查看容器内组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String s:beanDefinitionNames){
            System.out.println(s);
        }
//        //单例
//        Pet tomcat1 = run.getBean("tomcat1", Pet.class);
//        Pet tomcat2 = run.getBean("tomcat1", Pet.class);
//        System.out.println("容器内组件调用多次是否用的同个对象"+(tomcat1==tomcat2));
//        //com.example.springboot_web.Config.MyConfig$$EnhancerBySpringCGLIB$$c7c05e38@17d238b1 springboot 增加过的类  代理类
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        User user01 = bean.user01();
//        User user02 = bean.user01();
//        System.out.println("proxyBeanMethods=true时，在配置类外面多次调user，都是容器中的单例对象吗？"+(user01==user02));
//
//        //用户类中的宠物
//        Pet pet = user01.getPet();
//        //容器中的宠物
//        Pet cat = run.getBean("tomcat1",Pet.class);
//        //组件依赖  proxyBeanMethods=true时为true,为false时false
//        System.out.println(pet==cat);

        System.out.println("=====================");

//        User zhangshang1 = run.getBean("zhangshang", User.class);
//        System.out.println(zhangshang1);
        //@ConditionalOnBean(name = "tomcat1") 当组件依赖在同个类里面时，加载顺序从上到下，所以tomcat1必须放在user01之前加载，才能生效
        boolean zhangshang2 = run.containsBean("zhangshang2");
        boolean zhangshang1 = run.containsBean("zhangshang1");
        boolean tomcat1 = run.containsBean("tomcat1");
        System.out.println(zhangshang2+""+zhangshang1+""+tomcat1);


        System.out.println("=======================");
        //@ImportResource("classpath:bean.xml") 将bean.xml中的组件引入容器中
        boolean userA = run.containsBean("userA");
        boolean petA = run.containsBean("petA");
        System.out.println(userA+"===="+petA);





    }

}

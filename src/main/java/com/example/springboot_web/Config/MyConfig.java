package com.example.springboot_web.Config;

import ch.qos.logback.core.db.DBHelper;
import com.example.springboot_web.bean.Car;
import com.example.springboot_web.bean.Pet;
import com.example.springboot_web.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration(proxyBeanMethods = true)
//full 模式(proxyBeanMethods = true) 用于有组件依赖的情况，每次调用时，springboot检查容器中是否存在组件 单例
//lite 模式(proxyBeanMethods = false) 轻量级模式 用于没有组件依赖的情况，每次调用时，springboot不检查容器中是否存在组件，启动快

//@Import({User.class, DBHelper.class})向容器中加入user和第三方包DBHelper两个组件 默认为全类名

//******@ConditionalOnBean(name = "tomcat1") 当组件依赖在同个类里面时，加载顺序从上到下，所以tomcat1必须放在user01之前加载，才能生效

@Import({User.class, DBHelper.class})
@ImportResource("classpath:bean.xml")

@EnableConfigurationProperties(Car.class)//1.开启Car配置绑定功能 2.将Car组件加载到容器中
public class MyConfig {

    //当容器中无组件名为“tomcat1”时才加载user02
    @ConditionalOnMissingBean(name = "tomcat1")
    @Bean(name = "zhangshang2")
    public User user02(){
        User user02 = new User("张三", 18);
        //组件依赖  user组件依赖了pet组件 //当 proxyBeanMethods = false 会检查报错
        user02.setPet(cat());
        return user02;
    }

    @Bean(name = "tomcat1")
    public Pet cat(){
        return new Pet("tomacat");
    }

    //当容器中有组件名为“tomcat1”时才加载user01
    @ConditionalOnBean(name = "tomcat1")
    @Bean(name = "zhangshang1")
    public User user01(){
        User user01 = new User("张三", 18);
        //组件依赖  user组件依赖了pet组件 //当 proxyBeanMethods = false 会检查报错
        user01.setPet(cat());
        return user01;
    }


}

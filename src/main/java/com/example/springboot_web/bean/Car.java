package com.example.springboot_web.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 1、第一种方式：只有把组件加载到容器中，才可以用到@ConfigurationProperties 所以@Component和@ConfigurationProperties要一起使用，实现配置绑定
 * 2、第二种方式：配置类中（MyConfig）加注解@EnableConfigurationProperties(Car.class)  再在Car类加上@ConfigurationProperties，此时就可以不用@Component
 */
//@Component
@ConfigurationProperties(prefix = "dreamcar")
public class Car {
    private String brand;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public Car() {
    }

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }
}

package com.mhj.demo.config;

import ch.qos.logback.core.db.DBHelper;
import com.mhj.demo.domain.Pet;
import com.mhj.demo.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;


/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *       Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *       Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *       组件依赖必须使用Full模式默认。其他默认是否Lite模式
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件，创建出的组件名默认是全类名
 *      例如：
 *          * Import User.class          -> 组件名：com.mhj.demo.domain.User
 *          * @Bean public User user01() -> 组件名：user01
 *
 *  如果容器中有"二狗子"这个组件，则MyConfig会被创建，否则不被创建
 *  如果容器中没有"三狗子"这个组件，则MyConfig会被创建，否则不被创建
 *  如果以"gouZi"作为判断条件是错误的，因为该判断会在MyConfig创建前进行，而"gouZi"是MyConfig创建后才有的组件
 */
@Configuration
@ConditionalOnMissingBean(name = "sanGouZi")
public class MyConfig {


    @Bean
    public Pet gouZi() { return new Pet("GouZi");}

    @Bean
    @ConditionalOnBean(name = "gouZi") //如果没有"gouZi"这个组件则不创建"user01"组件
    public User user01(){ return new User("mhj",24,taiDiGou()); }

    @Bean("fantuan")
    public Pet taiDiGou(){ return new Pet("fantuan"); }
}
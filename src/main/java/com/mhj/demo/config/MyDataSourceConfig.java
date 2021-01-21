package com.mhj.demo.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class MyDataSourceConfig {

    //org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration中有如下默认配置
    //@ConditionalOnMissingBean(DataSource.class) -> 则导入Hikari数据源
    @Bean
    @ConfigurationProperties("spring.datasource") //从yml文件中配置的spring.datasource中获取所需参数
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置druid的监控页功能
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> statViewServletBean
                = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        statViewServletBean.addInitParameter("loginUsername","mhj");
        statViewServletBean.addInitParameter("loginPassword","123");

        return statViewServletBean;
    }

    /**
     * webStatFilter 用于采集web-jdbc关联监控的数据
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean =
                new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("name","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }
}

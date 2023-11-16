package com.luoli.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//标志该类 Spring核心配置文件
@Configuration
//<context:component-scan base-package="com.luoli"/>
@ComponentScan("com.luoli")

@Import(DataSourceConfiguration.class)//导入其他配置类
public class SpringCofiguration {

}

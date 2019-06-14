package com.yyq.test.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations= {"classpath:config/springConfiguration.xml"}) //手动引入Spring的xml配置文件；SpringBoot中没有Spring的配置文件，也不能自动识别，所以只能通过注解手动引入
@Configuration  //必须注明这是一个Spring配置类，@ImportResource才能生效
public class SpringConfig {

}

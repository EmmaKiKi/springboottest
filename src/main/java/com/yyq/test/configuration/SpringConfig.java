package com.yyq.test.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 手动引入Spring的xml配置文件；SpringBoot中没有Spring的配置文件，也不能自动识别，所以只能通过注解手动引入
 * 可在写在启动类的上面，因为启动类已经包含了@Configuration注解，所以只需要加@ImportResource即可
 * SpringBoot推荐使用全注解的方式，向容器中添加组件，使用@Configuration+@Bean的方式
 *
 */
@ImportResource(locations= {"classpath:config/springConfiguration.xml"}) 
@Configuration  //必须注明这是一个Spring配置类，@ImportResource才能生效
public class SpringConfig {

}

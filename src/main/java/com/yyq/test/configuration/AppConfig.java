package com.yyq.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yyq.test.service.IndexService;

//@Configuration  //用在类上，用来标注一个类是Spring的配置类,用来代替之前的Spring配置文件
public class AppConfig {

	//@Bean   //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
	public IndexService indexService() {
		return new IndexService();
	}
}

package com.yyq.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.yyq.test.configuration.PersonPorperties;
import com.yyq.test.service.IndexService;

@RestController
public class IndexController {
	
	@Value(value = "${shuxing.name}")
	private String shuxingName;
	
	@Autowired
	PersonPorperties props;
	
	@Autowired
	IndexService indexService2;
	
	@RequestMapping("hello")
	public Map sayHello() {
		Map map =new HashMap();
		map.put("@Value得到的属性值", shuxingName);
//		map.put("@ConfigurationProperties得到的属性值",JSON.toJSONString(props));
		map.put("@ConfigurationProperties得到的属性值",props.toString());
		indexService2.sayHello();
		return map;
	}
}

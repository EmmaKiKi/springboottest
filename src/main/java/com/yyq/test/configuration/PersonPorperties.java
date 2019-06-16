package com.yyq.test.configuration;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.ToString;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties 注解：告诉springboot，这个类是用来将配置文件的相关属性与类的属性进行绑定的;
 * prefix属性：注明，配置文件中的哪个属性来映射到这个组件中
 * 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能
 * 
 *  @value是Spring的注解
 *  @ConfigurationProperties和@value的对比
 *  @ConfigurationProperties优点： 批量注入 语法松散 支持JSR303数据校验 支持复杂类型
 *  @ConfigurationProperties缺点： 不支持SpEl→Spring的表达式语言
 *  @Value优点：支持SpEl
 *  @value缺点：一个一个属性指定  语法严格 不支持数据校验 不支持复杂类型数据
 *  注意：配置文件yml还是properties他们都能获取到值；
 *  使用场景：
 *  只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；
 *  我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；
 *  
 *  
 *  @PropertySource：加载指定的配置文件， 配合@Value使用，注入属性值。可以一次性加载多个属性文件，e.g：
 *  
 *  
 *  属性文件加载顺序：
 *  springboot 文件加载顺序 一般默认加载application.propertise 或者 application.yml文件
   * 加载顺序：
   *       命令行
 *  ①优先加载带profile的文件，由jar包外（和jar包统计目录）到jar包内  。再加载不带profile的文件， 由jar包外（和jar包统计目录）到jar包内  
 *  ②file:./config (项目根目录下) 基本不使用  →不会被打进包内
 *  ③file:./   基本不使用 →不会被打进包内
 *  ④classpath:/config  经常使用
 *  ⑤classpath:/   经常使用
 *  优先级由高到低全部加载，优先级高的数据覆盖优先级低的数据
 *  spring会从classpath下的/config目录或者classpath的根目录查找application.properties或application.yml。
 *  /config优先于classpath根目录
 */
@Component  //只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能
//@ConfigurationProperties(prefix="person")  
//@ConfigurationProperties：SpringBoot提供 ，默认从全局配置文件中获取值；  resource目录下的applicaion.yml或者applicaion.properties,和@PropertySource可同时使用，但先加载默认配置文件的属性,后加载的配置内容，同名不生效
@PropertySource(value={"classpath:config/person.properties","classpath:config/parent.properties","classpath:config/parent2.yml"}, encoding="utf-8") 
//@PropertySource：Spring框架提供 ，加载指定的配置文件，配合@Value或@ConfigurationProperties使用，encoding属性指定编码格式
//@PropertySource(value={"file:C:\\workspace-SpringBoot\\test\\src\\main\\resources\\config\\parent.properties"}, encoding="utf-8") //使用绝对路径时，用file:
//@Validated
@Data
public class PersonPorperties {

	/**
	 * @Validated 用在类型、方法和方法参数上,但不能用于成员属性
	 * @Valid：可以用在方法、构造函数、方法参数和成员属性（field）上。
	 * 
	 * @Validated属于Spring Validation验证框架，是标准JSR-303的一个变种
	 * @Valid是标准JSR-303规范
	 * 
	 * @Validated有分组校验功能
	 * @Valid：没有分组功能，但可以用来嵌套验证
	 * 
	 * 用法：
	 * 在controller层的参数校验上，两者无太大区别
	 * 分组验证时使用@Validated
	 * 嵌套验证时使用@Valid
	 */
	
//	@Email
//	@Value("${person.name}")
	private String name;
	private String lastName;
	private Date birth;
	private Integer age;
	private Boolean boss;
	private Map<String,String> maps;
	//	@Value("${person.friends}")
	private List<String> friends;
	private DogProperties dog;
//	@Value("${mmm}")o
	private String hhh;
	//	@Value("${qqq}")
	private String qqq;
//	@Value("${xxx}")
	private String xxx;
	
}

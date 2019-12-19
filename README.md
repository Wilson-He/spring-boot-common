# web-common-validation

## 
基于Spring Boot 2.0+的个人通用框架。

## 依赖添加
	<dependency>
	    <groupId>com.github.wilson.swagger</groupId>
	    <artifactId>web-common-validation</artifactId>
	    <version>LATEST</version>
	</dependency>

## 快速开始
Application.java

	import StringListVO;
	import io.swagger.annotations.Api;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.validation.annotation.Validated;
	import org.springframework.web.bind.annotation.*;

	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.Pattern;

	/**
	 * Application
	 *
	 * @author Wilson
	 * @since 2018/11/17
	 */
	@RestController
	@RequestMapping("/")
	@Api
	@SpringBootApplication
	@Validated
	public class Application {
	    public static void main(String[] args) {
		SpringApplication.run(Application.class);
	    }

	    @GetMapping("/index")
	    public String index(@NotBlank @Pattern(regexp = "\\d+") @RequestParam String name){
		return name;
	    }
	    @GetMapping("/name")
	    public String name(@NotBlank @Pattern(regexp = "\\d+",message = "正则错误") @RequestParam String name){
		return name;
	    }

	    @PostMapping("/vo")
	    public String index(@Validated @RequestBody StringListVO vo){
		return "yes";
	    }
	}

application.yml

	web:
	  common:
	    validation:
	      msg-locale: zh_CN  #参数错误返回的信息语种
	    #  code-key: code     #参数错误返回码的key字符串命名,默认"code"
	    #  msg-key: error     #参数错误返回信息的key字符串命名，默认"msg"
	swagger: #swagger自动化配置，需加入swagger2-spring-boot-starter依赖
	  enabled: true
	  docket:
	    base-package: io.github.swagger.demo
	    
## 效果展示
当同一参数多于1个不符合校验规则则会随机返回一个错误信息，即name参数为空时可能返回"name不能为空"或自定义信息"正则错误"。自定义的校验信息会覆盖原注解固定校验信息，如@NotBlank(message = "名字不能为空")则将返回"名字不能为空"，无定义则会返回默认信息:参数名+错误信息(即"name不能为空")
![get参数校验](https://img-blog.csdnimg.cn/2019021119581427.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3oyODEyNjMwOA==,size_16,color_FFFFFF,t_70)
![post vo校验](https://img-blog.csdnimg.cn/20190211200058944.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3oyODEyNjMwOA==,size_16,color_FFFFFF,t_70)

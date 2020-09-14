package com.cpworkdemo.demo.web.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cpworkdemo.demo.conf.DataSourceConfig;
import com.cpworkdemo.demo.entity.Author;
import com.cpworkdemo.demo.service.AuthorRepository;


@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    // 注入对象
    @Autowired
    private Environment env;

    
    @GetMapping("/hello2")
    public String hello2() {
    	 // 读取配置
        String port = env.getProperty("server.port");
        return port;
    }
    
    // 注入配置
    @Value("${server.port}")
    private String port;

    @GetMapping("/hello3")
    public String hello3() {
        return port;
    }
    
    @Autowired
    private DataSourceConfig myConfig;

    @Autowired
    private AuthorRepository authorRepository;
    
    @RequestMapping("/hello4")
    public String hello4() {
    	System.out.println(authorRepository);
    	List<Author> list = authorRepository.queryByNickName("sahikari");
    	if(list.size()>0) {
    		Author author = list.get(0);
    		return author.getRealName();
    	}
		return "test";

    }
    

    @RequestMapping("/testEcharts")

    public ModelAndView test(){

        return new ModelAndView("Echars");//跟templates文件夹下的demo.html名字一样，返回这个界面

    }
    
    @RequestMapping(value="/sayHello",method = RequestMethod.GET)
    public String sayHello(){
    	return "Hello Spring Boot!";
    }

 

    @RequestMapping(value="/first",method = RequestMethod.GET)
    public ModelAndView firstDemo(){
        return new ModelAndView("test");//跟templates文件夹下的test.html名字一样，返回这个界面
    }

 

    @RequestMapping(value="/courseClickCount",method = RequestMethod.GET)
    public ModelAndView courseClickCountStat(){
        return new ModelAndView("demo");//跟templates文件夹下的demo.html名字一样，返回这个界面
    }

    
}

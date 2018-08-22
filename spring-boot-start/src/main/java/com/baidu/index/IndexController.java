package com.baidu.index;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
	
    @RequestMapping("/")
    public String index() {
        return "你好 这里是首页!";
    }
    

 	@RequestMapping("/thy")
    public ModelAndView  thymeleaf(Model model) {
 		model.addAttribute("name", "伟鹏");
 		return new ModelAndView("hello");
    }
 	
 

    
}

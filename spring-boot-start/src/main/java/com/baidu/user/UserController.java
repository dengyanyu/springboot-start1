package com.baidu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
  
 	@GetMapping(value = "list")
    public ModelAndView hello(Model model) {
 		Iterable<User> userList = userRepository.findAll();
 		
        model.addAttribute("userList", userList);
        return new  ModelAndView("user/list");
    }
 	
 	@GetMapping(value = "page")
    public ModelAndView page(User u,@RequestParam(defaultValue="10") int ps,@RequestParam(defaultValue="1") int pn,Model model) {
// 		Page<User> page = userRepository.findPage(PageRequest.of(pn-1, ps));
 		//创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("name", GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
                .withMatcher("des", GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("age")
                .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<User> ex = Example.of(u, matcher); 
        Page<User> page =userRepository.findAll(ex, PageRequest.of(pn-1, ps));
 		model.addAttribute("u", u);
        model.addAttribute("page", page);
        return new  ModelAndView("user/page");
    }
 	
 	@GetMapping(value = "toadd")
    public ModelAndView toadd(Model model) {
        return new  ModelAndView("user/toadd");
    }
 	@PostMapping("doadd")
 	public String doadd(User u) {
 		userRepository.save(u);
 		return "添加成功";
	}

    
}

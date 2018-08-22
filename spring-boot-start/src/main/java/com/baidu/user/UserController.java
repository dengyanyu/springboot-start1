package com.baidu.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
 	
// 	@GetMapping(value = "page")
//    public ModelAndView page(Model model) {
// 		Iterable<User> userList = userRepository.fin
// 		
//        model.addAttribute("userList", userList);
//        return new  ModelAndView("user/list");
//    }
 	
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

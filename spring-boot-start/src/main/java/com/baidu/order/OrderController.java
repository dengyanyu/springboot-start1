package com.baidu.order;

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
@RequestMapping("/order")
@RestController
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
  
 	 
 	@GetMapping(value = "page")
    public ModelAndView page(Od o,@RequestParam(defaultValue="10") int ps,@RequestParam(defaultValue="1") int pn,Model model) {
 		//创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("NO", GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
                .withMatcher("status", GenericPropertyMatchers.contains()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("dt") 
                .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        
//        
//        if (!StringUtils.isEmpty(o.getNO())) {
//        	matcher.withMatcher("NO", GenericPropertyMatchers.startsWith()); //姓名采用“开始匹配”的方式查询
//		}else {
//			matcher.withIgnorePaths("NO");
//		}
//        if (!StringUtils.isEmpty(o.getStatus())) {
//        	matcher.withMatcher("status", GenericPropertyMatchers.contains());//姓名采用“开始匹配”的方式查询
//		}else {
//			matcher.withIgnorePaths("status");
//		}
//                
//        matcher.withIgnorePaths("dt") 
//                .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉

        //创建实例
        Example<Od> ex = Example.of(o, matcher); 
        Page<Od> page =orderRepository.findAll(ex, PageRequest.of(pn-1, ps));
 		model.addAttribute("o", o);
        model.addAttribute("page", page);
        return new  ModelAndView("order/page");
    }
 	
 	@GetMapping(value = "toadd")
    public ModelAndView toadd(Model model) {
        return new  ModelAndView("order/toadd");
    }
 	@PostMapping("doadd")
 	public String doadd(Od o) {
 		orderRepository.save(o);
 		return "添加成功";
	}

    
}

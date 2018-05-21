package cn.edu.njust.demo.controller;

import cn.edu.njust.demo.service.DemoService;
import common.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Model {
    int age;
    String name;
}

@Controller
@RequestMapping("/first")
@Scope(value = "prototype")
public class DemoController {
    private Logger logger = Logger.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo")
    public ModelAndView handleDemo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo");
        return mv;
    }

    @RequestMapping("/demo2")
    public void handleDemo2(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("type=text/html;charset=UTF-8");
            response.getWriter().write("hello demo2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/demo3", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String handleDemo3() {
        Model model = new Model();
        model.age = 18;
        model.name = "Kerry";
        Model model2 = new Model();
        model2.age = 19;
        model2.name = "Angel";
//        return GsonUtil.toJson(model);
        return GsonUtil.toJson(Arrays.asList(model, model2));
    }

    @RequestMapping("/demo4")
    @ResponseBody
    public String handleDemo4(@RequestParam(required = false) Integer age) {
        Model model = new Model();
        model.age = 30;
        model.name = "Kerry";
        Model model2 = new Model();
        model2.age = 19;
        model2.name = "Angel";
        return GsonUtil.toJson(Arrays.asList(model, model2).stream().filter(x -> x.age > age).collect(Collectors.toList()));
    }

    @RequestMapping("/demo5")
    @ResponseBody
    public String handleDemo5(@RequestParam Map<String, String> params) {
        return GsonUtil.toJson(params);
    }

    @RequestMapping("/getDemoList")
    //@ResponseBody 返回String类型的json把注释去掉
    //Integer 不能改成int，如果没有url未带age参数，会把student_age置为null，基本类型置为null会出错，所以要用Integer
    public ModelAndView getDemoList(@RequestParam(value = "age", required = false) Integer student_age) {
//        try {
//            return GsonUtil.toJson(demoService.getDemoList(student_age));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            ModelAndView mv = new ModelAndView("jsonView");
            mv.addObject("name", "Hello Spring MVC");
            mv.addObject(demoService.getDemoList(student_age));
            mv.setView(new MappingJackson2JsonView());
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/getDemoList2/{name}")
    public ModelAndView getDemoList2(@PathVariable String name, @RequestParam(value = "age", required = false) Integer student_age) {
        ModelAndView mv = new ModelAndView("pathVariable");
        mv.addObject(name);
        mv.addObject(student_age);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}


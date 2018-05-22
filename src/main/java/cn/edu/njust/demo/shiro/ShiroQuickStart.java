package cn.edu.njust.demo.shiro;

import cn.edu.njust.base.model.CRUDRspVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
@Controller
@RequestMapping("/shiro")
public class ShiroQuickStart {
    private static final transient Logger log = LoggerFactory.getLogger(ShiroQuickStart.class);

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public @ResponseBody
    List<String> test(@RequestParam Map<Object, Object> params) {
//        CRUDRspVO vo = new CRUDRspVO(1, "msg");
        return Arrays.asList("1", "2", "3");
    }
}

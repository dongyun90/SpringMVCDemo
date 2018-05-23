package cn.edu.njust.demo.controller;

import cn.edu.njust.base.model.CRUDRspVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/shiro")
public class ShiroController {
    private static final transient Logger log = LoggerFactory.getLogger(ShiroController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public CRUDRspVO test(@RequestParam Map<String, String> params) {
        if (!params.containsKey("username") || !params.containsKey("pwd")) {
            return new CRUDRspVO(0, "username or pwd is empty");
        }
        String username = params.get("username");
        String pwd = params.get("pwd");

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();

        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("Retrieved the correct value! [" + value + "]");
            log.info("Retrieved the correct value! [" + value + "]");
        }

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

                if (currentUser.hasRole("student")) {
                    log.info("You have role of student.");
                } else {
                    log.info("No role of student.");
                }

                if (currentUser.isPermitted("njust:cse:stu")) {
                    log.info("You have permission of njust:cse:stu");
                } else {
                    log.info("No permission of njust:cse:stu");
                }

                if (currentUser.isPermitted("njust:cse:secret")) {
                    log.info("You have permission of njust:cse:secret");
                } else {
                    log.info("No permission of njust:cse:secret");
                }
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
                return new CRUDRspVO(0, "UnknownAccountException");
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
                return new CRUDRspVO(0, "IncorrectCredentialsException");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
                return new CRUDRspVO(0, "LockedAccountException");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
                return new CRUDRspVO(0, "UnKownException");
            }
            finally {
                currentUser.logout();
            }
        }
        return new CRUDRspVO(1, "i do know nothing...");
    }
}
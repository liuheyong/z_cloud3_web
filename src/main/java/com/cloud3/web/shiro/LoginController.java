package com.cloud3.web.shiro;//package com.cloud.web.shiro;
//
//import com.cloud.commons.constants.Constants;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.subject.Subject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
///**
// * @author: HeYongLiu
// * @create: 06-21-2019
// * @description: 控制器
// **/
//@RestController
//public class LoginController {
//
//    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
//
//    @GetMapping(value = Constants.CLOUD + "/hello")
//    public String hello() {
//        log.info("不登录也可以访问...");
//        return "hello...";
//    }
//
//    @GetMapping(value = Constants.CLOUD + "/index")
//    public String index() {
//        log.info("登陆成功了...");
//        return "index";
//    }
//
//    @GetMapping(value = Constants.CLOUD + "/denied")
//    public String denied() {
//        log.info("权限不足...");
//        return "denied...";
//    }
//
//    @GetMapping(value = Constants.CLOUD + "/login")
//    public String login(String username, String password, RedirectAttributes model) {
//        // 想要得到 SecurityUtils.getSubject() 的对象．．访问地址必须跟 shiro 的拦截地址内，不然后会报空指针
//        Subject sub = SecurityUtils.getSubject();
//        // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
//        // 认证执行者交由AuthRealm中doGetAuthenticationInfo处理
//        // 当以上认证成功后会向下执行,认证失败会抛出异常
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        try {
//            sub.login(token);
//        } catch (UnknownAccountException e) {
//            log.error("对用户[{}]进行登录验证,验证未通过,用户不存在", username);
//            token.clear();
//            return "UnknownAccountException";
//        } catch (LockedAccountException lae) {
//            log.error("对用户[{}]进行登录验证,验证未通过,账户已锁定", username);
//            token.clear();
//            return "LockedAccountException";
//        } catch (ExcessiveAttemptsException e) {
//            log.error("对用户[{}]进行登录验证,验证未通过,错误次数过多", username);
//            token.clear();
//            return "ExcessiveAttemptsException";
//        } catch (AuthenticationException e) {
//            log.error("对用户[{}]进行登录验证,验证未通过,堆栈轨迹如下", username, e);
//            token.clear();
//            return "AuthenticationException";
//        }
//        return "success";
//    }
//
//}

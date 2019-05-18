package org.ssl.boot.day01.Controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.ssl.util.HttpRequest;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    private Logger logger = Logger.getLogger(IndexController.class);
    @GetMapping("/index")
    public String  Index(){
        return "index";
    }
    @GetMapping("/login")
    public String UserLogin(){
        logger.info("=============开始用户登录，跳转GitHub================");
        String url = "https://github.com/login/oauth/authorize?client_id=55c935ff6aeea742a96f&redirect_uri=http://192.168.1.104:8899/callback&scope=user&state=1";
        String result=HttpRequest.SendGet(url,null);
        System.out.println( "++++++++++"+result);

//        HttpServletResponse repose = ServletActionContext.getResponse();
        return result;
    }
    @GetMapping("/callback")
    public void test(){
        logger.info("================回调服务=================");
    }
}

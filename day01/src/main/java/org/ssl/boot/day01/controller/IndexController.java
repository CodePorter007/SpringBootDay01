package org.ssl.boot.day01.Controller;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssl.boot.day01.Dto.AccessTokenDTO;
import org.ssl.boot.day01.Dto.GitHubUser;
import org.ssl.util.OkHttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {
    private Logger logger = Logger.getLogger(IndexController.class);
    @Value("${authorize.url}")
    private String authorizeUrl;
    @Value("${callback.url}")
    private String callbackUrl;
    @Value("${access.token.url}")
    private String accessTokenUrl;
    @Value("${user.url}")
    private String userUrl;
    @Value("${client.id}")
    private String clientId;
    @Value("${client.secret}")
    private String clientSecret;

    @GetMapping("/index")
    public String  Index(){
        return "index";
    }
    @GetMapping("/login")
    public String UserLogin(HttpServletRequest request, HttpServletResponse response){
        logger.info("=============开始用户登录，跳转GitHub================");
        try {
            response.sendRedirect(authorizeUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
    @GetMapping("/callback")
    public String getCallback(@RequestParam(name = "code") String code,@RequestParam(name = "state") String state){
        logger.info("================回调服务=================");
        OkHttpRequest okHttpRequest = new OkHttpRequest();
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(callbackUrl);
        try {
            String restur = okHttpRequest.postOkHttp(accessTokenUrl,accessTokenDTO);
            String[] strings = restur.split("&");
            String accessToken = "access_token="+strings[0].split("=")[1];
            String str = okHttpRequest.getOkHttp(userUrl,accessToken);
            GitHubUser gitHubUser = JSON.parseObject(str,GitHubUser.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
}

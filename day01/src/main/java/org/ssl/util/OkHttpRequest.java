package org.ssl.util;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.util.StringUtils;
import org.ssl.boot.day01.Dto.AccessTokenDTO;

import java.io.IOException;

public class OkHttpRequest {
    public String postOkHttp(String url, AccessTokenDTO object) throws IOException{
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(object));
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String getOkHttp(String url,String str)  throws IOException{
        OkHttpClient client = new OkHttpClient();
        if(!StringUtils.isEmpty(str)){
            url = url+"?"+str;
        }
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }

    }
}

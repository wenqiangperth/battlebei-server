package com.example.battlebeiserver.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

//import static com.mysql.cj.MysqlType.JSON;

/**
 * @author perth
 * @ClassName MyHttp
 * @Description TODO
 * @Date 2019/5/29 17:19
 **/
public class MyHttp {

    public String doget(String code){
        try {
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session"+"?appid="+
                    Constant.APPID+"&secret="+Constant.APPSECRET+"&js_code="+code+"&grant_type=authorization_code");    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            //connection.setRequestProperty("session_id",session_id);
            connection.connect();// 连接会话

            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                // 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            String temp=""+sb;
            System.out.println(temp);
            return temp;
//            Map mapResult = (Map)JSON.parse(sb.toString() );
//            ApiResult apiResult = new ApiResult(true,mapResult);
//            return apiResult;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
//            return new ApiResult(false,null);
        }
        return "error";
    }
}

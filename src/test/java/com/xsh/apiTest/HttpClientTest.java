//package com.xsh.apiTest;
//
//import com.xsh.pojo.HttpResult;
//import com.xsh.util.HttpClientUtil;
//import com.xsh.util.HttpClientUtils;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//

//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class HttpClientTest {
//
//    private HttpClientUtil apiService;
//
//    @Before
//    public void init() {
//        this.apiService = new HttpClientUtil();
//    }
//
//    @Test
//    public void test1() throws Exception {
//        HttpResult httpResult = apiService.doGet("https://r.qzone.qq.com/fcg-bin/cgi_get_portrait.fcg?g_tk=1518561325&uins=2668028614", null);
//        System.out.println(httpResult);
//    }
//}

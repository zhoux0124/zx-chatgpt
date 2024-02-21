package cn.zhoux.chatgpt.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28888885841411/topics?scope=unanswered_questions&count=20");

        httpGet.addHeader("cookie", "zsxq_access_token=A8BB4AD8-3092-24E9-A0CD-9C2DA76EC41F_C2F6E491017FB16B; zsxqsessionid=cb1d77bf845fe3b2f3380544b3741d0f; abtest_env=product");

        httpGet.addHeader("Content-Type", "application/json; charset=UTF-8\n");


        CloseableHttpResponse response = httpClient.execute(httpGet);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/188821588814122/answer");
        httpPost.addHeader("cookie", "zsxqsessionid=cb1d77bf845fe3b2f3380544b3741d0f; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22585144511842254%22%2C%22first_id%22%3A%2218dc9cdc289a03-0713bc4b9227c08-26001851-1058400-18dc9cdc28a1275%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThkYzljZGMyODlhMDMtMDcxM2JjNGI5MjI3YzA4LTI2MDAxODUxLTEwNTg0MDAtMThkYzljZGMyOGExMjc1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNTg1MTQ0NTExODQyMjU0In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22585144511842254%22%7D%2C%22%24device_id%22%3A%2218dc9cdc289a03-0713bc4b9227c08-26001851-1058400-18dc9cdc28a1275%22%7D; zsxq_access_token=4AE1AC3F-6508-2D3A-28BE-6732331A8318_C2F6E491017FB16B");
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8\n");

        String paramJson = "{\"req_data\":{\"text\":\"我27岁了。\\n\",\"image_ids\":[],\"silenced\":false}}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}

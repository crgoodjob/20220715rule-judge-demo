package cn.maitian.bss.modules.office.utils;

import cn.maitian.bss.modules.office.config.ImagesConfig;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.UUID;

/**
 * 图片工具类
 *
 * @author ChangRui
 * @version 1.0
 * @date 2022-04-14 10:36
 */
public class ImagesUtil {

    public String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }


    /**
     * 图片上传
     *
     * @param requestUrl
     * @param picTypeId
     * @param byteImage
     * @param imageName
     * @return java.lang.String
     * @author ChangRui
     * @date 2022/4/14 11:09
     */
    public String uploadImage(String requestUrl, String picTypeId, byte[] byteImage, String imageName) throws IOException {

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseMessage = "";

        try {
            // 1. 创建上传需要的元素类型
            // 1.1 装载本地上传图片的文件
            // File imageFile = new File(imageFilePath);
            // FileBody imageFileBody = new FileBody(imageFile);
            ByteArrayBody byteArrayBody = new ByteArrayBody(byteImage, imageName);

            // 1.2 装载上传字符串的对象
            StringBody name = new StringBody(picTypeId, ContentType.TEXT_PLAIN);
            System.out.println("装载数据完成");
            // 2. 将所有需要上传元素打包成HttpEntity对象
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("picTypeId", name)
                    .addPart("file", byteArrayBody).build();
            System.out.println("打包数据完成");
            // 3. 创建HttpPost对象，用于包含信息发送post消息
            HttpPost httpPost = new HttpPost(requestUrl);
            httpPost.setEntity(reqEntity);
            System.out.println("创建post请求并装载好打包数据");
            // 4. 创建HttpClient对象，传入httpPost执行发送网络请求的动作
            httpClient = HttpClients.createDefault();
            response = httpClient.execute(httpPost);
            System.out.println("发送post请求并获取结果");
            // 5. 获取返回的实体内容对象并解析内容
            HttpEntity resultEntity = response.getEntity();


            System.out.println("开始解析结果");
            if (resultEntity != null) {
                InputStream is = resultEntity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                StringBuffer sb = new StringBuffer();
                String line = "";
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                responseMessage = sb.toString();
                System.out.println("解析完成，解析内容为" + responseMessage);
            }
            EntityUtils.consume(resultEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != response) {
                response.close();
            }
            if (null != httpClient) {
                httpClient.close();
            }
        }
        return responseMessage;
    }

}

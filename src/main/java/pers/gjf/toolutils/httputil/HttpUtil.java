package pers.gjf.toolutils.httputil;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <p>File: HttpClient.java </p>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Create By: 2021/05/31 13:30 </p>
 * <p>Company: nbnope.cn </p>
 *
 * @author gjf.gu/921208155@qq.com
 * @version 1.0
 */
public class HttpUtil
{
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /** 多线程共享实例 */
    private static CloseableHttpClient httpClient;
    /** 连接管理器 */
    private static PoolingHttpClientConnectionManager cm;

    static {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2,TLSv1.3,SSLv3");

        cm = new PoolingHttpClientConnectionManager();

        //每个路由的最大并发数连接
        cm.setDefaultMaxPerRoute(10);
        //总连接数
        cm.setMaxTotal(10);


        //创建httpclient单例
        //evictIdleConnections 超时关闭空闲连接
        httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .evictIdleConnections(8000, TimeUnit.MILLISECONDS)
                .build();
    }

    /**
     * 返回共享实例
     * @return
     */
    public static CloseableHttpClient getHttpClient() {
        return httpClient;
    }
}

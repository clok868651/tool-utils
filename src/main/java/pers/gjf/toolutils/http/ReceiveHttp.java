package pers.gjf.toolutils.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

/**
 * <p>File: ReceiveHttp.java </p>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Create By: 2021/05/31 09:20 </p>
 * <p>Company: nbnope.cn </p>
 *
 * @author gjf.gu/921208155@qq.com
 * @version 1.0
 */
@Controller
public class ReceiveHttp
{
    private static final Logger logger = LoggerFactory.getLogger(ReceiveHttp.class);

    @ResponseBody
    @RequestMapping(value = "/receive")
    public String receive(HttpServletRequest request) throws InterruptedException
    {
        logger.info("=======================来自自建接入========================");
        logger.info("Date->{}", new Date());
        Enumeration<String> headNames = request.getHeaderNames();
        while(headNames.hasMoreElements()){
            String headName = headNames.nextElement();
            logger.info("headName->{},header->{}", headName, request.getHeader(headName));
        }

        Enumeration<String> paramNames = request.getParameterNames();
        while(paramNames.hasMoreElements()){
            String paramName = paramNames.nextElement();
            logger.info("paramName->{},param->{}", paramName, request.getParameter(paramName));
        }

        String param= null;
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder responseStrBuilder = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            logger.info("responseStrBuilder->{}", responseStrBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("=========================================================");
        return "OK:" + UUID.randomUUID();
    }
}

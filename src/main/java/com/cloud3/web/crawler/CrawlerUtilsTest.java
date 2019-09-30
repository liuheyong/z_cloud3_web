package com.cloud3.web.crawler;

import org.jsoup.Jsoup;

import javax.swing.text.Document;
import java.io.IOException;

/**
 * @author: jack
 * @create: 2019-06-23
 * @description:
 **/
public class CrawlerUtilsTest {

    public static void main(String[] args) throws IOException {
        String html = CrawlerUtils.getData("http://www.baidu.com", "utf-8");
        System.out.println(html);
        Document document = (Document) Jsoup.parse(html);

    }

}

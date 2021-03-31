package com.bloshound;


import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        HTMLDownloader htmlDownloader = new HTMLDownloader("https://yandex.ru/search/?clid=2186618&text=string.split%20java&lr=42&redircnt=1617225411.1");
        String dawnloadedHtml = htmlDownloader.downloadHtml();

        Document doc = HTMLParser.parse(dawnloadedHtml);
        String text = HTMLParser.text(doc);

        Util util = new Util();
        Map<String, Long> entrances = util.findDoublicates(text);

        LinkedHashMap<String, Long> sortedEntrances = util.sortbyValueLinked(entrances);

        System.out.println(sortedEntrances);

    }
}

package com.bloshound;


import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;



public class App {
    public static void main(String[] args) throws IOException {

        HTMLDownloader htmlDownloader = new HTMLDownloader("https://yandex.ru");
        String downloadedHtml = htmlDownloader.downloadHtml();

        Document doc = HTMLParser.parse(downloadedHtml);
        String text = HTMLParser.text(doc);

        Util util = new Util();
        Map<String, Long> entrances = util.entrancesCounting(text);

        LinkedHashMap<String, Long> sortedEntrances = util.sortedLinkedEntrancesCounting(entrances);

        System.out.println(sortedEntrances);

    }
}

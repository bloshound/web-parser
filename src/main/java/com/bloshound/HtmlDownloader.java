package com.bloshound;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

public class HtmlDownloader {

    public static final String downloadedPathName = "C:\\Users\\skb-2\\IdeaProjects\\web-parser\\";

    private static final Logger logger = Logger.getLogger(HtmlDownloader.class.getSimpleName());
    private URL url;

    public HtmlDownloader(String input) throws MalformedURLException {
        this.url = new URL(input);
    }

    public long downloadHtml() throws IOException {
        long count;


        Path downloadedPath = Paths.get(downloadedPathName + "aaaa");
        System.out.println(downloadedPath);

        count = Files.copy(url.openStream(), downloadedPath, StandardCopyOption.REPLACE_EXISTING);

        logger.info(downloadedPath.toString() + "downloaded");

        String text = Jsoup.parse(downloadedPath.toFile(), "UTF-8").text();

        System.out.println(text);
        String[] words = text.split("\\+");

        for (String word : words) {
            System.out.println(word);
        }

        return count;
    }
}

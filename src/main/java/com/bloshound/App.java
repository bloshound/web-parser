package com.bloshound;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {

        HTMLDownloader htmlDownloader = new HTMLDownloader("https://www.simbirsoft.com/portfolio/");
        String dawnloadedHtml = htmlDownloader.downloadHtml();



    }
}

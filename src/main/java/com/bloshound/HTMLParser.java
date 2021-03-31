package com.bloshound;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public final class HTMLParser {

    public static final String charSet = "UTF-8";

    private static final Logger logger = Logger.getLogger(HTMLParser.class.getName());

    public static Document parse(String filename) throws IOException {
       return parse(new File(filename));
    }

    public static Document parse(File file) throws IOException {
      return Jsoup.parse(file, charSet);
    }
}

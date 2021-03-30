package com.bloshound;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class RemoteURLWorker {

    private static Logger logger = Logger.getLogger(RemoteURLWorker.class.getSimpleName());
    private  URL url;

    public RemoteURLWorker(String input) throws MalformedURLException {
        this.url = new URL(input);
    }

    public HttpURLConnection getConnectionFromURL() throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public InputStream openInputStream() throws IOException {
       return getConnectionFromURL().getInputStream();
    }








}

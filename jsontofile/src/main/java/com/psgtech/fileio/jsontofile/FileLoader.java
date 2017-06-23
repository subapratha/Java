package com.psgtech.fileio.jsontofile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class FileLoader {
    public static Reader openReader(String filename, boolean isResource) throws UnsupportedEncodingException, FileNotFoundException, MalformedURLException {
        return openReader(filename, isResource, "UTF-8");
    }

    public static Reader openReader(String filename, boolean isResource, String charset) throws UnsupportedEncodingException, FileNotFoundException, MalformedURLException {
        return new InputStreamReader(openInputStream(filename, isResource), charset);
    }

    public static InputStream openInputStream(String filename, boolean isResource) throws FileNotFoundException, MalformedURLException {
        if (isResource) {
            return FileLoader.class.getClassLoader().getResourceAsStream(filename);
        }

        return new FileInputStream(load(filename, isResource));
    }

    public static String read(String path, boolean isResource) throws IOException {
        return read(path, isResource, "UTF-8");
    }

    public static String read(String path, boolean isResource, String charset) throws IOException {
        return read(pathToUrl(path, isResource), charset);
    }

    @SuppressWarnings("resource")
    protected static String read(URL url, String charset) throws IOException {
        return new Scanner(url.openStream(), charset).useDelimiter("\\A").next();
    }

    protected static File load(String path, boolean isResource) throws MalformedURLException {
        return load(pathToUrl(path, isResource));
    }

    protected static File load(URL url) {
        try {
            return new File(url.toURI());
        } catch (URISyntaxException e) {
            return new File(url.getPath());
        }
    }

    private static final URL pathToUrl(String path, boolean isResource) throws MalformedURLException {
        if (isResource) {
            return FileLoader.class.getClassLoader().getResource(path);
        }

        return new URL("f:\\21.json" + path);
    }
}



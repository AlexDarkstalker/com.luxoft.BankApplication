package com.luxoft.bankapp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by omsk19 on 11/11/2016.
 */
public class FeedService {
    public static String fileName = "clients.txt";
    public static String filePath = "P:\\Users\\omsk19\\Documents";
    public static void loadFeed(String folder) {

    }

    public static void loadFeed(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        String feeds = scanner.nextLine();
        feeds.split(";");
        System.out.println(feeds);
        Map<String, String> map = new HashMap<>();
    }
}

package com.blackwell;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class EulerProblemHelper {

    private static final String EULER_PROBLEM_URL = "https://projecteuler.net/problem=";

    public String getDescription(int taskNumber) throws IOException {
        String url = EULER_PROBLEM_URL + taskNumber;
        Document doc = Jsoup.connect(url).get();
        Elements info = doc.select(".problem_content");
        return info.html();
    }

    public String getTitle(int taskNumber) throws IOException {
        String url = EULER_PROBLEM_URL + taskNumber;
        Document doc = Jsoup.connect(url).get();
        Elements name = doc.select("#content h2");
        return name.text();
    }

}

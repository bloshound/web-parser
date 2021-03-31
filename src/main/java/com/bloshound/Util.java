package com.bloshound;


import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Util {

    public static final char[] delimiters = {' ', ',', '.', '!', '?', '"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'};
    private String regex = "[ ,.!?\";:\\[\\]()\n\r\t]+";

    public String getRegex() {
        return regex;
    }

    private String[] splitOnDelimeters(String content) {
        return content.trim().split(regex);
    }

    public Map<String, Long> findDoublicates(String content) {
        Map<String, Long> entrances = Arrays.stream(splitOnDelimeters(content))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return entrances;
    }

    public LinkedHashMap<String, Long> sortbyValueLinked(Map<String, Long> map) {
        LinkedHashMap<String, Long> sortedEntrances = map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, ((oldvalue, newvalue) -> newvalue), LinkedHashMap::new));
        return sortedEntrances;
    }
}

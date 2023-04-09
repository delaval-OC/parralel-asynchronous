package com.learnjava.parallelstreams;

import static com.learnjava.util.CommonUtil.delay;
import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;
import static com.learnjava.util.DataSet.namesList;
import static com.learnjava.util.LoggerUtil.log;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamsExample {

    public List<String> stringTransform(List<String> nameList) {
        return nameList.parallelStream().map(this::addNameLengthTransform).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> namesList = namesList();

        startTimer();
        ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();
        List<String> result = parallelStreamsExample.stringTransform(namesList);
        log("resultList =" + result);
        timeTaken();
    }

    private String addNameLengthTransform(String name) {
        delay(500);
        return name.length() + " - " + name;
    }
}

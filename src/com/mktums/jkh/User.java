package com.mktums.jkh;

import com.mktums.jkh.utils.Pair;

import java.util.HashMap;
import java.util.Map;

class User {
    public String name;
    public Double result;
    private HashMap<String, Double> metrics = new HashMap<>();

    User(String name, HashMap<String, Pair<Integer, Double>> metrics) {
        this.name = name;
        this.result = 0.;
        for (Map.Entry<String, Pair<Integer, Double>> metric : metrics.entrySet()) {
            Pair<Integer, Double> value = metric.getValue();
            this.metrics.put(
                    metric.getKey(), value.left * value.right
            );
        }
    }

    public HashMap<String, Double> getMetrics() {
        return this.metrics;
    }
}

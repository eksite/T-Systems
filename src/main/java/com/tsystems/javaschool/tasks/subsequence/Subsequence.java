package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {

    public boolean find(List x, List y) {
        if (x == null || y == null) throw new IllegalArgumentException();
        int xIndex = 0;
        int yIndex = 0;
        while (xIndex < x.size() && yIndex < y.size()) {
            if (x.get(xIndex)== y.get(yIndex)){
                xIndex++;
            }
            yIndex++;
        }
        return xIndex == x.size();
    }}


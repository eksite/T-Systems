package com.tsystems.javaschool.tasks.pyramid;

import java.util.*;

public class PyramidBuilder {

    public int[][] buildPyramid(List<Integer> inputNumbers)throws OutOfMemoryError{
            try {

                Collections.sort(inputNumbers);
                double tmpHeight = ( Math.sqrt(1 + 8 * inputNumbers.size()) - 1) / 2;
                int height=(int)tmpHeight;
                if(tmpHeight-height!=0)throw new CannotBuildPyramidException();
                int width = 2 * (int)height - 1;
                int currentElemntIndex = 0;
                int[][] result = new int[height][width];
                for (int currentHeight = 1; currentHeight <= height; currentHeight++) {
                    int rowWidth = 2 * currentHeight - 1;
                    int offset = (width - rowWidth) / 2;
                    int[] row = new int[width];
                    for (int i = offset + 1; i <= width - offset; i = i + 2) {
                        int candidate = inputNumbers.get(currentElemntIndex);
                        row[i - 1] = candidate;
                        currentElemntIndex++;
                    }
                    result[currentHeight - 1] = row;
                }
                return result;
            }catch(Throwable e){
                throw new CannotBuildPyramidException();
            }
    }
}

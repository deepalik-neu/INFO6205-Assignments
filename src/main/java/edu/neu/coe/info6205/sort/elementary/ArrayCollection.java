package edu.neu.coe.info6205.sort.elementary;

import java.util.Random;

public class ArrayCollection {
    private int n;
    private final Integer[] arrCollection;
    private static final Random rng = new Random(90);


    public ArrayCollection(int n) {
        this.n = n;
        arrCollection = new Integer[n];
        for (int i = 0; i < n; i++)
            arrCollection[i] = i;
    }

    public Integer[] getIncreasingOrderArray() {
        return arrCollection.clone();
    }

    public Integer[] getDecreasingOrderArray() {
        Integer[] retArr = new Integer[arrCollection.length];
        for (int i = 0; i < arrCollection.length; i++)
            retArr[arrCollection.length - 1 - i] = arrCollection[i];
        return retArr;
    }

    public Integer[] getPartialOrderArray() {
        int swap_count = rng.nextInt(Math.max(1, arrCollection.length / 2 - 2));
        Integer[] retArr = arrCollection.clone();
        for (int i = 0; i < swap_count; ++i) {
            int a = rng.nextInt(arrCollection.length);
            int b = rng.nextInt(arrCollection.length);

            int temp = retArr[a];
            retArr[a] = retArr[b];
            retArr[b] = temp;
        }
        return retArr;
    }

    public Integer[] getRandomOrderArray(){
        int swap_count = rng.nextInt(2*arrCollection.length);
        Integer[] ret = arrCollection.clone();

        for(int i=0;i<swap_count;++i) {
            int a = rng.nextInt(arrCollection.length);
            int b = rng.nextInt(arrCollection.length);

            int tmp = ret[a];
            ret[a] = ret[b];
            ret[b] = tmp;
        }
        return ret; }
}

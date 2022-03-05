package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortOutput {
    private static final int UPPER_Limit = (int)Math.pow(2,15);
    private static final int RUNS = 100;

    public static double benchmarkRun(String description, final Integer[] arrInput)
    {
        Benchmark<Integer[]> benchmark_timer = new Benchmark_Timer<>(description, x ->
                x.clone(),
                input_arr -> new InsertionSort<Integer>().sort(input_arr,0,input_arr.length), null
        );
        return benchmark_timer.run(arrInput, RUNS);
    }

    public static void main(String[] args)
    {
        List<Double> timingList = new ArrayList<>();
        
        for (int i = 1; i < UPPER_Limit; i *= 2) {
            ArrayCollection col = new ArrayCollection(i);
            Integer[] arrCol = col.getDecreasingOrderArray();
            timingList.add(benchmarkRun("Reverse-Ordered Array", arrCol.clone()));
        }
        for (int i = 1, j = 0; i < UPPER_Limit; i *= 2, j++) {
            System.out.println("Time taken by size of Array:  " + i + " -> " + timingList.get(j)+ " to run insertion sort for random array.");
        }
      
        timingList = new ArrayList<>();
        for (int i = 1; i < UPPER_Limit; i *= 2) {
            ArrayCollection col = new ArrayCollection(i);
            Integer[] arrCol = col.getPartialOrderArray();
            timingList.add(benchmarkRun("Partially-Ordered Array", arrCol.clone()));
        }
        for (int i = 1, j = 0; i < UPPER_Limit; i *= 2, j++) {
            System.out.println("Time taken by size of Array: " + i + " -> " + timingList.get(j)+ " to run insertion sort for random array."); }
        
        timingList = new ArrayList<>();
        for (int i = 1; i < UPPER_Limit; i *= 2) {
            ArrayCollection a = new ArrayCollection(i);
            Integer[] arrCol = a.getIncreasingOrderArray(); timingList.add(benchmarkRun("Increasing-Ordered Array", arrCol.clone()));
        }
        for (int i = 1, j = 0; i < UPPER_Limit; i *= 2, j++) {
            System.out.println("Time taken by size of Array:  " + i + " is " + timingList.get(j)+ " to run insertion sort for random array."); }

        timingList = new ArrayList<>();
        for (int i = 1; i < UPPER_Limit; i *= 2) {
            ArrayCollection a = new ArrayCollection(i);

            Integer[] arrCol = a.getRandomOrderArray(); timingList.add(benchmarkRun("Random-Ordered Array", arrCol.clone()));
        }
        for (int i = 1, j = 0; i < UPPER_Limit; i *= 2, j++) {
            System.out.println("Time taken by size of Array: " + i + " is " + timingList.get(j)+ " to run insertion sort for random array."); }
    }
}

package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class Client {

    public static int count(int n) {
        //count the number of connections for n objects for random values of a and b
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random r = new Random();
        int x = 0;
        while (uf.components() > 1) {
            int a = r.nextInt(n);
            int b = r.nextInt(n);

            uf.connect(a, b);
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        //Take input n
        System.out.println("please enter number for number of objects:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //get number of connections
        System.out.println("The number of objects are " + n + " and the number of connections are " + count(n));
//step 3
        System.out.println("Determine the relationship between the number of objects (n) and the number of pairs (m)");

        for (int i = 1000; i < 140000; i *= 2) {
            int total = 0;
            // test  count 5 times for an average number
            for (int j = 0; j < 10; j++) {
                total += count(i);
            }
            int avg = total / 10;
            System.out.println("The number of objects are " + i + " and the number of pairs are " + avg);
        }
    }

}

package ik;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.*;

public class MergeKArrays {

    /*
     * Complete the function below.
     */
    static class PQEntry implements Comparable<PQEntry> {
        int arrIndex;
        int val;

        public PQEntry(int arrIndex, int val) {
            this.arrIndex = arrIndex;
            this.val = val;
        }

        @Override
        public int compareTo(PQEntry other) {
            return Integer.compare(this.val, other.val);
        }
    }

    static int[] mergeArrays(int[][] arr) {
        if (arr.length == 0)
            return new int[] {};
        int k = arr.length;
        int n = arr[0].length;
        int[] res = new int[k * n];
        int[] indexArr = new int[k];
        int resIndex = 0;
        PriorityQueue<PQEntry> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.offer(new PQEntry(i, arr[i][indexArr[i]]));
        }
        while (!pq.isEmpty()) {
            PQEntry prev = pq.poll();
            res[resIndex++] = prev.val;
            indexArr[prev.arrIndex] += 1;
            if (indexArr[prev.arrIndex] < n) {
                pq.offer(new PQEntry(prev.arrIndex, arr[prev.arrIndex][indexArr[prev.arrIndex]]));
            }
        }

        return res;

    }
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int[] res;
        int arr_rows = 0;
        int arr_cols = 0;
        arr_rows = Integer.parseInt(in.nextLine().trim());
        arr_cols = Integer.parseInt(in.nextLine().trim());

        int[][] arr = new int[arr_rows][arr_cols];
        for(int arr_i = 0; arr_i < arr_rows; arr_i++) {
            for(int arr_j = 0; arr_j < arr_cols; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        res = mergeArrays(arr);
        for(int res_i = 0; res_i < res.length; res_i++) {
            System.out.print(String.valueOf(res[res_i]));
        }
    }

}

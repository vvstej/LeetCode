package ik;

public class NutsAndBolts {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int[] nuts = new int[]{3,2,9,6,5,10,13};
        int[] bolts = new int[]{6,2,9,3,13,5,10};
        nutsAndBolts(nuts, bolts, 0, nuts.length-1);
        for(int i=0;i<nuts.length;i++) {
            System.out.print(nuts[i] + " ");
        }
        System.out.println(" ");
        for(int i=0;i<bolts.length;i++) {
            System.out.print(bolts[i]+" ");
        }
    }
    
    private static void nutsAndBolts(int[] nuts, int[] bolts, int start, int end) {
        if(start < end) {
            // choose a nut and partition bolts based on that nut
            //take that bolt from previous step that got in position i and sort all nuts based on it. 
            //recursively do that for left and right of the matched nut and bolt.
            int pivot = partition(nuts,bolts,start,end,bolts[end]);
            partition(bolts,nuts,start,end,nuts[pivot]);
            nutsAndBolts(nuts,bolts,start, pivot-1);
            nutsAndBolts(nuts,bolts,pivot+1, end);
        }
        return;
    }
    
    private static int partition(int[] a, int[] b, int start, int end, int pivotElem) {
        int startPtr = start;
        int endPtr = end;
        //int pivot = p==-1 ? end : p;
        //int pivotElem = p==-1 ? b[end] : b[p];
        //swap(a,pivot,end);
        while(startPtr < endPtr) {
            while(a[startPtr] < pivotElem) {
                startPtr++;
            }
            while(endPtr >= start && a[endPtr] > pivotElem) {
                endPtr--;
            }
            if(startPtr < endPtr) {
                swap(a,startPtr, endPtr);
            }
        }
        //swap(a,startPtr, pivot);
        return startPtr;
        
    }
    
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }
}

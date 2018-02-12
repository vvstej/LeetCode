package ik;

import java.io.*;
import java.util.*;
public class Solution3 {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Integer[] arr = new Integer[]{6,2,5,4,5,1,6};
    List<Integer> input = Arrays.asList(arr);
    
    System.out.println(findMaxArea1(input));
}
    
    private static int findMaxArea(List<Integer> input) {
        Stack<StackObject> stack = new Stack<StackObject>();
        int maxArea = 0;
        for(int i=0;i<input.size();i++) {
            int currVal = input.get(i);
            int count = 1;
            StackObject prev = null;
            while(!stack.isEmpty() && currVal < input.get(stack.peek().index)) {
                StackObject curr = stack.pop();
                if(prev!=null) {
                    curr.count+=prev.count;
                }
                int area = input.get(curr.index) * curr.count;
                System.out.println("Area at "+ curr.index + " is : "+ area);
                maxArea = Math.max(area,maxArea);
                prev = curr;
                count += curr.count;
            }
            stack.push(new StackObject(i,count));
        }
        
        StackObject prev = null;
        while(!stack.isEmpty()) {
            StackObject curr = stack.pop();
                if(prev!=null) {
                    curr.count+=prev.count;
                }
                int area = input.get(curr.index) * curr.count;
                maxArea = Math.max(area,maxArea);
                prev = curr;
        }
        return maxArea;
    }
    
    private static int findMaxArea1(List<Integer> input) {
        Stack<StackObject> stack = new Stack<StackObject>();
        int maxArea = 0;
        int i = 0;
        while(!stack.isEmpty() || i==0) {
            int currVal = i < input.size() ? input.get(i) : Integer.MIN_VALUE;
            int count = 0;
            StackObject prev = null;
            while(!stack.isEmpty() && currVal < input.get(stack.peek().index)) {
                StackObject curr = stack.pop();
                if(prev!=null) {
                    curr.count+=prev.count;
                }
                int area = input.get(curr.index) * curr.count;
                System.out.println("Area at "+ curr.index + " is : "+ area);
                System.out.println("count at "+ curr.index + " is : "+ curr.count);
                maxArea = Math.max(area,maxArea);
                prev = curr;
                count = curr.count;
            }
            if(i<input.size())
                stack.push(new StackObject(i++,++count));
        }
        return maxArea;
    }
    
}

class StackObject {
    int index;
    int count;
    public StackObject(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
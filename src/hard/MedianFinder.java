package hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> minHeapOfBiggerNos = new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeapOfSmallerNos = new PriorityQueue<Integer>(Collections.reverseOrder());
	// Adds a number into the data structure.
	public void addNum(int num) {
		if(maxHeapOfSmallerNos.isEmpty()){
			maxHeapOfSmallerNos.add(num);
			return;
		}
		if(num<=maxHeapOfSmallerNos.peek()){
			if(maxHeapOfSmallerNos.size()-1>=minHeapOfBiggerNos.size()){
				int val = maxHeapOfSmallerNos.poll();
				minHeapOfBiggerNos.add(val);
				maxHeapOfSmallerNos.add(num);
			}else{
				maxHeapOfSmallerNos.add(num);
			}
		}else if(minHeapOfBiggerNos.size()==0 || num >= minHeapOfBiggerNos.peek()){
			if(minHeapOfBiggerNos.size()-1 >= maxHeapOfSmallerNos.size()){
				int val = minHeapOfBiggerNos.poll();
				maxHeapOfSmallerNos.add(val);
				minHeapOfBiggerNos.add(num);
			}else{
				minHeapOfBiggerNos.add(num);
			}
		}
		else if(num > maxHeapOfSmallerNos.peek() && num < minHeapOfBiggerNos.peek()){
			PriorityQueue<Integer> smallerQueue = maxHeapOfSmallerNos.size() <= minHeapOfBiggerNos.size() ? maxHeapOfSmallerNos : minHeapOfBiggerNos;
			smallerQueue.add(num);			
		}
		
	}

	// Returns the median of current data stream
	public double findMedian() {
		if(minHeapOfBiggerNos.size()==0&&maxHeapOfSmallerNos.size()==2){
			double result = (maxHeapOfSmallerNos.peek()+maxHeapOfSmallerNos.peek())/2.0;
			return result;
		}
		if(minHeapOfBiggerNos.size()==maxHeapOfSmallerNos.size()){
			double result = (minHeapOfBiggerNos.peek()+maxHeapOfSmallerNos.peek())/2.0;
			return result;
		}else{
			PriorityQueue<Integer> maxQueue = (minHeapOfBiggerNos.size() > maxHeapOfSmallerNos.size())?minHeapOfBiggerNos:maxHeapOfSmallerNos;
			return maxQueue.peek();
		}
	}
	public static void main(String[] arg){
		MedianFinder m = new MedianFinder();
		m.addNum(6);
		System.out.println(m.findMedian());
		m.addNum(10);
		System.out.println(m.findMedian());
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(6);
		System.out.println(m.findMedian());
		m.addNum(5);
		System.out.println(m.findMedian());
		m.addNum(0);
		System.out.println(m.findMedian());
		m.addNum(6);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
		m.addNum(1);
		System.out.println(m.findMedian());
		m.addNum(0);
		System.out.println(m.findMedian());
		m.addNum(0);
		System.out.println(m.findMedian());
//		m.addNum(-5);
//		System.out.println(m.findMedian());
	}

}

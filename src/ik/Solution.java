package ik;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		qs(new int[]{5,8,2,4,1,7});
	}
	
	  public static void qs(int[] arr) {
	      qs(arr,0,arr.length-1);
	      Arrays.stream(arr).forEach((elem) -> System.out.print(elem));
	  }
    private static void qs(int[] arr, int start, int end) {

        if (start < end) {
            int partition = partition(arr, start, end);
            qs(arr, start, partition - 1);
            qs(arr, partition + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int startPtr = start;
        int endPtr = end-1;
        int pivot = end;
        int pivotElem = arr[end];
        while (startPtr <= endPtr) {
            while (arr[startPtr] < pivotElem) {
                startPtr++;
            }
            while (endPtr >= start && arr[endPtr] > pivotElem) {
                endPtr--;
            }
            if (startPtr < endPtr)
                swap(arr, startPtr, endPtr);
        }
        swap(arr, pivot, startPtr);
        return startPtr;


    }
	
	private static int partition(int[] arr, int pivot, int start, int end) {
		int startPtr = start;
		int endPtr = end;
		int pivotElem = arr[pivot];
		while (startPtr < endPtr) {
			while (arr[startPtr] < pivotElem && startPtr <= end) {
				startPtr++;
			}
			while (arr[endPtr] > pivotElem && endPtr >= start) {
				endPtr--;
			}
			if (startPtr < endPtr)
				swap(arr, startPtr, endPtr);
		}
		swap(arr, pivot, endPtr);
		return endPtr;
		
		
	}
	
    private int quickSelect(int[] arr, int k, int start, int end) {
        int pivot = pickPivot(arr, start, end);
        int positionOfPivot = partition(arr, pivot, start, end);
        if (positionOfPivot == k - 1)
            return arr[positionOfPivot];
        if (positionOfPivot > k - 1)
            return quickSelect(arr, k, start, positionOfPivot - 1);
        else
            return quickSelect(arr, k, positionOfPivot + 1, end);

    }

    private int pickPivot(int[] arr, int start, int end) {
        return end;
    }

    private void mergeSort(int[] arr, int start, int end) {
		int mid = start + (end-start)/2;
		mergeSort(arr,start,mid-1);
		mergeSort(arr,mid+1, end);
	}
	
	private void merge(int[] arr1, int[] arr2){
		int start1 = 0;
		int start2 = 0;
		int[] res = new int[arr1.length*2];
		int resPtr = 0;
		for(;start1<arr1.length && start2<arr2.length;) {
			if(arr1[start1] < arr2[start2]) {
				res[resPtr++] = arr1[start1];
				start1++;
			}else{
				res[resPtr++] = arr2[start2];
				start2++;
			}
		}
		
	}
	
	private void heapSort(int[] arr) {
		buildHeap(arr);
		int size = arr.length-1;
		for(int i=0;i<arr.length;i++) {
			int elem = deleteMin(arr, size--);
			arr[arr.length-1-i] = elem;
		}
		int begin = 0;
		int end = arr.length-1;
		while(begin<end) {
			swap(arr,begin++,end--);
		}
		
	}
	
	private int deleteMin(int[] arr, int index) {
		int min = arr[0];
		arr[0] = arr[index];
		percolateUp(arr, arr.length-1);
		return 0;
	}

	private void buildHeap(int[] arr) {
		
	}
	
	private void percolateUp(int[] arr, int index) {
		
	}
	
	private void percolateDown(int[] arr, int index) {
		
	}
	
	private boolean isSubSet(int[] m, int[] n) {
		int matches =0;
		//sort m
		//sort n
		boolean larger = m.length >= n.length ? true : false;
		int start = 0;
		if(larger) {
			while(m[start] < n[0]) {
				start++;
			}
		}
		else{
			while(n[start] < m[0]) {
				start++;
			}
		}
		
		
		int largerLen = larger ? m.length : n.length;
		
		for(;start<largerLen;start++) {
			if(m[start]==n[start]) matches++;
		}
		if(larger) {
			return matches==n.length;
		}
		else return matches==m.length;
		
	}
	

	private static void swap(int[] arr, int startPtr, int endPtr) {
		int temp = arr[startPtr];
		arr[startPtr] = arr[endPtr];
		arr[endPtr] = temp;
		
	}

//	static class Vertex {
//        int x;
//        int y;
//        Set<String> keys;
//        Vertex prev;
//    
//        public Vertex(int x, int y, Set<String> keys, Vertex prev) {
//            this.x = x;
//            this.y = y;
//            this.keys = keys;
//            this.prev = prev;
//        }
//        
//        @Override
//        public boolean equals(Object v) {
//            if(v==null) return false;
//            if(this==v) return true;
//            if(!(v instanceof Vertex)) return false;
//            Vertex v1 = (Vertex)v;
//            return v.x==this.x && v.y==this.y && this.keys.size() == v.keys.size() && this.keys.containsAll(v.keys);
//        }
//        
//        @Override
//        public int hashCode() {
//            final int prime = 31;
//            int result = 1;
//            result = prime * result + Integer.hashCode(this.x);
//            result = prime * result + Integer.hashCode(this.y);
//            for(String key: this.keys) {
//                result = prime * result + key.hashCode();
//            }
//            return result;
//        }
//        
//    }
//    /*
//     * Complete the function below.
//     */
//    static int[][] find_shortest_path(String[] grid) {
//        String[][] input = new String[grid.length][grid[0].split(" ").length];
//        Vertex start = null;
//        Vertex end = null;
//        for(int i=0;i<input.length;i++) {
//            for(int j=0;j<input[0].length;j++) {
//                if(input[i][j].equals("@")) {
//                	Set<String> s = new HashSet<>();
//                    start = new Vertex(i,j,s,null);
//                }
//                if(input[i][j].equals("+")) {
//                	Set<String> s = new HashSet<>();
//                    end = new Vertex(i,j,s, null);
//                }
//            }
//        }
//        
//        HashSet<Vertex>[][] v = new HashSet<Vertex>[input.length][input[0].length];
//        for(int i=0;i<v.length;i++) {
//            for(int j=0;j<v[0].length;j++) {
//                v[i][j] = new HashSet<>();
//            }
//        }
//        Set<String> currentKeys = new HashSet<>();
//        Queue<Vertex> q = new LinkedList<Vertex>();
//        q.offer(start);
//        Vertex end = null;
//        boolean terminate = false;
//        while(!q.isEmpty()) {
//            Vertex curr = q.poll();
//            if('a' - input[curr.x][curr.y].charAt(0) >=0 && 'a' - input[curr.x][curr.y].charAt(0) <=10) {
//                //its a key, pick it up
//                currentKeys.add(input[curr.x][curr.y]);
//            }
//            Set<Vertex> neighbours = findNeighbours(v, currentKeys, input);
//            for(Vertex vertex:neighbours) {
//                //vertex.keys = currentKeys;
//                if(input[vertex.x][vertex.y].equals("+")) {
//                    vertex.prev = curr;
//                    end = vertex;
//                    terminate = true;
//                }
//                if(!v[vertex.x][vertex.y].contains(vertex)) {
//                    if(!(vertex.keys.size() == currentKeys.size() && vertex.keys.containsAll(currentKeys))) {
//                        Vertex v1 = new Vertex(vertex.x, vertex.y, currentKeys, curr);
//                        q.offer(v1);
//                        v[vertex.x][vertex.y].add(v1);
//                    }
//                }else{
//                    Vertex v1 = new Vertex(vertex.x, vertex.y, currentKeys, curr);
//                    q.offer(v1);
//                    v[vertex.x][vertex.y].add(v1);
//                }
//                
//            }
//        }
//        
//        
//    }
//
//    public Set<Vertex> findNeighbours(Vertex v, Set<String> currentKeys, String[][] input, Set<Vertex>[][] superSet) {
//        Set<Vertex> neighbours = new HashSet<Vertex>();
//        //4 neighbours
//        int x = v.x-1;
//        int y = v.y;
//        // if current is a door and u dont have the key or if its water, dont add else add
//        if(x >=0 && x<input.length && y>=0 && y<input[0].length) {
//            if(!input[x][y].equals("#")) {
//                if('A' - input[x][y].charAt(0) >=0 && 'A' - input[x][y].charAt(0) <=10) {
//                    if(currentKeys.contains(Character.toLowerCase(input[x][y].charAt(0)))) {
//                        neighbours.add(superSet[x][y]);  
//                    }
//                }else{
//                    neighbours.add(superSet[x][y]); 
//                }
//            }
//        }
//
//        
//        x = v.x+1;
//        y = v.y;
//        
//        if(x >=0 && x<input.length && y>=0 && y<input[0].length) {
//            if(!input[x][y].equals("#")) {
//                if('A' - input[x][y].charAt(0) >=0 && 'A' - input[x][y].charAt(0) <=10) {
//                    if(currentKeys.contains(Character.toLowerCase(input[x][y].charAt(0)))) {
//                        neighbours.add(superSet[x][y]);  
//                    }
//                }else{
//                    neighbours.add(superSet[x][y]); 
//                }
//            }
//        }
//        
//        x = v.x;
//        y = v.y-1;
//        
//        if(x >=0 && x<input.length && y>=0 && y<input[0].length) {
//            if(!input[x][y].equals("#")) {
//                if('A' - input[x][y].charAt(0) >=0 && 'A' - input[x][y].charAt(0) <=10) {
//                    if(currentKeys.contains(Character.toLowerCase(input[x][y].charAt(0)))) {
//                        neighbours.add(superSet[x][y]);  
//                    }
//                }else{
//                    neighbours.add(superSet[x][y]); 
//                }
//            }
//        }
//        
//        x = v.x;
//        y = v.y+1;
//        
//        if(x >=0 && x<input.length && y>=0 && y<input[0].length) {
//            if(!input[x][y].equals("#")) {
//                if('A' - input[x][y].charAt(0) >=0 && 'A' - input[x][y].charAt(0) <=10) {
//                    if(currentKeys.contains(Character.toLowerCase(input[x][y].charAt(0)))) {
//                        neighbours.add(superSet[x][y]);  
//                    }
//                }else{
//                    neighbours.add(superSet[x][y]); 
//                }
//            }
//        }
//        
//        return neighbours;
//        
//        
//    }


}
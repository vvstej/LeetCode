package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     Map<Integer,Vertex<Integer>> setOfVertices = new HashMap<Integer,Vertex<Integer>>();
     LinkedHashSet<Integer> courseOrder = new LinkedHashSet<Integer>();
     Queue<Vertex<Integer>> bfsQueue = new LinkedList<Vertex<Integer>>();
     for(int i=0;i<numCourses;i++){
    	 setOfVertices.put(i,new Vertex<Integer>(i));
     }
     for(int i=0;i<prerequisites.length;i++){
    		 Vertex<Integer> fromVertex = setOfVertices.get(prerequisites[i][1]);
    		 Vertex<Integer> toVertex = setOfVertices.get(prerequisites[i][0]);
    		 List<Vertex<Integer>> adjList = fromVertex.getAdjacencyList();
    		 adjList.add(toVertex);
    		 toVertex.inDegree++;
     }
     for(int i=0;i<numCourses;i++){
    	 Vertex<Integer> v = setOfVertices.get(i);
    	 if(v.inDegree==0){
    		 bfsQueue.add(v);
    	 }
     }
     if(bfsQueue.isEmpty()){
    	 return false;
     }
     while(!bfsQueue.isEmpty()){
    	 Vertex<Integer> nextCourse = bfsQueue.poll();
    	 if(courseOrder.contains(nextCourse.val)){
    		 return false;
    	 }
    	 courseOrder.add(nextCourse.val);
    	 for(Vertex<Integer> adjCourse : nextCourse.adjacencyList){
    		 adjCourse.inDegree--;
    		 if(adjCourse.inDegree==0)
    			 bfsQueue.add(adjCourse);
    		 
    	 }
     }
    return courseOrder.size()==numCourses;
    	
    }
    
    public static void main(String[] arg){
    	System.out.println(new CourseSchedule().canFinish(3, new int[][]{{1,0}}));
    }
}

class Vertex<T>{
	T val;
	int inDegree;
	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public int getInDegree() {
		return inDegree;
	}

	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}

	public List<Vertex<T>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<Vertex<T>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	List<Vertex<T>> adjacencyList;
	
	public Vertex(T val){
		this.val = val;
		this.inDegree = 0;
		adjacencyList = new ArrayList<Vertex<T>>();
	}
	
}

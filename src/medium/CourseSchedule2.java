package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
	     if(prerequisites==null || prerequisites.length==0){
	         return null;
	     }
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
	    	 return new int[]{};
	     }
	     while(!bfsQueue.isEmpty()){
	    	 Vertex<Integer> nextCourse = bfsQueue.poll();
	    	 if(courseOrder.contains(nextCourse.val)){
	    		 return new int[]{};
	    	 }
	    	 courseOrder.add(nextCourse.val);
	    	 for(Vertex<Integer> adjCourse : nextCourse.adjacencyList){
	    		 adjCourse.inDegree--;
	    		 if(adjCourse.inDegree==0)
	    			 bfsQueue.add(adjCourse);
	    		 
	    	 }
	     }
	     if(courseOrder.size()!=numCourses){
	    	 return new int[]{};
	     }
	     int[] result = new int[numCourses];
	     int j=0;
	     for(int course : courseOrder){
	    	 result[j++] = course;
	     }
	     return result;
	    	
	    }
	    
	    public static void main(String[] arg){
	    	System.out.println(new CourseSchedule().canFinish(3, new int[][]{{1,0}}));
	    }
	}


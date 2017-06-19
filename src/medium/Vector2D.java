package medium;

import java.util.ArrayList;
import java.util.List;

public class Vector2D {
	int listNumberPtr=0;
    int listValPtr=0;
    List<List<Integer>> backedList = new ArrayList<List<Integer>>();
    public Vector2D(List<List<Integer>> vec2d) {
        
    }

    public int next() {
		return listNumberPtr; 
    }

    public boolean hasNext() {
		return false;
        
    }
}

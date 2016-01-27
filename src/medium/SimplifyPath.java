package medium;

import java.util.ArrayDeque;
import java.util.Deque;

//"/home/../foo".split("/");
public class SimplifyPath {

	public String simplifyPath(String path) {
		StringBuilder finalPath = new StringBuilder();
		if(path==null || path.trim().equals("")){
			return "";
		}
		if(path.matches("/*")){
			return "";
		}
		String[] directories = path.split("/");
		Deque<String> pathStack = new ArrayDeque<String>();
		for(String directory : directories){
			if(directory.equals("..")){
				if(!pathStack.isEmpty())
					pathStack.pop();
			}else if(directory.matches("/*") || directory.equals(".")){
				// ignore
			}else{
				if(!directory.trim().equals("")){
					pathStack.push(directory);
				}
			}
		}
		//finalPath.append(pathStack.removeLast());
		finalPath.append("/");
		while(!pathStack.isEmpty()){
			finalPath.append(pathStack.removeLast());
			finalPath.append("/");
		}
		if(finalPath.toString().equals("/")){
			return finalPath.toString();
		}else{
			return finalPath.substring(0, finalPath.length()-1);
		}
		
	}
	
	public static void main(String[] arg){
		System.out.println(new SimplifyPath().simplifyPath("/../home/test/joy/../intest/joy1"));
	}
}

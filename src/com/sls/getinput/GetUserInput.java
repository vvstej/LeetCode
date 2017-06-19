package com.sls.getinput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GetUserInput {
    
	static HashMap<String,String> dep = new HashMap();
	static HashMap<String,String> install = new HashMap();
	static long intv =10000;
	
	public static void main (String args[]) throws InterruptedException{
		populateMap();
		populateInstal();
		System.out.println("what operation do u want to perform:");
		Scanner sc = new Scanner(System.in);
		String readIn = sc.nextLine();
		System.out.println(readIn);
		if (readIn.contains("DEPEND")){
			dependOps(readIn);
			
			
		}
		while(!readIn.equalsIgnoreCase("END")){
			System.out.println("what operation do u want to perform:");
			 sc = new Scanner(System.in);
			 readIn = sc.nextLine();
			System.out.println(readIn);
			//System.out.println(readIn);
			if (readIn.contains("DEPEND")){
				dependOps(readIn);
			}
			if(readIn.contains("LIST")){
			listInstall();
			}
			if(readIn.contains("INSTALL")){
				installElm(readIn);
			}
			if(readIn.contains("REMOVE")){
				removeElm(readIn);
			}
		}
		return;
		
		
		
	}
	
	public static String dependOps(String ops){
		
		StringBuffer value = new StringBuffer();
		String[] dependancies = ops.split("\\s+");
		for (int i = 1; i <= dependancies.length-1; i++ ){
		//	System.out.println(dependancies[i]);
			
			
				String key = dependancies[i];
				List<String> tmpValue = new ArrayList<String>(Arrays.asList(dependancies));
				tmpValue.remove(i);
				for (int k =0; k<=tmpValue.size()-1; k++){
			value.append(tmpValue.get(k)).append(" ");
				}
				String finalVal = value.toString();
				dep.put(key, finalVal);
			}
		
				
		
		
		return "done";
	}
	
	public static void populateMap() {
		dep.put("TELNET", "TELNET");
		dep.put("TCPIP", "TCPID");
		dep.put("NETCARD", "NETCARD");
		dep.put("BROWSER", "BROWSER");
		dep.put("DNS", "DNS");
	}
	
	public static void populateInstal(){
		install.put("TELNET", "No");
		install.put("TCPIP", "No");
		install.put("NETCARD", "No");
		install.put("BROWSER", "No");
		install.put("DNS", "No");
	}
	public static void listInstall(){
		 
		 Set set = install.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	    	  Map.Entry tst =(Map.Entry)iterator.next();
	    	  if(tst.getValue().toString().equalsIgnoreCase("Yes"));
	    	  System.out.println(tst.getValue().toString());
	      }
	         
		 
	}
	
	public static void installElm(String ops) throws InterruptedException{
		StringBuffer valueElm = new StringBuffer();
		String[] dependanciesElm = ops.split("\\s+");
		for (int i = 1; i <= dependanciesElm.length-1; i++ ){
			String tmpVl =install.get(dependanciesElm[i]);
			if(tmpVl.equalsIgnoreCase("Yes")){
				System.out.println("Already installed");
			}
			else{
				System.out.println("installing "+dependanciesElm[i]);
				Thread.sleep(intv);
				System.out.println(tmpVl +"installed successfuly");
				install.put(dependanciesElm[i], "Yes");
			}
				
			System.out.println(dependanciesElm[i]);
			
			
				
			}
		
	}

	
	public static void removeElm(String ops) throws InterruptedException{
		//StringBuffer valueElm = new StringBuffer();
		String[] dependanciesElm = ops.split("\\s+");
		
		for (int i = 1; i <= dependanciesElm.length-1; i++ ){
			String tmpVl =dep.get(dependanciesElm[i]);
			String[] chkSt = tmpVl.split("\\s+");
			for(String s : chkSt){
				
				install.put(s, "No");
				System.out.println("removed "+s+"successfully");
				
			}
					
			
				
			}
		
	}
}
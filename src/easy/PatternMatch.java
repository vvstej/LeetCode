package easy;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch {

	
	public static void main(String[] arg){
		String line = "OK (1445 tests)";
		String aLine = "OK (1 test)";
		String line1 = "blah_blah_results.txt";
		String line2 = "blah_blah_results_2.txt";
		String line3 = "blah_blah_results_21.txt";
		String line4 = "venkata.vepa\ntej";
		String line5 = "add 0 chunks 0 lines";
		Pattern p = Pattern.compile("\\d+ lines");
		Matcher m = p.matcher(line5);
		if(m.find()){
			m.group();
		}
		line4.split(",");
		List<String> lines = new ArrayList<String>();
		lines.add(line);
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);
		lines.add("results.txt");
		System.out.println(line.matches("OK\\s*\\(\\d+ tests*\\)"));
		System.out.println(aLine.matches("OK\\s*\\(1 test\\)"));
		
		File[] files = new File("/Users/venkata.vepa/blt/build/abs/main").listFiles(new FilenameFilter(){

			@Override
			public boolean accept(File dir, String name){ 
				return name.contains("credential");
			}
			
		});
//		for(String linez : lines){
//			Pattern p = Pattern.compile("results_?\\d*.txt");
//			Matcher m = p.matcher(linez);
//			if(m.find()){
//				System.out.println(m.group());
//			}
//		}
//		
		//System.out.println(files[0].getPath());

	}
}

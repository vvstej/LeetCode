package multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InvokeAll {

	public static void main(String[] arg) throws InterruptedException, ExecutionException{
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Callable<String> c1 = new Callable<String>(){

			@Override
			public String call() throws Exception {
				TimeUnit.SECONDS.sleep(2);
				return "Call1";
			}
		};
		Callable<String> c2 = () -> {
			return "Call2";
		};
		Callable<String> c3 = () -> {
			return "Call3";
		};
		Callable<String>[] callables = new Callable[]{c1,c2,c3};
		List<Callable<String>> callableList = Arrays.asList(callables);
		List<Future<String>> futures = executorService.invokeAll(callableList);
		for(Future<String> future : futures){
			System.out.println(future.isDone());
		}
		
	}
}

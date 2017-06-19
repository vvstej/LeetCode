package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//README : Input 2 arguments , first one should be path to the application instance data text file , the format of which is "App Name";"Message Type it produce";"Frequency to produce this message(Integer and is considered as time in milliseconds")
// second file should be the path to the message type text file , the format is "Message Type;Time taken to be produced"
public class Simulator {

	// unbounded queue, for simplicity this is one queue which does not care
	// about the priority of the messages
	private static LinkedBlockingQueue<MessageType> pQueue = new LinkedBlockingQueue<MessageType>();

	public static void main(String[] arg) throws Exception {
		List<ApplicationInstance> appInstances = new ArrayList<ApplicationInstance>(5);
		List<Consumer> consumers = new ArrayList<Consumer>(5);
		Map<String, MessageType> messageTypes = new HashMap<String, MessageType>();

		// Stats collection

		// read message types
		FileReader typeReader = new FileReader(new File(arg[1]));
		BufferedReader typeBufReader = new BufferedReader(typeReader);
		String typeLine = typeBufReader.readLine();
		while (typeLine != null) {
			String[] type = typeLine.split(";");
			if (type.length != 2)
				throw new Exception("Invalid message input");
			messageTypes.put(type[0], new MessageType(type[0], Long.parseLong(type[1])));
			typeLine = typeBufReader.readLine();
		}
		typeBufReader.close();

		// read application instance data

		FileReader fReader = new FileReader(new File(arg[0]));
		BufferedReader bufReader = new BufferedReader(fReader);
		String line = bufReader.readLine();
		while (line != null) {
			String[] input = line.split(";");
			if (input.length != 3)
				throw new Exception("Invalid application instance input");
			MessageType type = messageTypes.get(input[1]);
			ApplicationInstance instance = new ApplicationInstance(input[0], type, Long.parseLong(input[2]));
			instance.setQueue(pQueue);
			appInstances.add(instance);
			line = bufReader.readLine();
		}
		bufReader.close();
		for (int i = 0; i < 5; i++) {
			Consumer c = new Consumer("Consumer" + i);
			c.setpQueue(pQueue);
			consumers.add(c);
		}
		ScheduledExecutorService producerService = Executors.newScheduledThreadPool(5);
		// List<ExecutorService> consumerServices = new
		// ArrayList<ExecutorService>(5);
		ScheduledExecutorService consumerThreadPool = Executors.newScheduledThreadPool(5);
		// even though its average production time, for simplicity this
		// assumption is strictly for this time(instead of average).
		for (int index = 0; index < 5; index++) {
			// ScheduledExecutorService service = producerServices.get(0);
			consumerThreadPool.scheduleAtFixedRate(consumers.get(index), 0, 25, TimeUnit.MILLISECONDS);
			ApplicationInstance instance = appInstances.get(index);
			producerService.scheduleAtFixedRate(instance, 0, instance.getGenerationTimeMillis(), TimeUnit.MILLISECONDS);

		}
		// kill producers after 1 minutes, as termination, consumers are
		// terminated when all production is done
		// Thread.sleep(1*60*60*1000);
		producerService.awaitTermination(10000, TimeUnit.MILLISECONDS);
		producerService.shutdown();
		consumerThreadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
		consumerThreadPool.shutdown();
		// Application Instance stats
		for (int index = 0; index < 5; index++) {
			Pair<Integer, Long> stats = appInstances.get(index).getInstanceStats();
			System.out.println("Application" + appInstances.get(index).getName() + "produced " + stats.getX()
					+ " messages of type" + appInstances.get(index).getMessageType().getMessageType() + " in "
					+ stats.getY() + " milliseconds");
		}
		for (int index = 0; index < 5; index++) {
			Map<String, Pair<Integer, Long>> stats = consumers.get(index).getConsumerStats();
			for (String key : stats.keySet()) {
				System.out.println("Consumer" + index + " consumed " + stats.get(key).getX() + " messages of type "
						+ key + " in " + stats.get(key).getY() + " milliseconds");
			}

		}
	}
}

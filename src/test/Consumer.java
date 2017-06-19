package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
	private LinkedBlockingQueue<MessageType> pQueue;
	private String consumerName;
	Map<String,Pair<Integer,Long>> consumerStats = new HashMap<String,Pair<Integer,Long>>();

	public Map<String, Pair<Integer, Long>> getConsumerStats() {
		return consumerStats;
	}

	public void setConsumerStats(Map<String, Pair<Integer, Long>> consumerStats) {
		this.consumerStats = consumerStats;
	}

	public Consumer(String name) {
		this.consumerName = name;
	}

	public String getConsumer() {
		return this.consumerName;
	}

	public void setConsumer(String consumer) {
		this.consumerName = consumer;
	}

	public void setpQueue(LinkedBlockingQueue<MessageType> pQueue) {
		this.pQueue = pQueue;
	}

	@Override
	public void run() {
		try {
			MessageType message = pQueue.take();
				System.out.println("Consumer "+this.consumerName +" consuming message of type " + message.getMessageType());
				Thread.sleep(message.getMeanProcessingTimeMillis());
				System.out.println("Consumer "+this.consumerName+"Consumed Message of type " + message.getMessageType() + " after processing it for "
						+ message.getMeanProcessingTimeMillis() + " milli seconds");
				Pair<Integer,Long> stats = consumerStats.get(message.getMessageType());
				if(stats==null){
					stats = new Pair<Integer,Long>(1,message.getMeanProcessingTimeMillis());
				}
				else{
					int count = stats.getX();
					count++;
					long totalTime = stats.getY();
					totalTime+=message.getMeanProcessingTimeMillis();
					stats.setX(count);
					stats.setY(totalTime);
				}
				consumerStats.put(message.getMessageType(), stats);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

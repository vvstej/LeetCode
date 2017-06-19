package test;

import java.util.concurrent.LinkedBlockingQueue;

public class ApplicationInstance implements Runnable {

	private LinkedBlockingQueue<MessageType> pQueue; 
	Pair<Integer,Long> instanceStats = new Pair<Integer,Long>();

	public Pair<Integer, Long> getInstanceStats() {
		return instanceStats;
	}

	public void setInstanceStats(Pair<Integer, Long> instanceStats) {
		this.instanceStats = instanceStats;
	}

	public ApplicationInstance(String name, MessageType type, long generationTime) {
		this.name = name;
		this.messageType = type;
		this.generationTimeMillis = generationTime;
	}

	private String name;

	public void setQueue(LinkedBlockingQueue<MessageType> queue) {
		this.pQueue = queue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public long getGenerationTimeMillis() {
		return generationTimeMillis;
	}

	public void setGenerationTimeMillis(long generationTimeMillis) {
		this.generationTimeMillis = generationTimeMillis;
	}

	public long getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(long standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	private MessageType messageType;
	private long generationTimeMillis;
	private long standardDeviation;

	@Override
	public void run() {
			try {
				System.out.println("Producer " + this.getName() + " producing message of type "
						+ this.getMessageType().getMessageType());
				//generation time assumed to be 100 milli seconds
				Thread.sleep(1000);
				pQueue.put(this.messageType);
				System.out.println("Producer " + this.getName() + " produced message of type "
						+ this.getMessageType().getMessageType() + " in " + this.generationTimeMillis);
				Integer noOfMessages = instanceStats.getX();
				Long totalTime = instanceStats.getY();
				if(noOfMessages==null){
					noOfMessages = new Integer(0);
				}else{
					noOfMessages++;					
				}
				
				if(totalTime==null){
					totalTime = new Long(0);
				}else{
					totalTime+=100;
					
				}
				instanceStats.setY(totalTime);
				instanceStats.setX(noOfMessages);
				this.setInstanceStats(instanceStats);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	}

}

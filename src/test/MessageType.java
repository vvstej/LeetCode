package test;

public class MessageType {

	public MessageType(String messageType, long meanTime) {
		this.messageType = messageType;
		this.meanProcessingTimeMillis = meanTime;
	}

	private String messageType;

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public long getMeanProcessingTimeMillis() {
		return meanProcessingTimeMillis;
	}

	public void setMeanProcessingTimeMillis(long meanProcessingTimeMillis) {
		this.meanProcessingTimeMillis = meanProcessingTimeMillis;
	}

	public long getStdDeviationTimeMillis() {
		return stdDeviationTimeMillis;
	}

	public void setStdDeviationTimeMillis(long stdDeviationTimeMillis) {
		this.stdDeviationTimeMillis = stdDeviationTimeMillis;
	}

	private long meanProcessingTimeMillis;
	private long stdDeviationTimeMillis;

}

package com.example.demo.stream.model;

import java.util.Date;
import java.util.UUID;

public class Message<T>
{
	private String messageType;
	private String id = UUID.randomUUID().toString(); // unique id of this
	private String traceId = UUID.randomUUID().toString(); // trace id, default:
	private String sender = "Admin";
	private Date timestamp = new Date();
	private String correlationId;
	private T payload;
	
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTraceId() {
		return traceId;
	}
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public T getPayload() {
		return payload;
	}
	public void setPayload(T payload) {
		this.payload = payload;
	}

	

}
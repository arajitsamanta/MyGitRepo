package com.arajit.code.practise.util;

public interface IMessageSender {
	void close() throws Exception;

	void send(String message) throws Exception;

	void connect(String hostname, String portNumber, String QueueName)
			throws Exception;
}
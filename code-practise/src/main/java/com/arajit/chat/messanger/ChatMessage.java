/**
 * 
 */
package com.arajit.chat.messanger;

import java.io.Serializable;

/**
 * @author as47775
 * 
 */
public class ChatMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7877926695294655327L;

	// The different types of message sent by the Client
	// WHOISIN to receive the list of the users connected
	// MESSAGE an ordinary message
	// LOGOUT to disconnect from the Server
	static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2;
	private int type;
	private String message;

	// constructor
	ChatMessage(int type, String message) {
		this.type = type;
		this.message = message;
	}

	// getters
	int getType() {
		return type;
	}

	String getMessage() {
		return message;
	}
}

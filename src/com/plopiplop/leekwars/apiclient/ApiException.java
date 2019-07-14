package com.plopiplop.leekwars.apiclient;

public class ApiException extends Throwable {

	public ApiException(String method, String url, String params) {
		super(String.format("Error while calling API using %s (url=%s, params=%s)", method, url, params));
	}
}

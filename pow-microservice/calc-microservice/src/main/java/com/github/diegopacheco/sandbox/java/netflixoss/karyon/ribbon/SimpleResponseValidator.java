package com.github.diegopacheco.sandbox.java.netflixoss.karyon.ribbon;

import io.reactivex.netty.protocol.http.client.HttpClientResponse;
import org.slf4j.Logger;
import com.netflix.ribbon.ResponseValidator;
import com.netflix.ribbon.ServerError;
import com.netflix.ribbon.UnsuccessfulResponseException;
import org.slf4j.LoggerFactory;


@SuppressWarnings("rawtypes")
public class SimpleResponseValidator implements ResponseValidator<HttpClientResponse> {

	private Logger logger = LoggerFactory.getLogger(SimpleResponseValidator.class);

	@Override
	public void validate(HttpClientResponse response) throws UnsuccessfulResponseException,ServerError {
		logger.info("Validator: " + response);
	}
}
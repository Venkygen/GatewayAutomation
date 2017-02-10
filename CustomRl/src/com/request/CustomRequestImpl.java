/**
 * Copyright (c) 2013 - 2014 WaveMaker, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of WaveMaker, Inc.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the source code license agreement you entered into with WaveMaker, Inc.
 */
package com.request;

import java.util.Arrays;

import com.wavemaker.gateway.client.sdk.custom.policy.event.RequestBodyEvent;
import com.wavemaker.gateway.client.sdk.custom.policy.listener.GatewayRequestBodyListener;
import com.wavemaker.gateway.client.sdk.custom.policy.model.ClientResponse;
import com.wavemaker.gateway.client.sdk.custom.policy.model.GatewayResponse;
import com.wavemaker.gateway.client.sdk.custom.policy.model.PolicyResponse;

public class CustomRequestImpl implements GatewayRequestBodyListener {

	// adding a dummy impl for testing.remove this later
	public PolicyResponse execute(RequestBodyEvent requestBodyEvent) {

		PolicyResponse response = GatewayResponse.CONTINUE;
		requestBodyEvent.getHeaders().addHeader("ADD_HEADER", "SUCCESS");

		ClientResponse clientResponse = new ClientResponse();
		clientResponse.setStatus(200);
		clientResponse.setStatusMessage("Status Message from Handler");
		clientResponse.addHeader("Header1", "Value1");
		clientResponse.addHeader("Header2", Arrays.asList("Value2-1", "Value2-2"));
		clientResponse.setResponseBody("******Response Body from handler******".getBytes());
		response = clientResponse;
		return response;
	}
}

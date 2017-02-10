package com.response;

/**
 * Copyright (c) 2013 - 2014 WaveMaker, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of WaveMaker, Inc.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the source code license agreement you entered into with WaveMaker, Inc.
 */
import java.util.Arrays;

import com.wavemaker.gateway.client.sdk.custom.policy.event.ResponseBodyEvent;
import com.wavemaker.gateway.client.sdk.custom.policy.listener.GatewayResponseBodyListener;
import com.wavemaker.gateway.client.sdk.custom.policy.listener.impl.SampleRequestBodyListener;
import com.wavemaker.gateway.client.sdk.custom.policy.logger.GWLogger;
import com.wavemaker.gateway.client.sdk.custom.policy.logger.GWLoggerFactory;
import com.wavemaker.gateway.client.sdk.custom.policy.model.ClientResponse;
import com.wavemaker.gateway.client.sdk.custom.policy.model.GatewayResponse;
import com.wavemaker.gateway.client.sdk.custom.policy.model.PolicyResponse;

public class CustomResponseImpl implements GatewayResponseBodyListener {

	public PolicyResponse execute(ResponseBodyEvent responseBodyContext) {

		PolicyResponse response = GatewayResponse.CONTINUE;

		responseBodyContext.getHeaders().addHeader("ADD_HEADER", "SUCCESS");

		responseBodyContext.getHeaders().setHeader("Server", "Gateway-Server");
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

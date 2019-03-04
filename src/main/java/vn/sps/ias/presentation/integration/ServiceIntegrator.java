package vn.sps.ias.presentation.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import vn.sps.ias.constant.Channels;
import vn.sps.ias.domain.Request;
import vn.sps.ias.domain.Response;

@MessageEndpoint
public class ServiceIntegrator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceIntegrator.class);

    @ServiceActivator(inputChannel = Channels.INPUT_CHANNEL)
    public Response convert(Request request) {
        final Response response = new Response();

        try {
            LOGGER.info("Received message content: [{}]", request.getId());
            response.setExtractedData(request.getId() + "'s extracted data");
        }
        catch (Exception e) {
            LOGGER.error("Error", e);
        }

        return response;
    }
}

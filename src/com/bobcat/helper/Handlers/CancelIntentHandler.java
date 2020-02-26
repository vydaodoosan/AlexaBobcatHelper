package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;
import static com.amazon.ask.request.Predicates.*;

public class CancelIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.CancelIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        return handlerInput.getResponseBuilder()
                .withSpeech("Action has been canceled.")
                .withSimpleCard("Bobcat Helper","Action has been canceled.")
                .withReprompt("Action has been canceled.")
                .build();
    }
}

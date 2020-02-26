package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;
import static com.amazon.ask.request.Predicates.*;

public class FallBackHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return  handlerInput.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speach = "Bobcat Helper can't help with that. Please say help to read all of the available command ";
        String title = "Bobcat Helper";
        return handlerInput.getResponseBuilder()
                .withSpeech(speach)
                .withSimpleCard(title,speach)
                .withReprompt(speach)
                .build();
    }
}

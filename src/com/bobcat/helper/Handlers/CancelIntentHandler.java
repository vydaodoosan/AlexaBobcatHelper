package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Template;
import com.bobcat.helper.Util.CreateTemplateForDevice;

import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;

public class CancelIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("AMAZON.CancelIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String title ="Bobcat Helper";
        String speechText = "Actions has been canceled";
        String imageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";
        Template template = new CreateTemplateForDevice().templateTitle(speechText,"",imageURL);

        if (null != handlerInput.getRequestEnvelope().getContext().getDisplay()){
            return handlerInput.getResponseBuilder()
                    .addRenderTemplateDirective(template)
                    .withSimpleCard(title,speechText)
                    .withSpeech(speechText)
                    .withReprompt(speechText)
                    .build();
        }
        else{
            return handlerInput.getResponseBuilder()
                    .withSimpleCard(title,speechText)
                    .withSpeech(speechText)
                    .withReprompt(speechText)
                    .build();
        }
    }
}

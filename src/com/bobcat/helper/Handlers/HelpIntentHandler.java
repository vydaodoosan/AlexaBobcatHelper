package com.bobcat.helper.Handlers;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Template;
import com.bobcat.helper.Util.CreateTemplateForDevice;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.*;

public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return  handlerInput.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String titile = "Bobcat Helper";
        String primaryText = "This is all the available command for Bobcat Helper: ";
        String secondaryText = "1. Show me how to change engine oil.";
        String speechText = primaryText + secondaryText;
        secondaryText = "<br/>" + secondaryText;
        String imageURL = "https://bobcat-helper-project.s3.amazonaws.com/1.png";


        Template template = new CreateTemplateForDevice().templateTitle(primaryText,secondaryText,imageURL);

        if (null != handlerInput.getRequestEnvelope().getContext().getDisplay()){
            handlerInput.getResponseBuilder()
                    .addRenderTemplateDirective(template)
                    .withSpeech(speechText)
                    .withSimpleCard(titile,speechText)
                    .withReprompt(speechText)
                    .build();
        }
        else{
            handlerInput.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(titile,speechText)
                    .withReprompt(speechText)
                    .build();
        }
        return Optional.empty();
    }
}

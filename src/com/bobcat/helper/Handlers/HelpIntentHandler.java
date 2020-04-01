package com.bobcat.helper.Handlers;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Template;
import com.bobcat.helper.Util.CreateTemplateForDevice;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;


public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return  handlerInput.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String titile = "Bobcat Helper";
        String primaryText = "This is all the available command for Bobcat Helper: ";
        String secondaryText = "1. Show me the instruction on how to change engine oil. 2. Show me the video on how to change engine oil. 3. Show me how to maintain my bobcat machines. 4. Show me the fluid capacities";
        String speechText = primaryText + secondaryText;
        secondaryText = "1. Show me the instruction on how to change engine oil. <br/>2. Show me the video on how to change engine oil. <br/>3. Show me how to maintain my bobcat machines. <br/>4. Show me the fluid capacities";
        String imageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";


        Template template = new CreateTemplateForDevice().templateTitle(primaryText,secondaryText,imageURL);

        if (null != handlerInput.getRequestEnvelope().getContext().getDisplay()){
            return handlerInput.getResponseBuilder()
                    .addRenderTemplateDirective(template)
                    .withSpeech(speechText)
                    .withSimpleCard(titile,speechText)
                    .withReprompt(speechText)
                    .build();
        }
        else{
            return handlerInput.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(titile,speechText)
                    .withReprompt(speechText)
                    .build();
        }
    }
}

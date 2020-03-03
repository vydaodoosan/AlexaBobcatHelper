package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Template;
import com.bobcat.helper.Util.CreateTemplateForDevice;

import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;


public class FallBackHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return  handlerInput.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String speechText = "Bobcat Helper can't help with that. Please say help to read all of the available commands.";
        String title = "Bobcat Helper";
        String imageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";

        Template template = new CreateTemplateForDevice().templateTitle("Bobcat Helper can't help with that","Please say help" +
                " to read all the available commands.",imageURL);

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

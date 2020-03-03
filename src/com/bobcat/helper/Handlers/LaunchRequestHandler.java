package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Template;
import com.bobcat.helper.Util.CreateTemplateForDevice;

import java.util.Optional;
//Import this to be able to use requestTYpe
import static com.amazon.ask.request.Predicates.requestType;


public class LaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {

        //Feed data
        CreateTemplateForDevice templateCreate = new CreateTemplateForDevice();
        String title = "Bobcat Helper";
        String primaryText = "<div align='center'><b>Welcome to Bobcat Helper.</b></div>";
        String secondaryText = "Would you like me to help you with anything ?";
        String speechText = "Welcome to Bobcat Helper. " + secondaryText +  " I can show you how to change engine oil for your bobcat machine. You can also say help to hear all the available commands.";
        String imageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";
        String WaitSeconds = "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>";

        Template template =  templateCreate.templateTitle(primaryText,"",imageURL);

        //Check if device support display interface
        if (null != handlerInput.getRequestEnvelope().getContext().getDisplay())
        {
            return  handlerInput.getResponseBuilder()
                    .withSpeech(speechText + WaitSeconds)
                    .withSimpleCard(title,primaryText)
                    .addRenderTemplateDirective(template)
                    .withReprompt(speechText + WaitSeconds)
                    .withShouldEndSession(false)
                    .build();
        }
        else
        {
            return handlerInput.getResponseBuilder()
                    .withSpeech(speechText + WaitSeconds)
                    .withSimpleCard(title,primaryText)
                    .withReprompt(speechText + WaitSeconds)
                    .withShouldEndSession(false)
                    .build();
        }
    }
}

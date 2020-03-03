package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Template;
import com.bobcat.helper.Model.CustomAttributes;
import com.bobcat.helper.Util.CreateTemplateForDevice;
import com.bobcat.helper.Util.InstructionGenerator;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class StopIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return  handlerInput.matches(intentName("AMAZON.StopIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
            String speechText = "Thank you for using Bobcat Helper. Have a good day";
            String title = "Bobcat Helper";
            Template tmpTemplate = new CreateTemplateForDevice().templateTitle("Thank you for using Bobcat Helper.","Have a good day.","https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png");
            if (null != handlerInput.getRequestEnvelope().getContext().getDisplay())
            {
                return  handlerInput.getResponseBuilder()
                        .withSpeech(speechText)
                        .withSimpleCard(title,speechText)
                        .addRenderTemplateDirective(tmpTemplate)
                        .withReprompt(speechText)
                        .withShouldEndSession(true)
                        .build();
            }
            else
            {
                return handlerInput.getResponseBuilder()
                        .withSpeech(speechText)
                        .withSimpleCard(title,speechText)
                        .withReprompt(speechText)
                        .withShouldEndSession(true)
                        .build();
            }
        }
}

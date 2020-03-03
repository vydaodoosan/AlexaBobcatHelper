package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;

public class VideoPlayingIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("VideoPlayingIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String videoUrl = "https://bobcat-helper-project.s3.amazonaws.com/How+to+Change+Engine+Oil+on+Bobcat+Engines.mp4";
        String videoTitle =  "How to Change Engine Oil on Bobcat Engines";
        if (null != handlerInput.getRequestEnvelope().getContext().getDisplay()){
            return handlerInput.getResponseBuilder()
                    .addVideoAppLaunchDirective(videoUrl,videoTitle,"")
                    .withShouldEndSession(false)
                    .addHintDirective("Click back button to go back")
                    .withReprompt("")
                    .build();
        }
        else {
            return handlerInput.getResponseBuilder()
                    .withSpeech("Alexa can't play video on this devices. Please say next to hear the instructions")
                    .withSimpleCard("Bobcat Helper","Alexa can't play video on this devices. Please say next to hear the instructions")
                    .withReprompt("Alexa can't play video on this devices. Please say next to hear the instructions")
                    .withShouldEndSession(false)
                    .build();
        }
    }
}

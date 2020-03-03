package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.bobcat.helper.Model.CustomAttributes;
import com.bobcat.helper.Util.InstructionGenerator;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

public class PreviousIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return  handlerInput.matches(intentName("AMAZON.PreviousIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        Map<String, Object> instructionSessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
        int currentCounter = (int) instructionSessionAttributes.get(CustomAttributes.COUNTER);
        if ((currentCounter-1) >0){
            instructionSessionAttributes.put(CustomAttributes.COUNTER,currentCounter-1);
            return new InstructionGenerator().generateQuestion(handlerInput);
        }
        else{
            instructionSessionAttributes.put(CustomAttributes.COUNTER,0);
            return new InstructionGenerator().generateQuestion(handlerInput);
        }
    }
}

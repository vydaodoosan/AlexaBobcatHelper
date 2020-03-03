package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazonaws.services.dynamodbv2.xspec.NULL;
import com.bobcat.helper.Model.CustomAttributes;
import com.bobcat.helper.Util.InstructionGenerator;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FluidCapacitiesHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("FluidCapacitiesIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        Request request = handlerInput.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        String speechText;
        Slot machineName = slots.get("bobcatMachines");
        if(machineName != null && machineName.getResolutions() != null && machineName.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
            String tmpMachineName = machineName.getValue();
            Map<String,Object> instructionSessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
            instructionSessionAttributes.put(CustomAttributes.STAGE,"fluid_capacities");
            instructionSessionAttributes.put(CustomAttributes.MACHINENAME,tmpMachineName);
            return new InstructionGenerator().generateQuestion(handlerInput);
        }
        else {
            String tmpStringMachine = machineName.getValue();
            speechText = "You called " + tmpStringMachine + " and it's not in the list of your machine. Please say the command again with a different machine.";
            return handlerInput.getResponseBuilder()
                    .withSpeech(speechText)
                    .withReprompt(speechText)
                    .withShouldEndSession(false)
                    .build();
        }
    }
}

package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.bobcat.helper.Model.CustomAttributes;
import com.bobcat.helper.Util.InstructionGenerator;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

public class OilChangeRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("FindMachineIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        Request request = handlerInput.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        String speechText;
        //Get User Input Machine
        Slot machineName = slots.get("bobcatMachines");
        if(machineName != null && machineName.getResolutions().toString().contains("ER_SUCCESS_MATCH"))
        {
            String tmpStringMachine = machineName.getValue().toLowerCase();
            tmpStringMachine = tmpStringMachine.replaceAll("\\s+", "");
            Map<String, Object> instructionSessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
            instructionSessionAttributes.put(CustomAttributes.MACHINENAME,tmpStringMachine);
            instructionSessionAttributes.put(CustomAttributes.STAGE,"oil_instruction");
            instructionSessionAttributes.put(CustomAttributes.COUNTER,0);
            return new InstructionGenerator().generateQuestion(handlerInput);
        }
        else{
            String tmpStringMachine = machineName.getValue();
            speechText = "You called " + tmpStringMachine + " and it's not in the list of your machine. Please say the command again with a different machine.";
            return handlerInput.getResponseBuilder()
                    .withSpeech(speechText)
                    .withReprompt(speechText)
                    .withSimpleCard("Bobcat Helper",speechText)
                    .withShouldEndSession(false)
                    .build();
        }
    }
}

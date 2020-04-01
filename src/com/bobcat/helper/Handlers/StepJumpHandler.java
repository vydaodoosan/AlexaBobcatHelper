package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.bobcat.helper.Model.CustomAttributes;
import com.bobcat.helper.Util.InstructionGenerator;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class StepJumpHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("StepJump"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        int jumpCount = 0;
        Request request = handlerInput.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        Slot stepNumber = slots.get("stepNumber");
        jumpCount = Integer.parseInt(stepNumber.getValue());
        Map<String, Object> instructionSessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
        int currentCounter = (int) instructionSessionAttributes.get(CustomAttributes.COUNTER);
        String stageOption = (String) instructionSessionAttributes.get(CustomAttributes.STAGE);
        if (currentCounter > 10 && stageOption.equals("oil_instruction")){
            instructionSessionAttributes.put(CustomAttributes.COUNTER,10);
            return new InstructionGenerator().generateQuestion(handlerInput);
        }
        else if (currentCounter > 6 && stageOption.equals("service_schedule")){
            instructionSessionAttributes.put(CustomAttributes.COUNTER,6);
            return new InstructionGenerator().generateQuestion(handlerInput);
        }
        else if (stageOption.equals("fluid_capacities")){
            return new FluidCapacitiesHandler().init(handlerInput);
        }
        else {
            instructionSessionAttributes.put(CustomAttributes.COUNTER,jumpCount);
            return new InstructionGenerator().generateQuestion(handlerInput);
        }
    }
}

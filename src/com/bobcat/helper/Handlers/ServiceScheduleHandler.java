package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.bobcat.helper.Model.CustomAttributes;
import com.bobcat.helper.Util.InstructionGenerator;

import java.util.Map;
import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;

public class ServiceScheduleHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("ServiceScheduleIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        Map<String, Object> instructionSessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
        instructionSessionAttributes.put(CustomAttributes.COUNTER,0);
        instructionSessionAttributes.put(CustomAttributes.STAGE,"service_schedule");
        instructionSessionAttributes.put(CustomAttributes.MACHINENAME,"s630");
        return new InstructionGenerator().generateQuestion(handlerInput);
    }
}

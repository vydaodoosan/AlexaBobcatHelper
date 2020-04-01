package com.bobcat.helper.Handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.model.interfaces.display.Template;
import com.amazonaws.services.dynamodbv2.xspec.NULL;
import com.bobcat.helper.Model.CustomAttributes;
import com.bobcat.helper.Util.CreateTemplateForDevice;
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
        //Get User Input Machine
        Slot machineName = slots.get("bobcatMachines");
        if(machineName != null && machineName.getResolutions().toString().contains("ER_SUCCESS_MATCH"))
        {
            Map<String, Object> instructionSessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
            instructionSessionAttributes.put(CustomAttributes.STAGE,"fluid_capacities");
            return init(handlerInput);

        }
        else {
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

    public Optional<Response> init(HandlerInput handlerInput) {
                String title = "S630's Fluid Capacities";
                String primaryText = "Fluid Capacities";
                String bgImageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";
                String secondaryText = null; String speechText = null;
                String[] content = {"Fuel 90,5 L (23.9 U.S. gal)"
                        , "Engine Oil with Filter Change 8,6 L (9.1 qt)"
                        , "Engine Cooling System with Heater 11,8 L (3.1 U.S. gal)"
                        , "Engine Cooling System without Heater 11,4 L (3.0 U.S. gal)"
                        , "Hydraulic / Hydrostatic Reservoir 10,2 L (2.7 U.S. gal)"
                        , "Hydraulic / Hydrostatic System 41,6 L (11.0 U.S. gal)"
                        , "Chaincase Reservoir 39,2 L (10.35 U.S. gal)"
                        , "Air Conditioning Refrigerant (R-134a) 0,9 kg (2.0 lb)"};
                for (String text : content) {
                    secondaryText = secondaryText + "For " + text + " ";
                }
                speechText = primaryText + ". " + secondaryText;
                secondaryText = "";
                for (String text : content) {
                    secondaryText = secondaryText + "<br/>" + "For " + text + " ";
                }
                secondaryText = "<font size='2'>" + secondaryText + "</font>";
                primaryText = "<b>" + primaryText + "</b>";
            String OneMinuteWait = "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>";
            Template tmpTemplate = new CreateTemplateForDevice().template1(title,primaryText,secondaryText,bgImageURL);
                return  handlerInput.getResponseBuilder()
                    .withSpeech(speechText + OneMinuteWait)
                    .withSimpleCard(title,speechText)
                    .addRenderTemplateDirective(tmpTemplate)
                    .withReprompt(speechText + OneMinuteWait)
                    .withShouldEndSession(false)
                    .build();
            }
        }

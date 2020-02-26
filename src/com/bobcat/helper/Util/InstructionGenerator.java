package com.bobcat.helper.Util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Template;

import com.bobcat.helper.Model.CustomAttributes;

import java.util.Map;
import java.util.Optional;

public class InstructionGenerator {
    private Template tmpTemplate;

    public Optional<Response> generateQuestion(HandlerInput handlerInput) {
        Map<String, Object> instructionSessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
        int currentCounter = (int) instructionSessionAttributes.get(CustomAttributes.COUNTER);
        String machineName = (String) instructionSessionAttributes.get(CustomAttributes.MACHINENAME);
        String title = "S630's Engine Oil Change Instruction", primaryText = null, secondaryText = null, speechText = null, imageURL = null, bgImageURL = "https://bobcat-helper-project.s3.amazonaws.com/1.png";
        if  (machineName.equals("s630")) {
            //Generate Question step by step
            if (currentCounter == 0) {
                primaryText = "ENGINE LUBRICATION SYSTEM. Removing And Replacing Oil And Filter";
                secondaryText = "For the service interval for replacing the engine oil and filter please see SERVICE SCHEDULE on Page 10-70-1.";
                speechText = primaryText + ". " + secondaryText;
                bgImageURL = "https://bobcat-helper-project.s3.amazonaws.com/BobcatBigBackground.png";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/S630Modelv2.png";
            } else if (currentCounter == 2) {
                primaryText = "Step " + currentCounter;
                secondaryText = "Operate the engine until coolant reaches normal operating temperature and stop the engine. " +
                        "The oil drain hose is located behind a cover (Item 2) under the right rear corner of the loader (Inset). " +
                        "Please remove the cover mounting bolts (Item 1) and remove the cover (Item 2). After that you can open the rear door.";
                speechText = primaryText + ". " + secondaryText;
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic1.png";
            } else if (currentCounter == 3) {
                primaryText = "Step " + currentCounter;
                secondaryText = "The oil drain hose (Item 1) storage location is on top of the fuel tank. Please remove the hose from the storage location and route through the opening (Item 2).";
                speechText = primaryText + ". " + secondaryText;
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic2.png";
            } else if (currentCounter == 4) {
                primaryText = "Step " + currentCounter;
                secondaryText = "Remove the oil drain cap (Item 1). From the oil drain hose and drain the oil into a container. Recycle or dispose of used oil in an environmentally safe manner. " +
                        "After that please install and tighten the oil drain cap. ";
                speechText = primaryText + ". " + secondaryText;
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic3.png";
            } else if (currentCounter == 5) {
                primaryText = "Step " + currentCounter;
                secondaryText = "Return the oil drain hose (Item 1) to the storage location on top of the fuel tank.";
                speechText = primaryText + ". " + secondaryText;
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic2.png";
            } else if (currentCounter == 6) {
                primaryText = "Step " + currentCounter;
                secondaryText = "Install the cover and the cover mounting bolts and tighten all bolts";
                speechText = primaryText + ". " + secondaryText;
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic1.png";
            } else if (currentCounter == 7) {
                primaryText = "Step " + currentCounter;
                secondaryText = "Remove the oil filter (Item 3) and clean the filter base. " +
                        "After that, put clean oil on the new filter gasket, install the new filter, and hand tighten. Please use genuine Bobcat filter only. " +
                        "After that, please remove the oil fill cap (Item 2), put oil into the engine, and replace the oil fill cap. Please see Capacities on Page SPEC-10-5 and do not overfill.";
                speechText = primaryText + ". " + secondaryText;
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic4.png";
            } else if (currentCounter == 8) {
                primaryText = "Step " + currentCounter;
                secondaryText = "Start the engine and allow to operate for several minutes. After that, please stop the engine and check for leaks at the filter. "
                        + "Diesel fuel or hydraulic fluid under pressure can penetrate skin or eyes, causing serious injury or death. Fluid leaks under pressure may not be visible. Use a piece of cardboard or wood to find leaks. "
                        + "Do not use your bare hand. Wear safety goggles. If fluid enters skin or eyes, get immediate medical attention from a physician familiar with this injury.";
                speechText = primaryText + ". " + secondaryText;
                secondaryText = "<font size='2'>" + secondaryText + "</font>";
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic5.png";
            } else if (currentCounter == 9) {
                primaryText = "Step " + currentCounter;
                secondaryText = "Remove the dipstick (Item 1) " + "and check the oil level. " +
                        "After that, add oil as needed if oil level is not at the top mark on the dipstick.";
                speechText = primaryText + ". " + secondaryText;
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic4.png";
            } else if (currentCounter == 10) {
                primaryText = "Step " + currentCounter;
                secondaryText = "Always clean up spilled fuel or oil. Keep heat, flames, sparks or lighted tobacco away from fuel and oil. Failure to use care around combustibles can cause explosion or fire.  "
                        + "After that, install the dipstick and close the rear door.";
                speechText = primaryText + ". " + secondaryText;
                primaryText = "<b>" + primaryText + "</b>";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic6.png";
            } else if (currentCounter == 11) {
                primaryText = "Congratulation!";
                secondaryText = "You have finished changing the engine oil for S630. If you want to read the service schedule to find out the correct maintenance of the Bobcat loader. Please say 'Tell me more about the service schedule'";
                speechText = primaryText + ". " + secondaryText;
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/congrat.png";
            }
        }
        if (currentCounter == 0){
            tmpTemplate = new CreateTemplateForDevice().instructionStartTemplate(title,imageURL,bgImageURL);
        }
        else if (currentCounter == 1) {
            String videoUrl = "https://bobcat-helper-project.s3.amazonaws.com/How+to+Change+Engine+Oil+on+Bobcat+Engines.mp4";
            String videoTitle =  "How to Change Engine Oil on Bobcat Engines";
            if (null != handlerInput.getRequestEnvelope().getContext().getDisplay()){
                return handlerInput.getResponseBuilder()
                        .addVideoAppLaunchDirective(videoUrl,videoTitle,"")
                        .build();
            }
            else {
                return handlerInput.getResponseBuilder()
                        .withSpeech("Alexa can't play video on this devices. Please say next to hear the instructions")
                        .withSimpleCard(title,"Alexa can't play video on this devices. Please say next to hear the instructions")
                        .withReprompt("Alexa can't play video on this devices. Please say next to hear the instructions")
                        .build();
            }
        }
        else{
            tmpTemplate = new CreateTemplateForDevice().normalTemplate(title,primaryText,secondaryText,imageURL,bgImageURL);
        }

        //Check if device support display interface
        if (null != handlerInput.getRequestEnvelope().getContext().getDisplay())
        {
            return  handlerInput.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title,speechText)
                    .addRenderTemplateDirective(tmpTemplate)
                    .withReprompt(speechText)
                    .build();
        }
        else
        {
            return handlerInput.getResponseBuilder()
                    .withSpeech(speechText)
                    .withSimpleCard(title,speechText)
                    .withReprompt(speechText)
                    .build();
        }

    }
}

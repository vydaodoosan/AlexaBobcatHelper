package com.bobcat.helper.Util;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.Template;

import com.bobcat.helper.Handlers.FallBackHandler;
import com.bobcat.helper.Model.CustomAttributes;

import java.util.Map;
import java.util.Optional;

public class InstructionGenerator {
    private Template tmpTemplate;
    private String title,primaryText,secondaryText,speechText,imageURL,bgImageURL;

    public Optional<Response> generateQuestion(HandlerInput handlerInput) {

        Map<String, Object> instructionSessionAttributes = handlerInput.getAttributesManager().getSessionAttributes();
        int currentCounter = (int) instructionSessionAttributes.get(CustomAttributes.COUNTER);
        String stageOption = (String) instructionSessionAttributes.get(CustomAttributes.STAGE);
        String machineName = (String) instructionSessionAttributes.get(CustomAttributes.MACHINENAME);


        if (stageOption.equals("oil_instruction")) {
            if (machineName.equals("630") || machineName.equals("s630") || machineName.equals("s. six thirty") || machineName.equals("s. six hundred thirty")) {
                title = "S630's Engine Oil Change Instruction";
                bgImageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";
                //Generate Question step by step
                if (currentCounter == 0) {
                    primaryText = "ENGINE LUBRICATION SYSTEM. Removing And Replacing Oil And Filter";
                    secondaryText = "For the service interval for replacing the engine oil and filter please see SERVICE SCHEDULE on Page 10-70-1.";
                    speechText = primaryText + ". " + secondaryText;
                    bgImageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/S630Modelv2.png";
                } else if (currentCounter == 1) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "Operate the engine until coolant reaches normal operating temperature and stop the engine. " +
                            "The oil drain hose is located behind a cover (Item 2) under the right rear corner of the loader (Inset). " +
                            "Please remove the cover mounting bolts (Item 1) and remove the cover (Item 2). After that you can open the rear door.";
                    speechText = primaryText + ". " + secondaryText;
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic1.png";
                } else if (currentCounter == 2) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "The oil drain hose (Item 1) storage location is on top of the fuel tank. Please remove the hose from the storage location and route through the opening (Item 2).";
                    speechText = primaryText + ". " + secondaryText;
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic2.png";
                } else if (currentCounter == 3) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "Remove the oil drain cap (Item 1). From the oil drain hose and drain the oil into a container. Recycle or dispose of used oil in an environmentally safe manner. " +
                            "After that please install and tighten the oil drain cap. ";
                    speechText = primaryText + ". " + secondaryText;
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic3.png";
                } else if (currentCounter == 4) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "Return the oil drain hose (Item 1) to the storage location on top of the fuel tank.";
                    speechText = primaryText + ". " + secondaryText;
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic2.png";
                } else if (currentCounter == 5) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "Install the cover and the cover mounting bolts and tighten all bolts";
                    speechText = primaryText + ". " + secondaryText;
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic1.png";
                } else if (currentCounter == 6) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "Remove the oil filter (Item 3) and clean the filter base. " +
                            "After that, put clean oil on the new filter gasket, install the new filter, and hand tighten. Please use genuine Bobcat filter only. " +
                            "After that, please remove the oil fill cap (Item 2), put oil into the engine, and replace the oil fill cap. Please see Capacities on Page SPEC-10-5 and do not overfill.";
                    speechText = primaryText + ". " + secondaryText;
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic4.png";
                } else if (currentCounter == 7) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "Start the engine and allow to operate for several minutes. After that, please stop the engine and check for leaks at the filter. "
                            + "Diesel fuel or hydraulic fluid under pressure can penetrate skin or eyes, causing serious injury or death. Fluid leaks under pressure may not be visible. Use a piece of cardboard or wood to find leaks. "
                            + "Do not use your bare hand. Wear safety goggles. If fluid enters skin or eyes, get immediate medical attention from a physician familiar with this injury.";
                    speechText = primaryText + ". " + secondaryText;
                    secondaryText = "<font size='2'>" + secondaryText + "</font>";
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic5.png";
                } else if (currentCounter == 8) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "Remove the dipstick (Item 1) " + "and check the oil level. " +
                            "After that, add oil as needed if oil level is not at the top mark on the dipstick.";
                    speechText = primaryText + ". " + secondaryText;
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic4.png";
                } else if (currentCounter == 9) {
                    primaryText = "Step " + (currentCounter);
                    secondaryText = "Always clean up spilled fuel or oil. Keep heat, flames, sparks or lighted tobacco away from fuel and oil. Failure to use care around combustibles can cause explosion or fire.  "
                            + "After that, install the dipstick and close the rear door.";
                    speechText = primaryText + ". " + secondaryText;
                    primaryText = "<b>" + primaryText + "</b>";
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic6.png";
                } else if (currentCounter == 10) {
                    primaryText = "Congratulation!";
                    secondaryText = "You have finished changing the engine oil for S630. If you want to read the service schedule to find out the correct maintenance of the Bobcat loader. Please say 'Tell me more about the service schedule'";
                    speechText = primaryText + ". " + secondaryText;
                    imageURL = "https://bobcat-helper-project.s3.amazonaws.com/congrat.png";
                }
            }
        }
        else if (stageOption.equals("service_schedule")) {
            title = "Maintenance Intervals";
            bgImageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";
            if (currentCounter == 0) {
                primaryText = "Maintenance work must be done at regular intervals";
                secondaryText = "Failure to do so will result in excessive wear and early failures. The service schedule is a guide for correct maintenance of the Bobcat loader.";
                speechText = primaryText + ". " + secondaryText;
                bgImageURL = "https://bobcat-helper-project.s3.amazonaws.com/DoosanBobcat.png";
                imageURL = "https://bobcat-helper-project.s3.amazonaws.com/pic8.png";
            } else if (currentCounter == 1) {
                String[] content = {"Engine Oil: Check level and add as needed.", "Engine Air Filters and Air System: Check display panel. Service only when required. Check for leaks and damaged components."
                        , "Engine Cooling System: Clean debris from hydraulic fluid cooler and radiator assembly, fuel cooler, air conditioning condenser (if equipped), and rear grille. Check coolant level COLD and add premixed coolant as needed."
                        , "Fuel Filter: Check the display panel. Remove the trapped water when required."
                        , "Lift Arms, Lift Links, Cylinders, Bob-Tach, Pivot Pins, Wedges: Lubricate with multipurpose lithium based grease.",
                        "Seat Belt, Seat Belt Retractors, Seat Bar, Control Interlocks: Check the condition of seat belt. Clean or replace seat belt retractors as needed. Check the seat bar and control interlocks for correct operation. Clean dirt and debris from moving parts."
                        , "Bobcat Interlock Control Systems (BICS): Check for correct function. Lift and Tilt functions MUST NOT operate with seat bar raised."
                        , "Front Horn / Back-up Alarm: Check for proper function."
                        , "Tires: Check for damaged tires and correct air pressure. Inflate to MAXIMUM pressure shown on the sidewall of the tire."
                        , "Operator Cab: Check the fastening bolts, washers, and nuts. Check the condition of the cab."
                        , "Indicators and Lights: Check for correct operation of all indicators and lights.", "Wheel Nuts Perform every 10 hours or daily for the first 30 hours, then as scheduled. Check for loose wheel nuts and tighten to correct torque."
                        , "Safety Signs and Safety Treads: Check for damaged signs (decals) and safety treads. Replace any signs or safety treads that are damaged or worn."
                        , "Hydraulic Fluid: Check fluid level and add as needed.", "Heater and Air Conditioning Filters (if equipped). Clean or replace filters as needed."};
                primaryText = "Every 10 Hours (Before Starting The Loader)";
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
            } else if (currentCounter == 2) {
                String[] content = {"Hydraulic Hoses and Tubelines: Check for damage and leaks. Repair or replace as needed."
                        , "Final Drive Transmission (Chaincase): Check fluid level and add as needed."
                        , "Parking Brake, Foot Pedals, Hand Controls and Steering Levers, or Joysticks: Check for correct operation. Repair or adjust as needed."
                        , "Wheel Nuts: Check for loose wheel nuts and tighten to correct torque."
                        , "Engine / Hydrostatic Drive Belt: Perform at first 50 hours, then as scheduled. Check for wear or damage. Adjust or replace as needed."
                        , "Engine Oil and Filter: Perform at first 50 hours, then as scheduled. Replace oil and filter."};
                primaryText = "Every 50 Hours";
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
            } else if (currentCounter == 3) {
                String[] content = {"Battery: Check cables and connections."
                        , "Engine Oil and Filter: Perform every 100 hours when operating under severe conditions. Replace oil and filter."};
                primaryText = "Every 100 Hours";
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
            } else if (currentCounter == 4) {
                String[] content = {"Engine / Hydrostatic Drive Belt: Check for wear or damage. Adjust or replace as needed."
                        , "Drive Belts (Alternator, air conditioning, water pump): Check condition. Replace as needed."
                        , "Bobcat Interlock Control System (BICS): Check the function of the lift arm bypass control."
                        , "Every 500 Hours or Every 12 Months, for Fuel Filter: Replace filter element."
                        , "Hydraulic Charge Filter, Hydraulic Reservoir Breather Cap: Replace the charge filter and the reservoir breather cap."
                        , "Engine Oil and Filter: Replace oil and filter."
                        , "Heater Coil and Air Conditioning Evaporator (if equipped): Clean the heater coil and air conditioning evaporator."};
                primaryText = "Every 250 Hours or Every 12 Months";
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
            } else if (currentCounter == 5) {
                String[] content = {"Hydraulic / Hydrostatic Filter: Replace the hydraulic / hydrostatic filter."
                        , "Hydraulic Reservoir: Replace the fluid."
                        , "Final Drive Transmission (Chaincase): Replace the fluid."
                        , "Engine Valves: Adjust the engine valve clearance."};
                primaryText = "Every 1000 Hours or Every 12 Months";
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
            } else if (currentCounter == 6) {
                String[] content = {"Coolant: Replace the coolant."};
                primaryText = "Every 1500 Hours or Every 24 Months";
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
            }
        }

        if (currentCounter == 0){
            tmpTemplate = new CreateTemplateForDevice().instructionStartTemplate(title,imageURL,bgImageURL);
        }
        else if (stageOption.equals("service_schedule")){
            tmpTemplate = new CreateTemplateForDevice().template1(title,primaryText,secondaryText,bgImageURL);
        }
        else{
            tmpTemplate = new CreateTemplateForDevice().normalTemplate(title,primaryText,secondaryText,imageURL,bgImageURL);
        }

        String OneMinuteWait = "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>" + "<break time='10s'/>";


        if (null != handlerInput.getRequestEnvelope().getContext().getDisplay())
        {
            return  handlerInput.getResponseBuilder()
                    .withSpeech(speechText + OneMinuteWait)
                    .withSimpleCard(title,speechText)
                    .addRenderTemplateDirective(tmpTemplate)
                    .withReprompt(speechText + OneMinuteWait)
                    .withShouldEndSession(false)
                    .build();
        }
        else
        {
            return handlerInput.getResponseBuilder()
                    .withSpeech(speechText + OneMinuteWait)
                    .withSimpleCard(title,speechText)
                    .withReprompt(speechText + OneMinuteWait)
                    .withShouldEndSession(false)
                    .build();
        }
    }
}

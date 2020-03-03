package com.bobcat.helper;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.bobcat.helper.Handlers.*;

public class BobcatHelperStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new OilChangeRequestHandler(),
                        new NextIntentHandler(),
                        new PreviousIntentHandler(),
                        new FallBackHandler(),
                        new CancelIntentHandler(),
                        new ServiceScheduleHandler(),
                        new StopIntentHandler(),
                        new VideoPlayingIntentHandler(),
                        new FluidCapacitiesHandler(),
                        new HelpIntentHandler()
                )
                .withSkillId("amzn1.ask.skill.5c72b21c-31e2-489c-acf7-cd1bccfa7f14")
                .build();
    }

    public BobcatHelperStreamHandler(){
        super(getSkill());
    }
}

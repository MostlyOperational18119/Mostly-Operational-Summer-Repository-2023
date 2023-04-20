package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    enum autos {
        BBHIGH,
        BRHIGH,
        RBHIGH,
        RRHIGH,
        TESTING,
        SMOLTESTING
    };
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        MeepMeep meepMeep = new MeepMeep(800);

        autos auto = autos.SMOLTESTING;
        RoadRunnerBotEntity myBot;
        switch(auto) {
            case TESTING:
                myBot = new DefaultBotBuilder(meepMeep)
                        // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                        .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                        .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(0, 0, 0))
                                        .forward(30)
                                        .turn(Math.toRadians(90))
                                        .forward(30)
                                        .turn(Math.toRadians(90))
                                        .forward(30)
                                        .turn(Math.toRadians(90))
                                        .forward(30)
                                        .turn(Math.toRadians(90))
                                        .build()
                        );
                break;
            default:
                myBot = new DefaultBotBuilder(meepMeep)
                        .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                        .followTrajectorySequence(drive ->
                                    drive.trajectorySequenceBuilder(new Pose2d(0, 0, 0))
                                            .strafeRight(10)
                                            .forward(5)
                                            .build()
                        );
                break;

        }
        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
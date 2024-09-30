package com.example.meepmeeptesting

import com.acmerobotics.roadrunner.Pose2d
import com.acmerobotics.roadrunner.Rotation2d
import com.acmerobotics.roadrunner.Vector2d
import com.noahbres.meepmeep.MeepMeep
import com.noahbres.meepmeep.MeepMeep.Background
import com.noahbres.meepmeep.MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK
import com.noahbres.meepmeep.core.colorscheme.ColorScheme
import com.noahbres.meepmeep.core.toRadians
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder
import com.noahbres.meepmeep.roadrunner.DriveTrainType
import com.noahbres.meepmeep.roadrunner.DriveTrainType.MECANUM

fun main(args: Array<String>) {
    val meepMeep = MeepMeep(800)

    val myBot =
        DefaultBotBuilder(meepMeep) // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
            .setConstraints(60.0, 60.0, 180.0.toRadians(), 180.0.toRadians(), 18.0)
            .setDimensions(18.0,18.0)
            .setDriveTrainType(MECANUM)
            .setStartPose(Pose2d(Vector2d((0.0-70.0+9.0+24.0),(0.0-70.0+9.0)), Rotation2d(0.0,0.0)))
            
            .build()




    meepMeep.setBackground(FIELD_INTO_THE_DEEP_JUICE_DARK)
        .setDarkMode(true)
        .setBackgroundAlpha(0.95f)
        .addEntity(myBot)
        .start()
}
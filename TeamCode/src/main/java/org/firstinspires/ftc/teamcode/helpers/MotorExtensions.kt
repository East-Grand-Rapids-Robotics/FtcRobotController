package org.firstinspires.ftc.teamcode.helpers

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorControllerEx
import com.qualcomm.robotcore.hardware.DcMotorEx
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.RADIANS
import org.firstinspires.ftc.teamcode.kinematics.AngularVelocity
import org.firstinspires.ftc.teamcode.kinematics.Measure.Angle.Degrees
import org.firstinspires.ftc.teamcode.kinematics.Measure.Angle.Radians

/**
 * defines the angular velocity of a DcMotorEx in AngleUnits per second.
 * Maximal spindle velocity is 200π Radians per second or 36,000 degrees per second
 */
inline var DcMotorEx.angularVelocity: AngularVelocity
    get() {
        val radiansPerSecond = this.getVelocity(RADIANS)
        return AngularVelocity(Radians(radiansPerSecond))
    }
    set(value) {
        val anglePerSecond = value.angle / (value.duration.inWholeMilliseconds / 1_000.0)
        val radiansPerSecond: Radians = anglePerSecond.radians

        this.setVelocity(radiansPerSecond.value, RADIANS)
    }

inline val DcMotor.controllerEx: DcMotorControllerEx
    get() {
        return this.controller as DcMotorControllerEx
    }
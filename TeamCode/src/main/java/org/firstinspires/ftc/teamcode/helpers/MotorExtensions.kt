package org.firstinspires.ftc.teamcode.helpers

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import org.firstinspires.ftc.teamcode.kinematics.AngularVelocity
import org.firstinspires.ftc.teamcode.kinematics.Rate

/**
 * defines the angular velocity of a DcMotorEx in AngleUnits per second.
 * Maximal spindle velocity is 200π Radians per second or 36,000 degrees per second
 */
var DcMotorEx.angularVelocity: AngularVelocity
    get() {
        return AngularVelocity(Rate(this.velocity))
    }
    set(value) {
        this.setVelocity(value.rate.value, value.unit)
    }
package org.firstinspires.ftc.teamcode.helpers

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotor.RunMode.STOP_AND_RESET_ENCODER
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE


typealias LeftFrontMotor = DcMotor
typealias RightFrontMotor = DcMotor
typealias LeftBackMotor = DcMotor
typealias RightBackMotor = DcMotor

typealias MotorPower = Double

class OmniDrive(
    val leftFrontMotor: LeftFrontMotor,
    val rightFrontMotor: RightFrontMotor,
    val leftBackMotor: LeftBackMotor,
    val rightBackMotor: RightBackMotor,
) {
    init {
        leftFrontMotor.direction = REVERSE
        leftBackMotor.direction = REVERSE
        rightFrontMotor.direction = FORWARD
        rightBackMotor.direction = FORWARD
    }

    var motionVector = MotionVector(0f, 0f, 0f)
        set(value) {
            field = value
            drivePower(field)
        }

    fun stop() {
        motionVector = MotionVector(0f, 0f, 0f)
    }

    fun zeroEncoders() {
        leftFrontMotor.mode = STOP_AND_RESET_ENCODER
        rightFrontMotor.mode = STOP_AND_RESET_ENCODER
        leftBackMotor.mode = STOP_AND_RESET_ENCODER
        leftBackMotor.mode = STOP_AND_RESET_ENCODER
    }

    private fun drivePower(motionVector: MotionVector) {
        leftFrontMotor.power = motionVector.leftFrontPower()
        rightFrontMotor.power = motionVector.rightFrontPower()
        leftBackMotor.power = motionVector.leftBackPower()
        rightBackMotor.power = motionVector.rightBackPower()
    }
}



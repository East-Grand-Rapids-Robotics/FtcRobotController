package org.firstinspires.ftc.teamcode.helpers

import com.qualcomm.robotcore.hardware.DcMotor.RunMode.STOP_AND_RESET_ENCODER
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.teamcode.kinematics.VelocityVector


typealias LeftFrontMotor = DcMotorEx
typealias RightFrontMotor = DcMotorEx
typealias LeftBackMotor = DcMotorEx
typealias RightBackMotor = DcMotorEx

typealias MotorPower = Double

class OmniDrive(
    val leftFrontMotor: LeftFrontMotor,
    val rightFrontMotor: RightFrontMotor,
    val leftBackMotor: LeftBackMotor,
    val rightBackMotor: RightBackMotor,
    val telemetry: Telemetry? = null
) {
    init {
        leftFrontMotor.direction = REVERSE
        leftBackMotor.direction = REVERSE
        rightFrontMotor.direction = FORWARD
        rightBackMotor.direction = FORWARD
    }

    var powerVector = PowerVector(0.0, 0.0, 0.0)
        set(value) {
            field = value
            drivePower(field)
        }

    fun stop() {
        powerVector = PowerVector(0.0, 0.0, 0.0)
    }

    fun zeroEncoders() {
        leftFrontMotor.mode = STOP_AND_RESET_ENCODER
        rightFrontMotor.mode = STOP_AND_RESET_ENCODER
        leftBackMotor.mode = STOP_AND_RESET_ENCODER
        leftBackMotor.mode = STOP_AND_RESET_ENCODER
    }

    private fun drivePower(motionVector: PowerVector) {
        telemetry?.addData("OmniDrive left front: ", motionVector.leftFrontPower())
        telemetry?.addData("OmniDrive right front: ", motionVector.rightFrontPower())
        telemetry?.addData("OmniDrive left back: ", motionVector.leftBackPower())
        telemetry?.addData("OmniDrive right back: ", motionVector.rightBackPower())

        leftFrontMotor.power = motionVector.leftFrontPower()
        rightFrontMotor.power = motionVector.rightFrontPower()
        leftBackMotor.power = motionVector.leftBackPower()
        rightBackMotor.power = motionVector.rightBackPower()
    }

    private fun driveVelocity(vector: VelocityVector) {
        leftFrontMotor.angularVelocity =
        TODO("fill in axel velocity logic")
    }
}



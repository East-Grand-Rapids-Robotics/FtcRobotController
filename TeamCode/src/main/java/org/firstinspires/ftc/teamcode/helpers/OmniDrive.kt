package org.firstinspires.ftc.teamcode.helpers

import androidx.lifecycle.viewmodel.viewModelFactory
import com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_USING_ENCODER
import com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_WITHOUT_ENCODER
import com.qualcomm.robotcore.hardware.DcMotor.RunMode.STOP_AND_RESET_ENCODER
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE
import org.firstinspires.ftc.robotcore.external.Telemetry
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import kotlin.math.PI


typealias LeftFrontMotor = DcMotorEx
typealias RightFrontMotor = DcMotorEx
typealias LeftBackMotor = DcMotorEx
typealias RightBackMotor = DcMotorEx

typealias MotorPower = Double

class OmniDrive(
    private val leftFrontMotor: LeftFrontMotor,
    private val rightFrontMotor: RightFrontMotor,
    private val leftBackMotor: LeftBackMotor,
    private val rightBackMotor: RightBackMotor,
) {
    var powerVector = PowerVector(0.0, 0.0, 0.0)
        set(value) {
            field = value
            drivePower(field)
        }

    var telemetry: Telemetry? = null
    var zeroPowerBehavior: ZeroPowerBehavior = BRAKE
        set(value) {
            leftFrontMotor.zeroPowerBehavior = value
            rightFrontMotor.zeroPowerBehavior = value
            leftBackMotor.zeroPowerBehavior = value
            rightBackMotor.zeroPowerBehavior = value
            field = value
        }


    init {
        leftFrontMotor.direction = REVERSE
        leftBackMotor.direction = FORWARD
        rightFrontMotor.direction = REVERSE
        rightBackMotor.direction = REVERSE
        leftFrontMotor.zeroPowerBehavior = BRAKE
        rightFrontMotor.zeroPowerBehavior = BRAKE
        leftBackMotor.zeroPowerBehavior = BRAKE
        rightBackMotor.zeroPowerBehavior = BRAKE
        leftFrontMotor.mode = RUN_USING_ENCODER
        rightFrontMotor.mode = RUN_USING_ENCODER
        leftBackMotor.mode = RUN_USING_ENCODER
        rightBackMotor.mode = RUN_USING_ENCODER

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

    private fun drivePower(vector: PowerVector) {
        val lfvel = vector.leftFrontPower().toDouble() * 100
        val rfvel = vector.rightFrontPower().toDouble() * 100
        val lbvel = vector.leftBackPower().toDouble() * 100
        val rbvel = vector.rightBackPower().toDouble() * 100
        telemetry?.addData("OmniDrive left front: ", lfvel)
        telemetry?.addData("OmniDrive right front: ", rfvel)
        telemetry?.addData("OmniDrive left back: ", lbvel)
        telemetry?.addData("OmniDrive right back: ", rbvel)

        leftFrontMotor.setVelocity(lfvel * PI, AngleUnit.RADIANS)
        rightFrontMotor.setVelocity(rfvel * PI, AngleUnit.RADIANS)
        leftBackMotor.setVelocity(lbvel * PI, AngleUnit.RADIANS)
        rightBackMotor.setVelocity(rbvel * PI, AngleUnit.RADIANS)
    }

//    private fun driveVelocity(vector: PVjVector) {
//        leftFrontMotor.angularVelocity =
//        TODO("fill in axel velocity logic")
//    }

//    fun robotToWheelVelocities(
//        velocity: VelocityVector,
//        trackWidth: Double,
//        wheelBase: Double = trackWidth,
//        lateralMultiplier: Double = 1.0
//    ): List<Double> {
//        val k = (trackWidth + wheelBase) / 2.0
//        return listOf(
//            robotVel.x - lateralMultiplier * robotVel.y - k * robotVel.heading,
//            robotVel.x + lateralMultiplier * robotVel.y - k * robotVel.heading,
//            robotVel.x - lateralMultiplier * robotVel.y + k * robotVel.heading,
//            robotVel.x + lateralMultiplier * robotVel.y + k * robotVel.heading
//        )
//    }


}



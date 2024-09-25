package org.firstinspires.ftc.teamcode.intothedeep

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.helpers.MotionVector
import org.firstinspires.ftc.teamcode.helpers.omniDrive

@TeleOp(name = "Kotlin TeleOp Test", group = "")
class EgrTeleOp : OpMode() {
    /* This TeleOp is designed to be used with the `sally` configuration.
     *
     *
     */

    val omniDrive by lazy { this.hardwareMap.omniDrive() }

    override fun init() {
        omniDrive.zeroEncoders()

    }

    override fun loop() {
        omniDrive.motionVector = MotionVector(
            axialVelocity = -this.gamepad1.left_stick_y,
            lateralVelocity = this.gamepad1.left_stick_x,
            yawVelocity = this.gamepad1.right_stick_x
        )
    }
}
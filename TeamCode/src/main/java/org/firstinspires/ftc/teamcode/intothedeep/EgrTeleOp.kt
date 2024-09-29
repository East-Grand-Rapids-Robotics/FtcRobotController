package org.firstinspires.ftc.teamcode.intothedeep

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.teamcode.helpers.PowerVector
import org.firstinspires.ftc.teamcode.helpers.omniDrive
import kotlin.math.roundToLong

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
        omniDrive.powerVector = PowerVector(
            -this.gamepad1.left_stick_y.toDouble(),
            this.gamepad1.left_stick_x.toDouble(),
            this.gamepad1.right_stick_x.toDouble()
        )
    }
}
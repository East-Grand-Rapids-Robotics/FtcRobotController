package org.firstinspires.ftc.teamcode.intothedeep

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import org.firstinspires.ftc.teamcode.helpers.MotionVector
import org.firstinspires.ftc.teamcode.helpers.aprilTagProcessor
import org.firstinspires.ftc.teamcode.helpers.exposure
import org.firstinspires.ftc.teamcode.helpers.gain
import org.firstinspires.ftc.teamcode.helpers.omniDrive
import org.firstinspires.ftc.teamcode.helpers.visionPortal
import org.firstinspires.ftc.teamcode.helpers.webcam

@Autonomous(preselectTeleOp = "true", name = "Into the Deep Auto")
class Autonomous : OpMode() {
    val omniDrive by lazy { hardwareMap.omniDrive() }
    val vision by lazy { visionPortal(hardwareMap.webcam()) }

    override fun init() {
        omniDrive.zeroEncoders()
        vision.resumeStreaming()
        vision.exposure = 6
        vision.gain = 250
    }

    override fun loop() {
        for (detection in vision.aprilTagProcessor.detections) {
            telemetry.addData(
                "tag detected",
                "Tag: %d [%s]\nDistance: %5.1f\nBearing: %3.0f°\nYaw: %3.0f degrees",
                detection.id,
                detection.metadata.name,
                detection.ftcPose.range,
                detection.ftcPose.bearing,
                detection.ftcPose.yaw
            )
        }
    }
}

private fun Autonomous.visionProcessor() {
    TODO("Not yet implemented")
}

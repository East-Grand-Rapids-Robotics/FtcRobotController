package org.firstinspires.ftc.teamcode.intothedeep

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import org.firstinspires.ftc.teamcode.helpers.cameraMonitorViewId
import org.firstinspires.ftc.teamcode.helpers.omniDrive
import org.firstinspires.ftc.teamcode.helpers.vision.VisionPipeline
import org.firstinspires.ftc.teamcode.helpers.vision.aprilTagProcessor
import org.firstinspires.ftc.teamcode.helpers.vision.exposure
import org.firstinspires.ftc.teamcode.helpers.vision.gain
import org.firstinspires.ftc.teamcode.helpers.vision.openCvCamera
import org.firstinspires.ftc.teamcode.helpers.vision.visionPortal
import org.firstinspires.ftc.teamcode.helpers.webcam


@Autonomous(preselectTeleOp = "true", name = "Into the Deep Auto")
class Autonomous : OpMode() {
    val omniDrive by lazy { hardwareMap.omniDrive() }
    val vision by lazy { visionPortal(hardwareMap.webcam()) }
    val camera by lazy { openCvCamera(hardwareMap.webcam(), hardwareMap.cameraMonitorViewId()) }

    override fun init() {
        omniDrive.zeroEncoders()
        vision.resumeStreaming()
        vision.exposure = 6
        vision.gain = 250

        val pipeline = VisionPipeline()
        camera.setPipeline(pipeline)
    }

    override fun start() {
        vision.stopStreaming()
    }

    override fun loop() {
        vision.aprilTagProcessor.detections.forEach { detection ->
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


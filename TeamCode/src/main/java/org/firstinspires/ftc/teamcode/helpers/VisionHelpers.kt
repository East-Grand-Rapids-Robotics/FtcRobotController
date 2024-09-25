package org.firstinspires.ftc.teamcode.helpers

import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.ExposureControl
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.GainControl
import org.firstinspires.ftc.vision.VisionPortal
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor
import java.util.concurrent.TimeUnit.MILLISECONDS


typealias Exposure = Long
typealias Gain = Int

private val aprilTagProcessor = aprilProcessor()

fun aprilProcessor(): AprilTagProcessor = aprilTagProcessor
fun visionPortal(camera: CameraName): VisionPortal =
    VisionPortal.Builder().setCamera(camera).addProcessor(aprilProcessor()).build()
val VisionPortal.aprilTagProcessor: AprilTagProcessor
    get() = this.aprilTagProcessor

val VisionPortal.exposureControl: ExposureControl
    get() = this.getCameraControl<ExposureControl>(ExposureControl::class.java)
val VisionPortal.gainControl: GainControl
    get() = this.getCameraControl<GainControl>(GainControl::class.java)

var VisionPortal.exposure: Exposure
    get() = this.exposureControl.getExposure(MILLISECONDS)
    set(value) {
        this.exposureControl.setExposure(value, MILLISECONDS)
    }

var VisionPortal.gain: Gain
    get() = this.gainControl.gain
    set(value) {
        this.gainControl.gain = value
    }

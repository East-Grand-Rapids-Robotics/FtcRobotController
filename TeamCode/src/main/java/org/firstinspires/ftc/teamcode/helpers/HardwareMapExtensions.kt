package org.firstinspires.ftc.teamcode.helpers

import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName
import org.firstinspires.ftc.teamcode.helpers.vision.ViewId

fun HardwareMap.getMotor(name: String): DcMotorEx = this.get(DcMotorEx::class.java, name)
fun HardwareMap.getServo(name: String): Servo = this.get(Servo::class.java, name)
fun HardwareMap.leftFrontMotor(): LeftFrontMotor = this.getMotor("left_front_motor")
fun HardwareMap.rightFrontMotor(): RightFrontMotor = this.getMotor("right_front_motor")
fun HardwareMap.leftBackMotor(): LeftBackMotor = this.getMotor("left_back_motor")
fun HardwareMap.rightBackMotor(): RightBackMotor = this.getMotor("right_back_motor")
fun HardwareMap.omniDrive(): OmniDrive = OmniDrive(
    this.leftFrontMotor(),
    this.rightFrontMotor(),
    this.leftBackMotor(),
    this.rightBackMotor()
)
fun HardwareMap.webcam(): WebcamName = this.get(WebcamName::class.java, "webcam_1")
fun HardwareMap.cameraMonitorViewId(): ViewId = this.appContext.resources.getIdentifier("cameraMonitorViewId", "id", this.appContext.packageName)
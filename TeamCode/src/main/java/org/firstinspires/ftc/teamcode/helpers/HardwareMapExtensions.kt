package org.firstinspires.ftc.teamcode.helpers

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.HardwareMap

fun HardwareMap.getMotor(name: String): DcMotor = this.get(DcMotor::class.java, name)
fun HardwareMap.leftFrontMotor(): LeftFrontMotor = this.getMotor("left_front")
fun HardwareMap.rightFrontMotor(): RightFrontMotor = this.getMotor("right_front")
fun HardwareMap.leftBackMotor(): LeftBackMotor = this.getMotor("left_back")
fun HardwareMap.rightBackMotor(): RightBackMotor = this.getMotor("right_back")
fun HardwareMap.omniDrive(): OmniDrive = OmniDrive(
    this.leftFrontMotor(),
    this.rightFrontMotor(),
    this.leftBackMotor(),
    this.rightBackMotor()
)

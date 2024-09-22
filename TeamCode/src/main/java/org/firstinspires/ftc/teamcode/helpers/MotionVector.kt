package org.firstinspires.ftc.teamcode.helpers

typealias AxialVelocity = Float
typealias LateralVelocity = Float
typealias YawVelocity = Float

data class MotionVector(
    val axialVelocity: AxialVelocity,
    val lateralVelocity: LateralVelocity,
    val yawVelocity: YawVelocity,
) {
    init {
        require(axialVelocity <= 1f) { "Axial Velocity cannot exceed 1.0" }
        require(axialVelocity >= -1f) { "Axial Velocity cannot be less than -1.0" }
        require(lateralVelocity <= 1f) { "Lateral Velocity cannot exceed 1.0" }
        require(lateralVelocity >= -1f) { "Lateral Velocity cannot be less than -1.0" }
        require(yawVelocity <= 1f) { "Yaw Velocity cannot exceed 1.0" }
        require(yawVelocity >= -1f) { "Yaw Velocity cannot be less than -1.0" }
    }

    fun leftFrontPower(): MotorPower = (axial() + lateral() + yaw()) / 3.0
    fun rightFrontPower(): MotorPower = (axial() - lateral() - yaw()) / 3.0
    fun leftBackPower(): MotorPower = (axial() - lateral() + yaw()) / 3.0
    fun rightBackPower(): MotorPower = (axial() + lateral() - yaw()) / 3.0

    fun axial(): AxialVelocity = axialVelocity
    fun lateral(): LateralVelocity = lateralVelocity
    fun yaw(): YawVelocity = yawVelocity
}

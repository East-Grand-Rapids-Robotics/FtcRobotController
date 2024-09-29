package org.firstinspires.ftc.teamcode.helpers

data class PowerVector(
    val axial: MotorPower,
    val lateral: MotorPower,
    val yaw: MotorPower,
) {
    init {
        require(axial <= 1f) { "Axial Power cannot exceed 1.0" }
        require(axial >= -1f) { "Axial Power cannot be less than -1.0" }
        require(lateral <= 1f) { "Lateral Power cannot exceed 1.0" }
        require(lateral >= -1f) { "Lateral Power cannot be less than -1.0" }
        require(yaw <= 1f) { "Yaw Power cannot exceed 1.0" }
        require(yaw >= -1f) { "Yaw Power cannot be less than -1.0" }
    }

    fun leftFrontPower(): MotorPower = (axial + lateral + yaw) / 3.0
    fun rightFrontPower(): MotorPower = (axial - lateral - yaw) / 3.0
    fun leftBackPower(): MotorPower = (axial - lateral + yaw) / 3.0
    fun rightBackPower(): MotorPower = (axial + lateral - yaw) / 3.0
}

package org.firstinspires.ftc.teamcode.kinematics

typealias Yaw = Radians

data class VelocityVector(
    val axial: AxialVelocity,
    val lateral: LateralVelocity,
    val yaw: YawVelocity,
)

data class AccelerationVector(
    val axial: AxialAcceleration,
    val lateral: LateralAcceleration,
    val yaw: Yaw,
)




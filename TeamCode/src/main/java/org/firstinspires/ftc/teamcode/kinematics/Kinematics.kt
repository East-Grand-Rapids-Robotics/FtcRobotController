//package org.firstinspires.ftc.teamcode.kinematics
//
//import com.acmerobotics.roadrunner.geometry.Pose2d
//
//
//data class VelocityVector(
//    val axial: Velocity,
//    val lateral: Velocity,
//    val yaw: Velocity,
//)
//
//data class AccelerationVector(
//    val axial: AxialAcceleration,
//    val lateral: LateralAcceleration,
//    val yaw: Angle,
//)
//
//fun robotToWheelVelocities(
//    velocity: VelocityVector,
//    trackWidth: Double,
//    wheelBase: Double = trackWidth,
//    lateralMultiplier: Double = 1.0
//): List<Double> {
//    val k = (trackWidth + wheelBase) / 2.0
//    return listOf(
//        robotVel.x - lateralMultiplier * robotVel.y - k * robotVel.heading,
//        robotVel.x + lateralMultiplier * robotVel.y - k * robotVel.heading,
//        robotVel.x - lateralMultiplier * robotVel.y + k * robotVel.heading,
//        robotVel.x + lateralMultiplier * robotVel.y + k * robotVel.heading
//    )
//}
//

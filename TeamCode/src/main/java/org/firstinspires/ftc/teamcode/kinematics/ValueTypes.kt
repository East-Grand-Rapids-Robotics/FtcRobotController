package org.firstinspires.ftc.teamcode.kinematics

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import kotlin.math.PI

const val π = PI

interface Arithmetic<T> : Comparable<T> {
    operator fun plus(other: T): T
    operator fun minus(other: T): T
    operator fun unaryMinus(): T
    operator fun unaryPlus(): T
    fun toFloat(): Float
    fun toDouble(): Double
}

interface Scalable<T> {
    operator fun times(scalar: Int): T
    operator fun times(scalar: Short): T
    operator fun times(scalar: Long): T
    operator fun times(scalar: Float): T
    operator fun times(scalar: Double): T
    operator fun div(scalar: Int): T
    operator fun div(scalar: Short): T
    operator fun div(scalar: Long): T
    operator fun div(scalar: Float): T
    operator fun div(scalar: Double): T
}

interface Convertible<S, T> {
    fun into(): T
}

@JvmInline
value class Radians(val value: Double) : Arithmetic<Radians>, Scalable<Radians>,
    Convertible<Radians, Degrees> {
    override fun plus(other: Radians): Radians {
        return Radians(value + other.value)
    }

    override fun minus(other: Radians): Radians {
        return Radians(value - other.value)
    }

    override fun unaryMinus(): Radians {
        return Radians(-value)
    }

    override fun unaryPlus(): Radians {
        return Radians(+value)
    }

    override fun toFloat(): Float {
        return value.toFloat()
    }

    override fun toDouble(): Double {
        return value
    }

    override fun into(): Degrees {
        return Degrees(value * 180.0 / π)
    }

    override fun compareTo(other: Radians): Int {
        return value.compareTo(other.value)
    }

    override fun times(scalar: Int): Radians {
        return Radians(value * scalar)
    }

    override fun times(scalar: Short): Radians {
        return Radians(value * scalar)
    }

    override fun times(scalar: Long): Radians {
        return Radians(value * scalar)
    }

    override fun times(scalar: Float): Radians {
        return Radians(value * scalar)
    }

    override fun times(scalar: Double): Radians {
        return Radians(value * scalar)
    }

    override fun div(scalar: Int): Radians {
        return Radians(value / scalar)
    }

    override fun div(scalar: Short): Radians {
        return Radians(value / scalar)
    }

    override fun div(scalar: Long): Radians {
        return Radians(value / scalar)
    }

    override fun div(scalar: Float): Radians {
        return Radians(value / scalar)
    }

    override fun div(scalar: Double): Radians {
        return Radians(value / scalar)
    }

}

@JvmInline
value class Degrees(val value: Double) : Arithmetic<Degrees>, Scalable<Degrees>,
    Convertible<Degrees, Radians> {
    override fun plus(other: Degrees): Degrees {
        return Degrees(value + other.value)
    }

    override fun minus(other: Degrees): Degrees {
        return Degrees(value - other.value)
    }

    override fun unaryMinus(): Degrees {
        return Degrees(-value)
    }

    override fun unaryPlus(): Degrees {
        return Degrees(+value)
    }

    override fun toFloat(): Float {
        return value.toFloat()
    }

    override fun toDouble(): Double {
        return value
    }

    override fun into(): Radians {
        return Radians(value * π / 180.0)
    }

    override fun compareTo(other: Degrees): Int {
        return value.compareTo(other.value)
    }

    override fun times(scalar: Int): Degrees {
        return Degrees(value * scalar)
    }

    override fun times(scalar: Short): Degrees {
        return Degrees(value * scalar)
    }

    override fun times(scalar: Long): Degrees {
        return Degrees(value * scalar)
    }

    override fun times(scalar: Float): Degrees {
        return Degrees(value * scalar)
    }

    override fun times(scalar: Double): Degrees {
        return Degrees(value * scalar)
    }

    override fun div(scalar: Int): Degrees {
        return Degrees(value / scalar)
    }

    override fun div(scalar: Short): Degrees {
        return Degrees(value / scalar)
    }

    override fun div(scalar: Long): Degrees {
        return Degrees(value / scalar)
    }

    override fun div(scalar: Float): Degrees {
        return Degrees(value / scalar)
    }

    override fun div(scalar: Double): Degrees {
        return Degrees(value / scalar)
    }
}

@JvmInline
value class AxialVelocity(val value: Double) : Arithmetic<AxialVelocity>, Scalable<AxialVelocity> {
    override fun plus(other: AxialVelocity): AxialVelocity {
        return AxialVelocity(value + other.value)
    }

    override fun minus(other: AxialVelocity): AxialVelocity {
        return AxialVelocity(value - other.value)
    }

    override fun unaryMinus(): AxialVelocity {
        return AxialVelocity(-value)
    }

    override fun unaryPlus(): AxialVelocity {
        return AxialVelocity(+value)
    }

    override fun toFloat(): Float {
        return value.toFloat()
    }

    override fun toDouble(): Double {
        return this.value
    }

    override fun compareTo(other: AxialVelocity): Int {
        return value.compareTo(other.value)
    }

    override fun times(scalar: Int): AxialVelocity {
        return AxialVelocity(value * scalar)
    }

    override fun times(scalar: Short): AxialVelocity {
        return AxialVelocity(value * scalar)
    }

    override fun times(scalar: Long): AxialVelocity {
        return AxialVelocity(value * scalar)
    }

    override fun times(scalar: Float): AxialVelocity {
        return AxialVelocity(value * scalar)
    }

    override fun times(scalar: Double): AxialVelocity {
        return AxialVelocity(value * scalar)
    }

    override fun div(scalar: Int): AxialVelocity {
        return AxialVelocity(value / scalar)
    }

    override fun div(scalar: Short): AxialVelocity {
        return AxialVelocity(value / scalar)
    }

    override fun div(scalar: Long): AxialVelocity {
        return AxialVelocity(value / scalar)
    }

    override fun div(scalar: Float): AxialVelocity {
        return AxialVelocity(value / scalar)
    }

    override fun div(scalar: Double): AxialVelocity {
        return AxialVelocity(value / scalar)
    }
}

@JvmInline
value class LateralVelocity(val value: Double) : Arithmetic<LateralVelocity>,
    Scalable<LateralVelocity> {
    override fun plus(other: LateralVelocity): LateralVelocity {
        return LateralVelocity(value + other.value)
    }

    override fun minus(other: LateralVelocity): LateralVelocity {
        return LateralVelocity(value - other.value)
    }

    override fun unaryMinus(): LateralVelocity {
        return LateralVelocity(-value)
    }

    override fun unaryPlus(): LateralVelocity {
        return LateralVelocity(+value)
    }

    override fun toFloat(): Float {
        return value.toFloat()
    }

    override fun toDouble(): Double {
        return value
    }

    override fun compareTo(other: LateralVelocity): Int {
        return value.compareTo(other.value)
    }

    override fun times(scalar: Int): LateralVelocity {
        return LateralVelocity(value + scalar)
    }

    override fun times(scalar: Short): LateralVelocity {
        return LateralVelocity(value + scalar)
    }

    override fun times(scalar: Long): LateralVelocity {
        return LateralVelocity(value + scalar)
    }

    override fun times(scalar: Float): LateralVelocity {
        return LateralVelocity(value + scalar)
    }

    override fun times(scalar: Double): LateralVelocity {
        return LateralVelocity(value + scalar)
    }

    override fun div(scalar: Int): LateralVelocity {
        return LateralVelocity(value / scalar)
    }

    override fun div(scalar: Short): LateralVelocity {
        return LateralVelocity(value / scalar)
    }

    override fun div(scalar: Long): LateralVelocity {
        return LateralVelocity(value / scalar)
    }

    override fun div(scalar: Float): LateralVelocity {
        return LateralVelocity(value / scalar)
    }

    override fun div(scalar: Double): LateralVelocity {
        return LateralVelocity(value / scalar)
    }
}

@JvmInline
value class YawVelocity(val value: Double) : Arithmetic<YawVelocity>, Scalable<YawVelocity> {
    override fun plus(other: YawVelocity): YawVelocity {
        return YawVelocity(value + other.value)
    }

    override fun minus(other: YawVelocity): YawVelocity {
        return YawVelocity(value - other.value)
    }

    override fun unaryMinus(): YawVelocity {
        return YawVelocity(-value)
    }

    override fun unaryPlus(): YawVelocity {
        return YawVelocity(+value)
    }

    override fun toFloat(): Float {
        return value.toFloat()
    }

    override fun toDouble(): Double {
        return value
    }

    override fun compareTo(other: YawVelocity): Int {
        return value.compareTo(other.value)
    }

    override fun times(scalar: Int): YawVelocity {
        return YawVelocity(value * scalar)
    }

    override fun times(scalar: Short): YawVelocity {
        return YawVelocity(value * scalar)
    }

    override fun times(scalar: Long): YawVelocity {
        return YawVelocity(value * scalar)
    }

    override fun times(scalar: Float): YawVelocity {
        return YawVelocity(value * scalar)
    }

    override fun times(scalar: Double): YawVelocity {
        return YawVelocity(value * scalar)
    }

    override fun div(scalar: Int): YawVelocity {
        return YawVelocity(value / scalar)
    }

    override fun div(scalar: Short): YawVelocity {
        return YawVelocity(value / scalar)
    }

    override fun div(scalar: Long): YawVelocity {
        return YawVelocity(value / scalar)
    }

    override fun div(scalar: Float): YawVelocity {
        return YawVelocity(value / scalar)
    }

    override fun div(scalar: Double): YawVelocity {
        return YawVelocity(value / scalar)
    }
}

@JvmInline
value class AxialAcceleration(val value: Double) : Arithmetic<AxialAcceleration>,
    Scalable<AxialAcceleration> {
    override fun plus(other: AxialAcceleration): AxialAcceleration {
        return AxialAcceleration(value + other.value)
    }

    override fun minus(other: AxialAcceleration): AxialAcceleration {
        return AxialAcceleration(value - other.value)
    }

    override fun unaryMinus(): AxialAcceleration {
        return AxialAcceleration(-value)
    }

    override fun unaryPlus(): AxialAcceleration {
        return AxialAcceleration(+value)
    }

    override fun toFloat(): Float {
        return value.toFloat()
    }

    override fun toDouble(): Double {
        return value
    }

    override fun compareTo(other: AxialAcceleration): Int {
        return value.compareTo(other.value)
    }

    override fun times(scalar: Int): AxialAcceleration {
        return AxialAcceleration(value * scalar)
    }

    override fun times(scalar: Short): AxialAcceleration {
        return AxialAcceleration(value * scalar)
    }

    override fun times(scalar: Long): AxialAcceleration {
        return AxialAcceleration(value * scalar)
    }

    override fun times(scalar: Float): AxialAcceleration {
        return AxialAcceleration(value * scalar)
    }

    override fun times(scalar: Double): AxialAcceleration {
        return AxialAcceleration(value * scalar)
    }

    override fun div(scalar: Int): AxialAcceleration {
        return AxialAcceleration(value / scalar)
    }

    override fun div(scalar: Short): AxialAcceleration {
        return AxialAcceleration(value / scalar)
    }

    override fun div(scalar: Long): AxialAcceleration {
        return AxialAcceleration(value / scalar)
    }

    override fun div(scalar: Float): AxialAcceleration {
        return AxialAcceleration(value / scalar)
    }

    override fun div(scalar: Double): AxialAcceleration {
        return AxialAcceleration(value / scalar)
    }
}

@JvmInline
value class LateralAcceleration(val value: Double) : Arithmetic<LateralAcceleration>,
    Scalable<LateralAcceleration> {
    override fun plus(other: LateralAcceleration): LateralAcceleration {
        return LateralAcceleration(value + other.value)
    }

    override fun minus(other: LateralAcceleration): LateralAcceleration {
        return LateralAcceleration(value - other.value)
    }

    override fun unaryMinus(): LateralAcceleration {
        return LateralAcceleration(-value)
    }

    override fun unaryPlus(): LateralAcceleration {
        return LateralAcceleration(+value)
    }

    override fun toFloat(): Float {
        return value.toFloat()
    }

    override fun toDouble(): Double {
        return value
    }

    override fun compareTo(other: LateralAcceleration): Int {
        return value.compareTo(other.value)
    }

    override fun times(scalar: Int): LateralAcceleration {
        return LateralAcceleration(value * scalar)
    }

    override fun times(scalar: Short): LateralAcceleration {
        return LateralAcceleration(value * scalar)
    }

    override fun times(scalar: Long): LateralAcceleration {
        return LateralAcceleration(value * scalar)
    }

    override fun times(scalar: Float): LateralAcceleration {
        return LateralAcceleration(value * scalar)
    }

    override fun times(scalar: Double): LateralAcceleration {
        return LateralAcceleration(value * scalar)
    }

    override fun div(scalar: Int): LateralAcceleration {
        return LateralAcceleration(value / scalar)
    }

    override fun div(scalar: Short): LateralAcceleration {
        return LateralAcceleration(value / scalar)
    }

    override fun div(scalar: Long): LateralAcceleration {
        return LateralAcceleration(value / scalar)
    }

    override fun div(scalar: Float): LateralAcceleration {
        return LateralAcceleration(value / scalar)
    }

    override fun div(scalar: Double): LateralAcceleration {
        return LateralAcceleration(value / scalar)
    }
}

@JvmInline
value class Rate(val value: Double) : Arithmetic<Rate>, Scalable<Rate> {
    override fun plus(other: Rate): Rate {
        return Rate(value + other.value)
    }

    override fun minus(other: Rate): Rate {
        return Rate(value - other.value)
    }

    override fun unaryMinus(): Rate {
        return Rate(-value)
    }

    override fun unaryPlus(): Rate {
        return Rate(+value)
    }

    override fun toFloat(): Float {
        return value.toFloat()
    }

    override fun toDouble(): Double {
        return value
    }

    override fun compareTo(other: Rate): Int {
        return value.compareTo(other.value)
    }

    override fun times(scalar: Int): Rate {
        return Rate(value * scalar)
    }

    override fun times(scalar: Short): Rate {
        return Rate(value * scalar)
    }

    override fun times(scalar: Long): Rate {
        return Rate(value * scalar)
    }

    override fun times(scalar: Float): Rate {
        return Rate(value * scalar)
    }

    override fun times(scalar: Double): Rate {
        return Rate(value * scalar)
    }

    override fun div(scalar: Int): Rate {
        return Rate(value / scalar)
    }

    override fun div(scalar: Short): Rate {
        return Rate(value / scalar)
    }

    override fun div(scalar: Long): Rate {
        return Rate(value / scalar)
    }

    override fun div(scalar: Float): Rate {
        return Rate(value / scalar)
    }

    override fun div(scalar: Double): Rate {
        return Rate(value / scalar)
    }

}

class AngularVelocity(val rate: Rate, val unit: AngleUnit = AngleUnit.RADIANS) {
    init {
        when (unit) {
            AngleUnit.DEGREES -> {
                require(rate.value < 36_000) { "Angular Velocity cannot exceed 36,000 Degrees per second." }
                require(rate.value > -36_000) { "Angular Velocity cannot exceed 36,000 Degrees per second." }
            }

            AngleUnit.RADIANS -> {
                require(rate.value < 200 * π) { "Angular Velocity cannot exceed 200π Radians per second." }
                require(rate.value > -200 * π) { "Angular Velocity cannot exceed 200π Radians per second." }
            }
        }
    }
}
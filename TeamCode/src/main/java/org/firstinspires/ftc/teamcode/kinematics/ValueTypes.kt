package org.firstinspires.ftc.teamcode.kinematics


import org.firstinspires.ftc.teamcode.kinematics.Measure.Angle
import org.firstinspires.ftc.teamcode.kinematics.Measure.Angle.Degrees
import org.firstinspires.ftc.teamcode.kinematics.Measure.Angle.Radians
import org.firstinspires.ftc.teamcode.kinematics.Measure.Angle.Revolutions
import org.firstinspires.ftc.teamcode.kinematics.Measure.Length
import org.firstinspires.ftc.teamcode.kinematics.Measure.Length.Meters
import kotlin.math.PI
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

const val π = PI

interface Arithmetic<T> : Comparable<T> {
    operator fun plus(other: T): T
    operator fun minus(other: T): T
    operator fun unaryMinus(): T
    operator fun unaryPlus(): T
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

@JvmInline
value class AxialVelocity<Type: Velocity<*,Type>>(val value: Type) : Arithmetic<Type> by value, Scalable<Type> by value

@JvmInline
value class LateralVelocity<T: Velocity<*,T>>(val value: T) : Arithmetic<T> by value,
    Scalable<T> by value

@JvmInline
value class YawVelocity(val value: AngularVelocity) : Arithmetic<AngularVelocity> by value, Scalable<AngularVelocity> by value

@JvmInline
value class AxialAcceleration(val value: Double) : Arithmetic<AxialAcceleration>,
    Scalable<AxialAcceleration>

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


sealed class Measure {
    sealed class Angle : Measure(), Arithmetic<Angle>, Scalable<Angle>, Angles {
        data class Radians(val value: Double) : Angle() {
            override fun plus(other: Angle): Angle {
                return Radians(value + other.radians.value)
            }

            override fun minus(other: Angle): Angle {
                return Radians(value - other.radians.value)
            }

            override fun unaryMinus(): Angle {
                return Radians(-value)
            }

            override fun unaryPlus(): Angle {
                return Radians(+value)
            }

            override fun compareTo(other: Angle): Int {
                return value.compareTo(other.radians.value)
            }

            override fun times(scalar: Int): Angle {
                return Radians(value * scalar)
            }

            override fun times(scalar: Short): Angle {
                return Radians(value * scalar)
            }

            override fun times(scalar: Long): Angle {
                return Radians(value * scalar)
            }

            override fun times(scalar: Float): Angle {
                return Radians(value * scalar)
            }

            override fun times(scalar: Double): Angle {
                return Radians(value * scalar)
            }

            override fun div(scalar: Int): Angle {
                return Radians(value / scalar)
            }

            override fun div(scalar: Short): Angle {
                return Radians(value / scalar)
            }

            override fun div(scalar: Long): Angle {
                return Radians(value / scalar)
            }

            override fun div(scalar: Float): Angle {
                return Radians(value / scalar)
            }

            override fun div(scalar: Double): Angle {
                return Radians(value / scalar)
            }

            override val radians: Radians
                get() = this
            override val degrees: Degrees
                get() = Degrees(value * 180.0 / π)
            override val revolutions: Revolutions
                get() = Revolutions(value / (2.0 * π))

        }

        data class Degrees(val value: Double) : Angle() {
            override fun plus(other: Angle): Angle {
                return Degrees(value + other.degrees.value)
            }

            override fun minus(other: Angle): Angle {
                return Degrees(value - other.degrees.value)
            }

            override fun unaryMinus(): Angle {
                return Degrees(-value)
            }

            override fun unaryPlus(): Angle {
                return Degrees(+value)
            }

            override fun compareTo(other: Angle): Int {
                return value.compareTo(other.degrees.value)
            }

            override fun times(scalar: Int): Angle {
                return Degrees(value * scalar)
            }

            override fun times(scalar: Short): Angle {
                return Degrees(value * scalar)
            }

            override fun times(scalar: Long): Angle {
                return Degrees(value * scalar)
            }

            override fun times(scalar: Float): Angle {
                return Degrees(value * scalar)
            }

            override fun times(scalar: Double): Angle {
                return Degrees(value * scalar)
            }

            override fun div(scalar: Int): Angle {
                return Degrees(value / scalar)
            }

            override fun div(scalar: Short): Angle {
                return Degrees(value / scalar)
            }

            override fun div(scalar: Long): Angle {
                return Degrees(value / scalar)
            }

            override fun div(scalar: Float): Angle {
                return Degrees(value / scalar)
            }

            override fun div(scalar: Double): Angle {
                return Degrees(value / scalar)
            }

            override val radians: Radians
                get() = Radians(value * π / 180.0)
            override val degrees: Degrees
                get() = this
            override val revolutions: Revolutions
                get() = Revolutions(value / 360.0)

        }

        data class Revolutions(val value: Double) : Angle() {
            override fun plus(other: Angle): Angle {
                return Revolutions(value + other.revolutions.value)
            }

            override fun minus(other: Angle): Angle {
                return Revolutions(value - other.revolutions.value)
            }

            override fun unaryMinus(): Angle {
                return Revolutions(-value)
            }

            override fun unaryPlus(): Angle {
                return Revolutions(+value)
            }

            override fun compareTo(other: Angle): Int {
                return value.compareTo(other.revolutions.value)
            }

            override fun times(scalar: Int): Angle {
                return Revolutions(value * scalar)
            }

            override fun times(scalar: Short): Angle {
                return Revolutions(value * scalar)
            }

            override fun times(scalar: Long): Angle {
                return Revolutions(value * scalar)
            }

            override fun times(scalar: Float): Angle {
                return Revolutions(value * scalar)
            }

            override fun times(scalar: Double): Angle {
                return Revolutions(value * scalar)
            }

            override fun div(scalar: Int): Angle {
                return Revolutions(value / scalar)
            }

            override fun div(scalar: Short): Angle {
                return Revolutions(value / scalar)
            }

            override fun div(scalar: Long): Angle {
                return Revolutions(value / scalar)
            }

            override fun div(scalar: Float): Angle {
                return Revolutions(value / scalar)
            }

            override fun div(scalar: Double): Angle {
                return Revolutions(value / scalar)
            }

            override val radians: Radians
                get() = Radians(value * 2.0 * π)
            override val degrees: Degrees
                get() = Degrees(value * 360.0)
            override val revolutions: Revolutions
                get() = this
        }
    }

    interface Angles {
        val radians: Radians
        val degrees: Degrees
        val revolutions: Revolutions
    }

    sealed class Length : Measure(), Arithmetic<Length>, Scalable<Length>, Lengths {
        data class Inches(val value: Double) : Length() {
            override fun plus(other: Length): Length {
                return Inches(value + other.inches.value)
            }

            override fun minus(other: Length): Length {
                return Inches(value + other.inches.value)
            }

            override fun unaryMinus(): Length {
                return Inches(-value)
            }

            override fun unaryPlus(): Length {
                return Inches(+value)
            }

            override fun compareTo(other: Length): Int {
                return value.compareTo(other.inches.value)
            }

            override fun times(scalar: Int): Length {
                return Inches(value * scalar)
            }

            override fun times(scalar: Short): Length {
                return Inches(value * scalar)
            }

            override fun times(scalar: Long): Length {
                return Inches(value * scalar)
            }

            override fun times(scalar: Float): Length {
                return Inches(value * scalar)
            }

            override fun times(scalar: Double): Length {
                return Inches(value * scalar)
            }

            override fun div(scalar: Int): Length {
                return Inches(value / scalar)
            }

            override fun div(scalar: Short): Length {
                return Inches(value / scalar)
            }

            override fun div(scalar: Long): Length {
                return Inches(value / scalar)
            }

            override fun div(scalar: Float): Length {
                return Inches(value / scalar)
            }

            override fun div(scalar: Double): Length {
                return Inches(value / scalar)
            }

            override val inches: Inches
                get() = this
            override val centimeters: Centimeters
                get() = Centimeters(value * 2.54)
            override val meters: Meters
                get() = Meters(centimeters.value / 100.0)
            override val feet: Feet
                get() = Feet(value / 12.0)
            override val millimeters: Millimeters
                get() = Millimeters(centimeters.value * 10.0)
        }

        data class Centimeters(val value: Double) : Length() {
            override fun plus(other: Length): Length {
                return Centimeters(value + other.centimeters.value)
            }

            override fun minus(other: Length): Length {
                return Centimeters(value + other.centimeters.value)
            }

            override fun unaryMinus(): Length {
                return Centimeters(-value)
            }

            override fun unaryPlus(): Length {
                return Centimeters(+value)
            }

            override fun compareTo(other: Length): Int {
                return value.compareTo(other.centimeters.value)
            }

            override fun times(scalar: Int): Length {
                return Centimeters(value * scalar)
            }

            override fun times(scalar: Short): Length {
                return Centimeters(value * scalar)
            }

            override fun times(scalar: Long): Length {
                return Centimeters(value * scalar)
            }

            override fun times(scalar: Float): Length {
                return Centimeters(value * scalar)
            }

            override fun times(scalar: Double): Length {
                return Centimeters(value * scalar)
            }

            override fun div(scalar: Int): Length {
                return Centimeters(value / scalar)
            }

            override fun div(scalar: Short): Length {
                return Centimeters(value / scalar)
            }

            override fun div(scalar: Long): Length {
                return Centimeters(value / scalar)
            }

            override fun div(scalar: Float): Length {
                return Centimeters(value / scalar)
            }

            override fun div(scalar: Double): Length {
                return Centimeters(value / scalar)
            }

            override val inches: Inches
                get() = Inches(value / 2.54)
            override val centimeters: Centimeters
                get() = this
            override val meters: Meters
                get() = Meters(value / 100.0)
            override val feet: Feet
                get() = Feet(inches.value / 12.0)
            override val millimeters: Millimeters
                get() = Millimeters(value / 10.0)
        }

        data class Meters(val value: Double) : Length() {
            override fun plus(other: Length): Length {
                return Meters(value + other.meters.value)
            }

            override fun minus(other: Length): Length {
                return Meters(value - other.meters.value)
            }

            override fun unaryMinus(): Length {
                return Meters(-value)
            }

            override fun unaryPlus(): Length {
                return Meters(+value)
            }

            override fun compareTo(other: Length): Int {
                return value.compareTo(other.meters.value)
            }

            override fun times(scalar: Int): Length {
                return Meters(value * scalar)
            }

            override fun times(scalar: Short): Length {
                return Meters(value * scalar)
            }

            override fun times(scalar: Long): Length {
                return Meters(value * scalar)
            }

            override fun times(scalar: Float): Length {
                return Meters(value * scalar)
            }

            override fun times(scalar: Double): Length {
                return Meters(value * scalar)
            }

            override fun div(scalar: Int): Length {
                return Meters(value / scalar)
            }

            override fun div(scalar: Short): Length {
                return Meters(value / scalar)
            }

            override fun div(scalar: Long): Length {
                return Meters(value / scalar)
            }

            override fun div(scalar: Float): Length {
                return Meters(value / scalar)
            }

            override fun div(scalar: Double): Length {
                return Meters(value / scalar)
            }

            override val meters: Meters
                get() = this
            override val centimeters: Centimeters
                get() = Centimeters(value * 100.0)
            override val millimeters: Millimeters
                get() = Millimeters(value * 1_000.0)
            override val inches: Inches
                get() = Inches(centimeters.value / 2.54)
            override val feet: Feet
                get() = Feet(inches.value / 12.0)
        }

        data class Feet(val value: Double) : Length() {
            override fun plus(other: Length): Length {
                return Feet(value + other.feet.value)
            }

            override fun minus(other: Length): Length {
                return Feet(value - other.feet.value)
            }

            override fun unaryMinus(): Length {
                return Feet(-value)
            }

            override fun unaryPlus(): Length {
                return Feet(+value)
            }

            override fun compareTo(other: Length): Int {
                return value.compareTo(other.feet.value)
            }

            override fun times(scalar: Int): Length {
                return Feet(value * scalar)
            }

            override fun times(scalar: Short): Length {
                return Feet(value * scalar)
            }

            override fun times(scalar: Long): Length {
                return Feet(value * scalar)
            }

            override fun times(scalar: Float): Length {
                return Feet(value * scalar)
            }

            override fun times(scalar: Double): Length {
                return Feet(value * scalar)
            }

            override fun div(scalar: Int): Length {
                return Feet(value / scalar)
            }

            override fun div(scalar: Short): Length {
                return Feet(value / scalar)
            }

            override fun div(scalar: Long): Length {
                return Feet(value / scalar)
            }

            override fun div(scalar: Float): Length {
                return Feet(value / scalar)
            }

            override fun div(scalar: Double): Length {
                return Feet(value / scalar)
            }

            override val feet: Feet
                get() = this
            override val inches: Inches
                get() = Inches(value / 12.0)
            override val centimeters: Centimeters
                get() = Centimeters(inches.value * 2.54)
            override val meters: Meters
                get() = Meters(centimeters.value / 100.0)
            override val millimeters: Millimeters
                get() = Millimeters(centimeters.value * 10.0)
        }

        data class Millimeters(val value: Double) : Length() {
            override fun plus(other: Length): Length {
                return Millimeters(value + other.millimeters.value)
            }

            override fun minus(other: Length): Length {
                return Millimeters(value - other.millimeters.value)
            }

            override fun unaryMinus(): Length {
                return Millimeters(-value)
            }

            override fun unaryPlus(): Length {
                return Millimeters(+value)
            }

            override fun compareTo(other: Length): Int {
                return value.compareTo(other.millimeters.value)
            }

            override fun times(scalar: Int): Length {
                return Millimeters(value * scalar)
            }

            override fun times(scalar: Short): Length {
                return Millimeters(value * scalar)
            }

            override fun times(scalar: Long): Length {
                return Millimeters(value * scalar)
            }

            override fun times(scalar: Float): Length {
                return Millimeters(value * scalar)
            }

            override fun times(scalar: Double): Length {
                return Millimeters(value * scalar)
            }

            override fun div(scalar: Int): Length {
                return Millimeters(value / scalar)
            }

            override fun div(scalar: Short): Length {
                return Millimeters(value / scalar)
            }

            override fun div(scalar: Long): Length {
                return Millimeters(value / scalar)
            }

            override fun div(scalar: Float): Length {
                return Millimeters(value / scalar)
            }

            override fun div(scalar: Double): Length {
                return Millimeters(value / scalar)
            }

            override val millimeters: Millimeters
                get() = this
            override val centimeters: Centimeters
                get() = Centimeters(value / 10.0)
            override val meters: Meters
                get() = Meters(value / 100.0)
            override val inches: Inches
                get() = Inches(centimeters.value / 2.54)
            override val feet: Feet
                get() = Feet(inches.value / 12.0)
        }
    }

    interface Lengths {
        val inches: Length.Inches
        val centimeters: Length.Centimeters
        val meters: Length.Meters
        val feet: Length.Feet
        val millimeters: Length.Millimeters
    }
}

interface Velocity<Unit : Measure, Subclass : Velocity<Unit, Subclass>> : Arithmetic<Subclass>, Scalable<Subclass> {
    fun unitsPerSecond(): Unit
    operator fun times(other: Duration) : Unit
    operator fun div(other: Duration) : Acceleration<Unit, *>
}

data class AngularVelocity(val angle: Angle, val duration: Duration = 1.seconds) :
    Velocity<Angle, AngularVelocity> {
    override fun plus(other: AngularVelocity): AngularVelocity {
        return AngularVelocity( unitsPerSecond() + other.unitsPerSecond(), 1.seconds )
    }

    override fun minus(other: AngularVelocity): AngularVelocity {
        return AngularVelocity( unitsPerSecond() - other.unitsPerSecond(), 1.seconds )
    }

    override fun unaryMinus(): AngularVelocity {
        return AngularVelocity(-angle, duration)
    }

    override fun unaryPlus(): AngularVelocity {
        return AngularVelocity(+angle, duration)
    }

    override fun compareTo(other: AngularVelocity): Int {
        return unitsPerSecond().compareTo(other.unitsPerSecond())
    }

    override fun times(scalar: Int): AngularVelocity {
        return AngularVelocity(angle * scalar, duration)
    }

    override fun times(scalar: Short): AngularVelocity {
        return AngularVelocity(angle * scalar, duration)
    }

    override fun times(scalar: Long): AngularVelocity {
        return AngularVelocity(angle * scalar, duration)
    }

    override fun times(scalar: Float): AngularVelocity {
        return AngularVelocity(angle * scalar, duration)
    }

    override fun times(scalar: Double): AngularVelocity {
        return AngularVelocity(angle * scalar, duration)
    }

    override fun div(scalar: Int): AngularVelocity {
        return AngularVelocity(angle / scalar, duration)
    }

    override fun div(scalar: Short): AngularVelocity {
        return AngularVelocity(angle / scalar, duration)
    }

    override fun div(scalar: Long): AngularVelocity {
        return AngularVelocity(angle / scalar, duration)
    }

    override fun div(scalar: Float): AngularVelocity {
        return AngularVelocity(angle / scalar, duration)
    }

    override fun div(scalar: Double): AngularVelocity {
        return AngularVelocity(angle / scalar, duration)
    }

    override fun unitsPerSecond(): Angle {
        return angle * duration.inFractionalSeconds()
    }

    override fun times(other: Duration): Angle {
        return unitsPerSecond() * other.inFractionalSeconds()
    }

    override fun div(other: Duration): Acceleration<Angle, *> {
        return AngularAcceleration(unitsPerSecond() / other.inFractionalSeconds())
    }

    init {
        require(unitsPerSecond() < Revolutions(100.0)) { "Angular Velocity cannot exceed 100 revolutions per second (36,000 Degrees or 200π Radians per second)." }
    }
}

data class LinearVelocity(val length: Length, val duration: Duration = 1.seconds) :
    Velocity<Length, LinearVelocity> {
    override fun unitsPerSecond(): Length {
        return length * duration.inFractionalSeconds()
    }

    override fun times(other: Duration): Length {
        return unitsPerSecond() * other.inFractionalSeconds()
    }

    override fun div(other: Duration): Acceleration<Length, *> {
        return LinearAcceleration(unitsPerSecond() / other.inFractionalSeconds(), 1.seconds)
    }

    override fun plus(other: LinearVelocity): LinearVelocity {
        return LinearVelocity(unitsPerSecond() + other.unitsPerSecond(), 1.seconds)
    }

    override fun minus(other: LinearVelocity): LinearVelocity {
        return LinearVelocity(unitsPerSecond() + other.unitsPerSecond(), 1.seconds)
    }

    override fun unaryMinus(): LinearVelocity {
        return LinearVelocity(-length, duration)
    }

    override fun unaryPlus(): LinearVelocity {
        return LinearVelocity(+length, duration)
    }

    override fun compareTo(other: LinearVelocity): Int {
        return unitsPerSecond().compareTo(other.unitsPerSecond())
    }

    override fun times(scalar: Int): LinearVelocity {
        return LinearVelocity(length * scalar, duration)
    }

    override fun times(scalar: Short): LinearVelocity {
        return LinearVelocity(length * scalar, duration)
    }

    override fun times(scalar: Long): LinearVelocity {
        return LinearVelocity(length * scalar, duration)
    }

    override fun times(scalar: Float): LinearVelocity {
        return LinearVelocity(length * scalar, duration)
    }

    override fun times(scalar: Double): LinearVelocity {
        return LinearVelocity(length * scalar, duration)
    }

    override fun div(scalar: Int): LinearVelocity {
        return LinearVelocity(length / scalar, duration)
    }

    override fun div(scalar: Short): LinearVelocity {
        return LinearVelocity(length / scalar, duration)
    }

    override fun div(scalar: Long): LinearVelocity {
        return LinearVelocity(length / scalar, duration)
    }

    override fun div(scalar: Float): LinearVelocity {
        return LinearVelocity(length / scalar, duration)
    }

    override fun div(scalar: Double): LinearVelocity {
        return LinearVelocity(length / scalar, duration)
    }
}

interface Acceleration<Unit : Measure, Subclass : Acceleration<Unit, Subclass>> : Arithmetic<Subclass>, Scalable<Subclass> {
    fun unitsPerSecondSquared(): Unit
    operator fun times(other: Duration) : Velocity<Unit,*>
    operator fun div(other: Duration) : Jerk<Unit, *>
}

data class AngularAcceleration(val angle: Angle, val duration: Duration = 1.seconds) : Acceleration<Angle, AngularAcceleration> {
    override fun unitsPerSecondSquared(): Angle {
        return angle * duration.inFractionalSeconds()
    }

    override fun times(other: Duration): Velocity<Angle, *> {
        return AngularVelocity(unitsPerSecondSquared() / other.inFractionalSeconds(), 1.seconds)
    }

    override fun times(scalar: Int): AngularAcceleration {
        return AngularAcceleration(angle * scalar)
    }

    override fun times(scalar: Short): AngularAcceleration {
        return AngularAcceleration(angle * scalar)
    }

    override fun times(scalar: Long): AngularAcceleration {
        return AngularAcceleration(angle * scalar)
    }

    override fun times(scalar: Float): AngularAcceleration {
        return AngularAcceleration(angle * scalar)
    }

    override fun times(scalar: Double): AngularAcceleration {
        return AngularAcceleration(angle * scalar)
    }

    override fun div(other: Duration): Jerk<Angle, *> {
        TODO("")
    }

    override fun div(scalar: Int): AngularAcceleration {
        return AngularAcceleration(angle / scalar)
    }

    override fun div(scalar: Short): AngularAcceleration {
        return AngularAcceleration(angle / scalar)
    }

    override fun div(scalar: Long): AngularAcceleration {
        return AngularAcceleration(angle / scalar)
    }

    override fun div(scalar: Float): AngularAcceleration {
        return AngularAcceleration(angle / scalar)
    }

    override fun div(scalar: Double): AngularAcceleration {
        return AngularAcceleration(angle / scalar)
    }

    override fun plus(other: AngularAcceleration): AngularAcceleration {
        return AngularAcceleration(unitsPerSecondSquared() + other.unitsPerSecondSquared(), 1.seconds)
    }

    override fun minus(other: AngularAcceleration): AngularAcceleration {
        return AngularAcceleration(unitsPerSecondSquared() - other.unitsPerSecondSquared(), 1.seconds)
    }

    override fun unaryMinus(): AngularAcceleration {
        return AngularAcceleration(-angle)
    }

    override fun unaryPlus(): AngularAcceleration {
        return AngularAcceleration(+angle)
    }

    override fun compareTo(other: AngularAcceleration): Int {
        return unitsPerSecondSquared().compareTo(other.unitsPerSecondSquared())
    }
}

data class LinearAcceleration(val length: Length, val duration: Duration = 1.seconds) : Acceleration<Length, LinearAcceleration> {
    override fun unitsPerSecondSquared(): Length {
        TODO("Not yet implemented")
    }

    override fun times(other: Duration): Velocity<Length, *> {
        TODO("Not yet implemented")
    }

    override fun times(scalar: Int): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun times(scalar: Short): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun times(scalar: Long): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun times(scalar: Float): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun times(scalar: Double): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun div(other: Duration): Jerk<Length, *> {
        TODO("Not yet implemented")
    }

    override fun div(scalar: Int): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun div(scalar: Short): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun div(scalar: Long): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun div(scalar: Float): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun div(scalar: Double): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun plus(other: LinearAcceleration): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun minus(other: LinearAcceleration): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun unaryMinus(): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun unaryPlus(): LinearAcceleration {
        TODO("Not yet implemented")
    }

    override fun compareTo(other: LinearAcceleration): Int {
        TODO("Not yet implemented")
    }
}

interface Jerk<Unit : Measure, Subclass : Jerk<Unit, Subclass>> : Arithmetic<Subclass>, Scalable<Subclass> {
    fun unitsPerSecondCubed(): Unit
    operator fun times(other: Duration): Acceleration<Unit, *>
    operator fun div(other: Duration) : Snap<Unit, *>
}

data class AngularJerk(val angle: Angle, val duration: Duration) : Jerk<Angle, AngularJerk>

data class LinearJerk(val length: Length, val duration: Duration) : Jerk<Length, LinearJerk>

abstract class Snap<Unit: Measure, Subclass: Snap<Unit, Subclass>>(val unit: Unit, val tesseract: Duration): Arithmetic<Subclass>, Scalable<Subclass> {
    fun unitsPerSecondTesseracted(): Unit {
        return unit * tesseract.inFractionalSeconds()
    }
    operator fun times(other: Duration): Jerk<Unit, *>
}

data class AngularSnap(val angle: Angle, val duration: Duration) : Snap<Angle, AngularSnap>

data class LinearSnap(val angle: Angle, val duration: Duration) : Snap<Length, LinearSnap>

fun Duration.inFractionalSeconds(): Double {
    return this.inWholeMilliseconds / 1_000.0
}




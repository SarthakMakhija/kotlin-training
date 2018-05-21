package extension

data class Rational(val numerator: Int, val denominator: Int = 1){

    infix fun add(other: Rational) =
            Rational(((this.numerator * other.denominator) + (other.numerator * this.denominator)),  (this.denominator * other.denominator))

    operator fun plus(other: Rational) = add(other)

    operator fun times(value: Int) = Rational(this.numerator * value, this.denominator)
}
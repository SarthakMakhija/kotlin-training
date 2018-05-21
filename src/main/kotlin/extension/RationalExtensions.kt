package extension

fun Rational.isWhole() = this.denominator == 1

fun Rational.swap() = Rational(this.denominator, this.numerator)
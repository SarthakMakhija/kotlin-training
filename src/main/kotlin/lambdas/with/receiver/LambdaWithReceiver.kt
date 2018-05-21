package lambdas.with.receiver

object LambdaWithReceiver {

    fun makeStringLambda(action: (StringBuilder) -> Unit): String {
        val sb = StringBuilder()
        action(sb)
        return sb.toString()
    }

    fun makeStringLambdaWithReceiver(action: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        sb.action()
        return sb.toString()
    }
}
package dsl

class DSLUsingLambdaWithReceiver {

    private val configurations = arrayListOf<String>()

    fun compile(coordinate: String) {
        configurations += coordinate
    }

    fun allCompileDependencies() = configurations.toList()
}

fun dependencies(init: DSLUsingLambdaWithReceiver.() -> Unit): DSLUsingLambdaWithReceiver {
    val dslUsingLambdaWithReceiver = DSLUsingLambdaWithReceiver()
    init(dslUsingLambdaWithReceiver)
    return dslUsingLambdaWithReceiver
}
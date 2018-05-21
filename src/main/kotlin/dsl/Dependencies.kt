package dsl

class Dependencies {

    private val configurations = arrayListOf<Configuration>()

    fun compile(coordinate: String) {
        configurations += CompileConfiguration(coordinate)
    }

    fun testCompile(coordinate: String) {
        configurations += TestCompileConfiguration(coordinate)
    }

    fun testRuntime(coordinate: String) {
        configurations += TestRuntimeConfiguration(coordinate)
    }

    operator fun invoke(init: Dependencies.() -> Unit) {
        init()
    }

    fun allCompileDependencies()     = filterConfigurationOnType(CompileConfiguration::class.java).map { it.coordinate }
    fun allTestCompileDependencies() = filterConfigurationOnType(TestCompileConfiguration::class.java).map { it.coordinate }
    fun allTestRuntimeDependencies() = filterConfigurationOnType(TestRuntimeConfiguration::class.java).map { it.coordinate }

    private fun <T: Configuration> filterConfigurationOnType(kclass: Class<T>) = configurations.filterIsInstance(kclass)
}

private interface Configuration {
    val coordinate: String
}

class CompileConfiguration    (override val coordinate: String) : Configuration
class TestCompileConfiguration(override val coordinate: String) : Configuration
class TestRuntimeConfiguration(override val coordinate: String) : Configuration
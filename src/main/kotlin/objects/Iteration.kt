package objects

class Iteration(val id: Int, private val tasks: List<Task>) {

    fun totalSpikes()   = tasks.filterIsInstance(Spike::class.java).count()

    fun storiesBySize() = tasks.filterIsInstance(Story::class.java).groupBy { it.size }

    fun allStories()    = tasks.filterIsInstance(Story::class.java)

    fun filterStoriesBy(predicate: (Story) -> Boolean) = tasks.filterIsInstance(Story::class.java).filter(predicate)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Iteration

        if (id != other.id) return false

        return true
    }
}

/**
 * Tasks:
 * (1) Introduce method reference
 *
 */
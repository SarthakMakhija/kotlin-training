package objects

open class Story(description: String, val size: Size) : Task(description) {

    operator fun component1() = description
    operator fun component2() = size

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Story

        if (size        != other.size) return false
        if (description != other.description) return false

        return true
    }
}
package misc

fun <T> Collection<T>.makeString(separator: String = ",", transform: (T) -> String) =
        StringBuilder().apply {
            val size = this@makeString.size
            for ((index, value) in this@makeString.withIndex()) {
                if (index == size - 1)
                    append(transform.invoke(value))
                else
                    append(transform.invoke(value)).append(separator)
            }
        }.toString()
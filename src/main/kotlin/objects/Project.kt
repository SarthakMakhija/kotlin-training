package objects

class Project(val iterations: List<Iteration>){

    operator fun contains(iteration: Iteration) = iterations.contains(iteration)

    inline fun <T: Any> mapStoryFieldFor(iteration: Iteration, mapFn: (Story) -> T): List<T> =
            iterations
                .filter  { it == iteration }
                .flatMap { it.allStories() }
                .map     ( mapFn )
}
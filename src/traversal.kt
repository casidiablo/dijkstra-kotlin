import java.util.LinkedList

fun <T, E : Number> depthFirstTraversal(graph: Graph<T, E>, source: T) {
    val visited = mutableSetOf<T>()
    val queue = LinkedList<T>()
    queue.add(source)
    while (queue.isNotEmpty()) {
        val current = queue.removeLast()
        visited.add(current)
        println(current)
        graph.adjacentVertices(current)
                .filter { !visited.contains(it) && !queue.contains(it) }
                .forEach { queue.add(it) }
    }
}

fun <T, E : Number> depthFirstPathSearch(graph: Graph<T, E>, source: T, destination: T): List<T> {
    val visited = mutableSetOf<T>()
    val queue = LinkedList<T>()
    val path = mutableListOf<T>()
    queue.add(source)
    while (queue.isNotEmpty()) {
        val current = queue.removeLast()
        visited.add(current)
        path.add(current)

        val adjacentVertices = graph.adjacentVertices(current)
        when {
            adjacentVertices.isEmpty() -> path.remove(current)
            adjacentVertices.contains(destination) -> return path + listOf(destination)
            else -> adjacentVertices
                    .filter { !visited.contains(it) && !queue.contains(it) }
                    .forEach { queue.add(it) }
        }
    }
    return emptyList()
}


fun <T, E : Number> breadthFirstTraversal(graph: Graph<T, E>, source: T) {
    val visited = mutableSetOf<T>()
    val queue = LinkedList<T>()
    queue.add(source)
    while (queue.isNotEmpty()) {
        val current = queue.pop()
        visited.add(current)
        println(current)
        graph.adjacentVertices(current)
                .filter { !visited.contains(it) && !queue.contains(it) }
                .forEach { queue.add(it) }
    }
}

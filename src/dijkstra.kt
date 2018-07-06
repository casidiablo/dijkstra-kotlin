fun <T, E: Number> shortestPath(graph: Graph<T, E>, from: T, destination: T): Pair<List<T>, Double> {
    return dijkstra(graph, from, destination)[destination] ?: (emptyList<T>() to Double.POSITIVE_INFINITY)
}

private fun <T, E : Number> dijkstra(graph: Graph<T, E>, from: T, destination: T? = null): Map<T, Pair<List<T>, Double>> {
    val unvisitedSet = graph.getAllVertices().toMutableSet()
    val distances = graph.getAllVertices().map { it to Double.POSITIVE_INFINITY }.toMap().toMutableMap()
    val paths = mutableMapOf<T, List<T>>()
    distances[from] = 0.0

    var current = from

    while (unvisitedSet.isNotEmpty() && unvisitedSet.contains(destination)) {
        graph.adjacentVertices(current).forEach { adjacent ->
            val distance = graph.getDistance(current, adjacent).toDouble()
            if (distances[current]!! + distance < distances[adjacent]!!) {
                distances[adjacent] = distances[current]!! + distance
                paths[adjacent] = paths.getOrDefault(current, listOf(current)) + listOf(adjacent)
            }
        }

        unvisitedSet.remove(current)

        if (current == destination || unvisitedSet.all { distances[it]!!.isInfinite() }) {
            break
        }

        if (unvisitedSet.isNotEmpty()) {
            current = unvisitedSet.minBy { distances[it]!! }!!
        }
    }

    return paths.mapValues { entry -> entry.value to distances[entry.key]!! }
}
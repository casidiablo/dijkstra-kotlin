fun main(args: Array<String>) {
    val graph = GraphImpl<String, Int>(directed = true, defaultCost = 1)
            .addArc("A" to "B", 2)
            .addArc("A" to "C", 8)
            .addArc("B" to "D", 5)
            .addArc("B" to "E", 6)
            .addArc("E" to "C", 4)
            .addArc("A" to "F", 14)
            .addArc("B" to "F", 10)
            .addArc("C" to "F", 8)
            .addArc("D" to "F", 4)
            .addArc("X" to "Z", 4)

    val (path, value) = shortestPath(graph, "A", "Z")
    println("path = $path, value = $value")

    depthFirstTraversal(graph, "A")
    println("-----")

    breadthFirstTraversal(graph, "A")
    println("-----")

    val depthFirstPathSearch = depthFirstPathSearch(graph, "A", "F")
    println("depthFirstPathSearch = $depthFirstPathSearch")
}


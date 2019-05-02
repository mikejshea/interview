import services.RouteAggr

fun main() {
    val routeAggr = RouteAggr()
    val results = StringBuilder()
    val userId = 42
// Find all routes
    results.append("All routes: [")
        .append(routeAggr.getRoutes().joinToString { "\"$it\"" })
        .append("]").append(System.lineSeparator())
// Find distinct routes
    results.append("Unique routes: [")
        .append(routeAggr.getUniqueRoutes().joinToString { "\"$it\"" })
        .append("]").append(System.lineSeparator())
// Find routes for user 42
    results.append("For user 42: [")
        .append(routeAggr.getRoutes(userId).joinToString { "\"$it\"" })
        .append("]").append(System.lineSeparator())
// Find routes for user 42 with services, kommot and rwgps
    results.append("For user 42 services [\"Komoot\", \"RWGPS\"]:: [")
        .append(routeAggr.getRoutes(userId, arrayOf("Komoot", "RWGPS")).joinToString { "\"$it\"" })
        .append("]").append(System.lineSeparator())
    print(results.toString())
}

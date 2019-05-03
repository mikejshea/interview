package interview
import interview.services.RouteAggr
import kotlin.system.exitProcess



fun main(args: Array<String>) {

    val routeAggr = RouteAggr()
    val results = StringBuilder()
    val userId = getUserId(args)

    if (userId == null)
    {
        println("UserId Error:: userId must be an integer. userId=${args[0]}")
        exitProcess(1)
    }

// Find all routes
    results.append("All routes: [")
        .append(routeAggr.getRoutes().joinToString { "\"$it\"" })
        .append("]").append(System.lineSeparator())
// Find distinct routes
    results.append("Unique routes: [")
        .append(routeAggr.getUniqueRoutes().joinToString { "\"$it\"" })
        .append("]").append(System.lineSeparator())
// Find routes for userId
    results.append("For user $userId: [")
        .append(routeAggr.getRoutes(userId).joinToString { "\"$it\"" })
        .append("]").append(System.lineSeparator())
// Find routes for userId with services, kommot and rwgps
    results.append("For user $userId services [\"Komoot\", \"RWGPS\"]:: [")
        .append(routeAggr.getRoutes(userId, arrayOf("Komoot", "RWGPS")).joinToString { "\"$it\"" })
        .append("]").append(System.lineSeparator())
    print(results.toString())
}

fun getUserId(args: Array<String>): Int? {
    var userId: Int?
    if (args.isEmpty()) {
        userId = 42
    } else {
        try {
            userId = args[0].toInt()
            if (userId < 0) userId = null
        } catch (nfe: NumberFormatException) {
            userId = null
        }
    }
    return userId
}
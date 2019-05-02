package services

import kotlin.collections.ArrayList
import kotlinx.coroutines.*

class RouteAggr {

    private val srvs: HashMap<String, Services> = HashMap()

    private fun getRoutes(userId: Int? = null, services: HashMap<String, Services>): ArrayList<String> {
        val deferred = (services.keys).map { n ->
            GlobalScope.async {
                services[n]!!.getRoutes(userId)
            }
        }
        return runBlocking {
            ArrayList(deferred.flatMap { it.await() })
        }
    }
    fun getRoutes(userId: Int? = null): ArrayList<String> {
        return getRoutes(userId, srvs)
    }

    fun getRoutes(userId: Int, services: Array<String>): ArrayList<String>  {
//      Create new list with all strings lowercase
        val servicesLower = services.map { it.toLowerCase() }

//      Create empty HashMap to use with filterTo
        val filteredServices = HashMap<String, Services>()
        srvs.filterTo(filteredServices) { it.key in servicesLower}
        return getRoutes(userId, filteredServices)
    }

    fun getUniqueRoutes(): ArrayList<String> {
        return ArrayList(getRoutes().distinct())
    }

    init {
        srvs["strava"] = Strava()
        srvs["rwgps"] = Rwgps()
        srvs["komoot"] = Komoot()
    }
}
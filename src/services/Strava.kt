package services

class Strava: Services {
    private val routeString: String = "SRT, CVT, Perkiomen"
    private val routes: ArrayList<String>

    override fun getRoutes(userId: Int?): ArrayList<String> {
        val userString = userId?.toString() ?: ""
        return ArrayList( routes.map { "$userString$it" })
    }

    init {
        routes = ArrayList(routeString.split(", "))
    }
}
package interview.services

class Rwgps: Services {
    private val routeString: String = "CVT, Perkiomen, Welsh Mountain"
    private val routes: ArrayList<String>

    override fun getRoutes(userId: Int?): ArrayList<String> {
        val userString = userId?.toString() ?: ""
        return ArrayList( routes.map { "$it$userString" })
    }

    init {
        routes = ArrayList(routeString.split(", "))
    }
}

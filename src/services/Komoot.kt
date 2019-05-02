package services

class Komoot: Services {
    private val routeString: String = "SRT, Welsh Mountain, Oaks to Philly"
    private val routes: ArrayList<String>

    override fun getRoutes(userId: Int?): ArrayList<String> {
        val userString = userId?.toString() ?: ""
        return ArrayList( routes.map { "$userString$it$userString" })
    }

    init {
        routes = ArrayList(routeString.split(", "))
    }
}
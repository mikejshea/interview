package interview.services

interface Services {
    fun getRoutes(userId: Int? = null): ArrayList<String>
}

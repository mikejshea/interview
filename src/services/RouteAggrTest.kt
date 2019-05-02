import org.junit.jupiter.api.Test
import services.RouteAggr
import kotlin.test.assertTrue

class RouteAggrTest {
    @Test
    fun getRoutesWithNull() {
        val results = RouteAggr().getRoutes()
        val expected = arrayListOf(
            "SRT", "CVT", "Perkiomen",
            "CVT", "Perkiomen", "Welsh Mountain",
            "SRT", "Welsh Mountain", "Oaks to Philly")
        assertTrue(check(results, expected))
    }
    @Test
    fun getRoutesWithUserId() {
        val results = RouteAggr().getRoutes(42)
        val expected = arrayListOf(
            "42SRT", "42CVT", "42Perkiomen",
            "CVT42", "Perkiomen42", "Welsh Mountain42",
            "42SRT42", "42Welsh Mountain42", "42Oaks to Philly42")
        assertTrue(check(results, expected))
    }

    @Test
    fun getUniqueRoutes() {
        val results = RouteAggr().getUniqueRoutes()
        val expected = arrayListOf(
            "SRT", "CVT", "Perkiomen",
            "Welsh Mountain", "Oaks to Philly")
        assertTrue(check(results, expected))
    }

    @Test
    fun getRoutesWithUserIdAndServicesStrava() {
        val results = RouteAggr().getRoutes(42, arrayOf("STRAVA") )
        val expected = arrayListOf(
            "42SRT", "42CVT", "42Perkiomen")
        assertTrue(check(results, expected))
    }
    @Test
    fun getRoutesWithUserIdAndServicesKomoot() {
        val results = RouteAggr().getRoutes(42, arrayOf("Komoot") )
        val expected = arrayListOf(
            "42SRT42", "42Welsh Mountain42", "42Oaks to Philly42")
        assertTrue(check(results, expected))
    }
    @Test
    fun getRoutesWithUserIdAndServicesRwgps() {
        val results = RouteAggr().getRoutes(42, arrayOf("RWGPS") )
        val expected = arrayListOf(
            "CVT42", "Perkiomen42", "Welsh Mountain42")
        assertTrue(check(results, expected))
    }
    @Test
    fun getRoutesWithUserIdAndServicesKommotAndRwgps() {
        val results = RouteAggr().getRoutes(42, arrayOf("Komoot", "RWGPS") )
        val expected = arrayListOf(
            "42SRT42", "42Welsh Mountain42", "42Oaks to Philly42",
            "CVT42", "Perkiomen42", "Welsh Mountain42")
        assertTrue(check(results, expected))
    }
    @Test
    fun getRoutesWithUserIdAndServicesStravaAndKomoot() {
        val results = RouteAggr().getRoutes(42, arrayOf("Strava", "KoMoot") )
        val expected = arrayListOf(
            "42SRT", "42CVT", "42Perkiomen",
            "42SRT42", "42Welsh Mountain42", "42Oaks to Philly42")
        assertTrue(check(results, expected))
    }
    @Test
    fun getRoutesWithUserIdAndServicesRwgpsAndStrava() {
        val results = RouteAggr().getRoutes(42, arrayOf("Strava", "RWgpS") )
        val expected = arrayListOf(
            "42SRT", "42CVT", "42Perkiomen",
            "CVT42", "Perkiomen42", "Welsh Mountain42")
        assertTrue(check(results, expected))
    }
    @Test
    fun getRoutesWithUserIdAndServicesRwgpsAndStravaAndKomoot() {
        val results = RouteAggr().getRoutes(42, arrayOf("Komoot", "RWGPS", "Strava") )
        val expected = arrayListOf(
            "42SRT", "42CVT", "42Perkiomen",
            "42SRT42", "42Welsh Mountain42", "42Oaks to Philly42",
            "CVT42", "Perkiomen42", "Welsh Mountain42")

        assertTrue(check(results, expected))
    }

    private fun check(results: ArrayList<String>, expected: ArrayList<String>): Boolean {
        var result = false
        // First check if size is equal
        if (results.count() == expected.count()) {
            // If size is equal check if minus have zero count
            if (results.minus(expected).count()==0) {
                result = true
            }
        }
        return result
    }
}
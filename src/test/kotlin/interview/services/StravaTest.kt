package interview.services

import org.junit.jupiter.api.Test
import interview.services.Strava
import kotlin.test.assertEquals

class StravaTest {
    @Test
    fun getRoutesWithNull() {
        val results = Strava().getRoutes()
        val expected = arrayListOf("SRT", "CVT", "Perkiomen")
        assertEquals(expected, results)
    }
    @Test
    fun getRoutesWithUserId() {
        val results = Strava().getRoutes(42)
        val expected = arrayListOf("42SRT", "42CVT", "42Perkiomen")
        assertEquals(expected, results)
    }
}

package interview.services

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import interview.services.Komoot

class KomootTest {
    @Test
    fun getRoutesWithNull() {
        val results = Komoot().getRoutes()
        val expected = arrayListOf("SRT", "Welsh Mountain", "Oaks to Philly")
        assertEquals(expected, results)
    }
    @Test
    fun getRoutesWithUserId() {
        val results = Komoot().getRoutes(42)
        val expected = arrayListOf("42SRT42", "42Welsh Mountain42", "42Oaks to Philly42")
        assertEquals(expected, results)
    }
}

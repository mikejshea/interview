package interview.services

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import interview.services.Rwgps

class RwpgsTest {
    @Test
    fun getRoutesWithNull() {
        val results = Rwgps().getRoutes()
        val expected = arrayListOf("CVT", "Perkiomen", "Welsh Mountain")
        assertEquals(expected, results)
    }
    @Test
    fun getRoutesWithUserId() {
        val results = Rwgps().getRoutes(42)
        val expected = arrayListOf("CVT42", "Perkiomen42", "Welsh Mountain42")
        assertEquals(expected, results)
    }
}

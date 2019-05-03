package interview.services

import interview.getUserId
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InterviewTest {
    @Test
    fun getUserIdFromArgsWithInteger() {
        val s = getUserId(arrayOf("35"))
        assertEquals(35, s)
    }
    @Test
    fun getUserIdFromArgsWithNoArgs() {
        val s = getUserId(arrayOf<String>())
        assertEquals(42, s)
    }
    @Test
    fun getUserIdFromArgsWithBadArgs() {
        val s = getUserId(arrayOf("AA"))
        assertEquals(null, s)
    }
    @Test
    fun getUserIdFromArgsWithNegativeInt() {
        val s = getUserId(arrayOf("-11"))
        assertEquals(null, s)
    }
    @Test
    fun getUserIdFromArgsWithZero() {
        val s = getUserId(arrayOf("0"))
        assertEquals(0, s)
    }
    @Test
    fun getUserIdFromArgsWithBigInt() {
        val s = getUserId(arrayOf("2147483648"))
        assertEquals(null, s)
    }
}

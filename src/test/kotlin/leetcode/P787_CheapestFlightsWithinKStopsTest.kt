package leetcode

import io.kotest.matchers.shouldBe
import leetcode.p787.MemoryLimitFlights
import leetcode.p787.timelimit.TimeLimitFlightsPt1.pt1Flights
import leetcode.p787.timelimit.TimeLimitFlightsPt2.pt2Flights
import leetcode.p787.timelimit.TimeLimitFlightsPt3.pt3Flights
import leetcode.p787.timelimit.TimeLimitFlightsPt4.pt4Flights
import leetcode.p787.timelimit.TimeLimitFlightsPt5.pt5Flights
import org.junit.jupiter.api.Test

class P787_CheapestFlightsWithinKStopsTest {
    @Test
    fun `simple test 1`() {
        val actual = P787_CheapestFlightsWithinKStops().findCheapestPrice(
            cities = 4,
            flights = arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 100),
                intArrayOf(2, 0, 100),
                intArrayOf(1, 3, 600),
                intArrayOf(2, 3, 200),
            ),
            src = 0,
            dst = 3,
            maxStops = 1
        )

        actual shouldBe 700
    }

    @Test
    fun `simple test 2`() {
        val actual = P787_CheapestFlightsWithinKStops().findCheapestPrice(
            cities = 3,
            flights = arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 100),
                intArrayOf(0, 2, 500),
            ),
            src = 0,
            dst = 2,
            maxStops = 1
        )

        actual shouldBe 200
    }

    @Test
    fun `simple test 3`() {
        val actual = P787_CheapestFlightsWithinKStops().findCheapestPrice(
            cities = 3,
            flights = arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 100),
                intArrayOf(0, 2, 500),
            ),
            src = 0,
            dst = 2,
            maxStops = 0
        )

        actual shouldBe 500
    }

    @Test
    fun `simple test 4`() {
        val actual = P787_CheapestFlightsWithinKStops().findCheapestPrice(
            cities = 5,
            flights = arrayOf(
                intArrayOf(4, 1, 1),
                intArrayOf(1, 2, 3),
                intArrayOf(0, 3, 2),
                intArrayOf(0, 4, 10),
                intArrayOf(3, 1, 1),
                intArrayOf(1, 4, 3),
            ),
            src = 2,
            dst = 1,
            maxStops = 1
        )

        actual shouldBe -1
    }

    @Test
    fun `test with max stops`() {
        val actual = P787_CheapestFlightsWithinKStops().findCheapestPrice(
            cities = 4,
            flights = arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(0, 2, 5),
                intArrayOf(1, 2, 1),
                intArrayOf(2, 3, 1)
            ),
            src = 0,
            dst = 3,
            maxStops = 1
        )

        actual shouldBe 6
    }

    @Test
    fun `memory limit`() {
        val actual = P787_CheapestFlightsWithinKStops().findCheapestPrice(
            cities = 17,
            flights = MemoryLimitFlights.flights,
            src = 13,
            dst = 4,
            maxStops = 13
        )

        actual shouldBe 47
    }

    @Test
    fun `time limit`() {
        val actual = P787_CheapestFlightsWithinKStops().findCheapestPrice(
            cities = 100,
            flights = pt1Flights + pt2Flights + pt3Flights + pt4Flights + pt5Flights,
            src = 1,
            dst = 99,
            maxStops = 99
        )

        actual shouldBe -1
    }
}

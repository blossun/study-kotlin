package cookbook.ch02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ProductTest {
    @Test
    fun `check all overloads`() {
        assertAll(
            "Overloads called from Kotlin",
            { println(addProduct("Solar", 5.0, "Desc")) },
            { println(addProduct("Solar", 5.0)) },
            { println(addProduct("Solar")) },
        )
    }
}

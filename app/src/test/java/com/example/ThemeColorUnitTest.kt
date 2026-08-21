package com.example

import androidx.compose.ui.graphics.Color
import com.example.ui.theme.Pink40
import com.example.ui.theme.Pink80
import com.example.ui.theme.Purple40
import com.example.ui.theme.Purple80
import com.example.ui.theme.PurpleGrey40
import com.example.ui.theme.PurpleGrey80
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class ThemeColorUnitTest {

    @Test
    fun testColorsAreDistinct() {
        assertNotEquals(Purple80, Purple40)
        assertNotEquals(PurpleGrey80, PurpleGrey40)
        assertNotEquals(Pink80, Pink40)
    }

    @Test
    fun testColorValues() {
        assertEquals(Color(0xFFD0BCFF), Purple80)
        assertEquals(Color(0xFF6650a4), Purple40)
    }
}

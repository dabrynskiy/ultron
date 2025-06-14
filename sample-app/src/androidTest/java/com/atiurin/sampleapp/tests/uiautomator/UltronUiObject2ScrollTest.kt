package com.atiurin.sampleapp.tests.uiautomator

import android.os.Build
import androidx.test.rule.ActivityTestRule
import com.atiurin.sampleapp.activity.MainActivity
import com.atiurin.sampleapp.pages.UiObject2FriendsListPage
import com.atiurin.sampleapp.tests.BaseTest
import com.atiurin.ultron.core.config.UltronConfig
import org.junit.BeforeClass
import org.junit.Test

class UltronUiObject2ScrollTest : BaseTest() {
    init {
        ruleSequence.addLast(ActivityTestRule(MainActivity::class.java))
    }

    companion object {
        @BeforeClass
        @JvmStatic
        fun speedUpAutomator() {
            UltronConfig.UiAutomator.speedUp()
        }
    }

    val page = UiObject2FriendsListPage

    @Test
    fun scrollToBottom() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            for (i in 0..10) {
                if (page.bottomElement.isSuccess { withTimeout(100).isDisplayed() }) break
                page.list.scrollDown(percent = 0.5f)
            }
            page.bottomElement.isDisplayed()
        }
    }

    @Test
    fun scrollToTop() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            for (i in 0..10) {
                if (page.bottomElement.isSuccess { withTimeout(100).isDisplayed() }) break
                page.list.scrollDown(percent = 0.5f)
            }
            page.bottomElement.isDisplayed()
            for (i in 0..10) {
                if (page.topElement.isSuccess { withTimeout(100).isDisplayed() }) break
                page.list.scrollUp(percent = 0.5f)
            }
        }
    }
}
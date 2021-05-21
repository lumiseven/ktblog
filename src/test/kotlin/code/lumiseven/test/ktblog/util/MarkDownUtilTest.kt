package code.lumiseven.test.ktblog.util

import org.junit.jupiter.api.Test

class MarkDownUtilTest {
    @Test
    fun `testMarkDownUtil`() {
        val test = "READ ME"
        val test1 = MarkDownUtil.mdToHtml(test)
        println(test1)
    }
}
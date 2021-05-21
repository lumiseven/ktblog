package code.lumiseven.test.ktblog.service

import code.lumiseven.test.ktblog.entity.BlogTagCount
import code.lumiseven.test.ktblog.util.PageQueryUtil
import code.lumiseven.test.ktblog.util.PageResult

interface TagService {
    /**
     * 查询标签的分页数据
     *
     * @param pageUtil
     * @return
     */
    fun getBlogTagPage(pageUtil: PageQueryUtil): PageResult

    fun getTotalTags(): Int

    fun saveTag(tagName: String): Boolean

    fun deleteBatch(ids: List<Int>): Boolean

    fun getBlogTagCountForIndex(): List<BlogTagCount>
}
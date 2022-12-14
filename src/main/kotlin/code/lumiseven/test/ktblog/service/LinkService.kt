package code.lumiseven.test.ktblog.service

import code.lumiseven.test.ktblog.entity.BlogLink
import code.lumiseven.test.ktblog.util.PageQueryUtil
import code.lumiseven.test.ktblog.util.PageResult

interface LinkService {
    /**
     * 查询友链的分页数据
     *
     * @param pageUtil
     * @return
     */
    fun getBlogLinkPage(pageUtil: PageQueryUtil): PageResult

    fun getTotalLinks(): Int

    fun saveLink(link: BlogLink): Boolean

    fun selectById(id: Int?): BlogLink

    fun updateLink(tempLink: BlogLink): Boolean

    fun deleteBatch(ids: List<Int>): Boolean

    /**
     * 返回友链页面所需的所有数据
     *
     * @return
     */
    fun getLinksForLinkPage(): Map<Byte, List<BlogLink>>
}
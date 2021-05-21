package code.lumiseven.test.ktblog.service.impl

import code.lumiseven.test.ktblog.entity.BlogLink
import code.lumiseven.test.ktblog.repository.BlogLinkDAO
import code.lumiseven.test.ktblog.service.LinkService
import code.lumiseven.test.ktblog.util.PageQueryUtil
import code.lumiseven.test.ktblog.util.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import java.util.stream.Collectors

@Service
class LinkServiceImpl: LinkService {
    @Autowired
    lateinit var blogLinkDAO: BlogLinkDAO

    override fun getBlogLinkPage(pageUtil: PageQueryUtil): PageResult {
        val links = blogLinkDAO.findLinkList(pageUtil)
        val total = blogLinkDAO.getTotalLinks(pageUtil)
        return PageResult(links, total, pageUtil.limit, pageUtil.page)
    }

    override fun getTotalLinks(): Int {
        return blogLinkDAO.getTotalLinks(null)
    }

    override fun saveLink(link: BlogLink): Boolean {
        return blogLinkDAO.insertSelective(link) > 0
    }

    override fun selectById(id: Int?): BlogLink {
        return blogLinkDAO.selectByPrimaryKey(id)
    }

    override fun updateLink(tempLink: BlogLink): Boolean {
        return blogLinkDAO.updateByPrimaryKeySelective(tempLink) > 0
    }

    override fun deleteBatch(ids: List<Int>): Boolean {
        return blogLinkDAO.deleteBatch(ids) > 0
    }

    //todo test
    override fun getLinksForLinkPage(): Map<Byte, List<BlogLink>> {
        //获取所有链接数据
        val links = blogLinkDAO.findLinkList(null)

        return if (links != null && links.isNotEmpty()) {
            //根据type进行分组
            links.groupBy { it.linkType!! }.toMap()
        } else mapOf()
    }
}
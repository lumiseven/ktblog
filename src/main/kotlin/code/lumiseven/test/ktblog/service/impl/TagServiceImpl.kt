package code.lumiseven.test.ktblog.service.impl

import code.lumiseven.test.ktblog.entity.BlogTag
import code.lumiseven.test.ktblog.entity.BlogTagCount
import code.lumiseven.test.ktblog.repository.BlogTagDAO
import code.lumiseven.test.ktblog.repository.BlogTagRelationDAO
import code.lumiseven.test.ktblog.service.TagService
import code.lumiseven.test.ktblog.util.PageQueryUtil
import code.lumiseven.test.ktblog.util.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils

@Service
class TagServiceImpl: TagService {
    @Autowired
    lateinit var blogTagDAO: BlogTagDAO

    @Autowired
    lateinit var relationDAO: BlogTagRelationDAO

    override fun getBlogTagPage(pageUtil: PageQueryUtil): PageResult {
        val tags = blogTagDAO.findTagList(pageUtil)
        val total = blogTagDAO.getTotalTags(pageUtil)
        return PageResult(tags, total, pageUtil.limit, pageUtil.page)
    }

    override fun getTotalTags(): Int {
        return blogTagDAO.getTotalTags(null)
    }

    override fun saveTag(tagName: String): Boolean {
        val temp = blogTagDAO.selectByTagName(tagName)
        if (temp == null) {
            val blogTag = BlogTag()
            blogTag.tagName = tagName
            return blogTagDAO.insertSelective(blogTag) > 0
        }
        return false
    }

    override fun deleteBatch(ids: List<Int>): Boolean {
        //已存在关联关系不删除
        val relations = relationDAO.selectDistinctTagIds(ids)
        return if (!CollectionUtils.isEmpty(relations)) {
            false
        } else blogTagDAO!!.deleteBatch(ids) > 0
        //删除tag
    }

    override fun getBlogTagCountForIndex(): List<BlogTagCount> {
        return blogTagDAO.getTagCount()
    }
}
package code.lumiseven.test.ktblog.service

import code.lumiseven.test.ktblog.entity.BlogCategory
import code.lumiseven.test.ktblog.util.PageQueryUtil
import code.lumiseven.test.ktblog.util.PageResult

interface CategoryService {
    /**
     * 查询分类的分页数据
     *
     * @param pageUtil
     * @return
     */
    fun getBlogCategoryPage(pageUtil: PageQueryUtil): PageResult

    fun getTotalCategories(): Int

    /**
     * 添加分类数据
     *
     * @param categoryName
     * @param categoryIcon
     * @return
     */
    fun saveCategory(categoryName: String, categoryIcon: String): Boolean

    fun updateCategory(categoryId: Int, categoryName: String, categoryIcon: String): Boolean

    fun deleteBatch(ids: List<Int>): Boolean

    fun getAllCategories(): List<BlogCategory>
}
package code.lumiseven.test.ktblog.repository

import code.lumiseven.test.ktblog.entity.BlogCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface BlogCategoryRepository : JpaRepository<BlogCategory, Long>, QuerydslPredicateExecutor<BlogCategory>
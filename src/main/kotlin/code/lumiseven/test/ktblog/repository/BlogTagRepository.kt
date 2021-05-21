package code.lumiseven.test.ktblog.repository

import code.lumiseven.test.ktblog.entity.BlogTag
import code.lumiseven.test.ktblog.entity.BlogTagRelation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface BlogTagRepository : JpaRepository<BlogTag, Long>, QuerydslPredicateExecutor<BlogTag>
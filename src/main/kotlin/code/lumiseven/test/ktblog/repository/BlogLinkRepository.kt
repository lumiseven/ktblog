package code.lumiseven.test.ktblog.repository

import code.lumiseven.test.ktblog.entity.BlogLink
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface BlogLinkRepository : JpaRepository<BlogLink, Long>, QuerydslPredicateExecutor<BlogLink>
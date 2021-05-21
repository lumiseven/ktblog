package code.lumiseven.test.ktblog.repository

import code.lumiseven.test.ktblog.entity.Blog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface BlogRepository : JpaRepository<Blog, Long>, QuerydslPredicateExecutor<Blog>
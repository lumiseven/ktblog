package code.lumiseven.test.ktblog.repository

import code.lumiseven.test.ktblog.entity.BlogComment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface BlogCommentRepository : JpaRepository<BlogComment, Long>, QuerydslPredicateExecutor<BlogComment>
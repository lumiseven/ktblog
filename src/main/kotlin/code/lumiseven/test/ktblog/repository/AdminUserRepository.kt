package code.lumiseven.test.ktblog.repository

import code.lumiseven.test.ktblog.entity.AdminUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface AdminUserRepository : JpaRepository<AdminUser, Long>, QuerydslPredicateExecutor<AdminUser>
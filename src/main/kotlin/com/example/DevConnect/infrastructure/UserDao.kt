package com.example.DevConnect.infrastructure

import org.seasar.doma.Dao
import org.seasar.doma.boot.ConfigAutowireable
import org.springframework.transaction.annotation.Transactional

/**
 * UserDao ユーザーDAO
 */
@Dao
@ConfigAutowireable
@Transactional
interface UserDao {
}
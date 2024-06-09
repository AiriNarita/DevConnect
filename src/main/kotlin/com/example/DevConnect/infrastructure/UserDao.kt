package com.example.DevConnect.infrastructure

import com.example.DevConnect.domain.model.entity.UserEntity
import org.seasar.doma.Dao
import org.seasar.doma.Insert
import org.seasar.doma.boot.ConfigAutowireable
import org.springframework.transaction.annotation.Transactional

/**
 * UserDao ユーザーDAO
 */
@Dao
@ConfigAutowireable
@Transactional
interface UserDao {

    /**
     * ユーザーを作成する
     * @param userEntity ユーザーエンティティ
     * @return ユーザーエンティティ
     */
//    @Insert(sqlFile = true)
//    fun createUser(userEntity: UserEntity): Result<UserEntity>
}
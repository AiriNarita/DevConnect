package com.example.DevConnect.service

import com.example.DevConnect.domain.factory.user.UserFactory
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.repository.user.UserRepository
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import org.seasar.doma.jdbc.Result
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserServise(
    private val userRepository: UserRepository,
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val userEntity = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("ユーザーが見つかりません")

        return org.springframework.security.core.userdetails.User(
            userEntity.username,
            userEntity.password,
            listOf() // 必要に応じてユーザー権限を設定
        )
    }
}

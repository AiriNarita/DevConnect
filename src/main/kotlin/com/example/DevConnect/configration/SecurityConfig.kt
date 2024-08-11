package com.example.DevConnect.configration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

/**
 * SecurityConfig
 */
@Configuration
@EnableWebSecurity
class SecurityConfig{
    /**
     *  パスワードエンコーダーのBean定義
     *  @return PasswordEncoder
     */
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        // パスワードの暗号化用に、BCrypt(ビー・クリプト)を使用
        return BCryptPasswordEncoder()
    }

    /**
     * セキュリティフィルターチェーンのBean定義
     */
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        // アクセス権限の設定
        http
            .authorizeHttpRequests { requests ->
                // 特定のURLパターンに対するアクセス権限の設定
                requests
                    // ログインページと登録ページは、全てのユーザーにアクセスを許可(認証不要なURL)
                    .requestMatchers("/login", "/register").permitAll()
                    // それ以外のすべてのリクエストは認証が必要
                    .anyRequest().authenticated()
            }
            .formLogin { form ->
                // フォームベースの認証の設定
                form
                    // 認証を行わないリクエストも許可
                    .permitAll()
            }
            .logout { logout ->
                // ログアウトに関する設定
                // ログアウトリクエストは認証を必要とせず、全てのユーザーがアクセス可能
                logout.permitAll()
            }
        // 設定したHttpSecurityオブジェクトを構築し、セキュリティフィルターチェーンを返す
        return http.build()
    }
}
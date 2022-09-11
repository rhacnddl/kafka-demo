package org.gorany.kafkademo.dto.user.request

import org.gorany.kafkademo.entity.User

data class RequestCreateUser(
    val email: String,
    val password: String,
    val nickname: String,
) {
    companion object {
        fun from(request: RequestCreateUser) = User(
            email = request.email,
            password = request.password,
            nickname = request.nickname
        )
    }
}
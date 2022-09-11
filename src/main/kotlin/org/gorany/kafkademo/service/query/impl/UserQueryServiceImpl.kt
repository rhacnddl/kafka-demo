package org.gorany.kafkademo.service.query.impl

import org.gorany.kafkademo.repository.UserRepository
import org.gorany.kafkademo.service.query.UserQueryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserQueryServiceImpl(
    val userRepository: UserRepository,
): UserQueryService {

    override fun isExist(email: String): Boolean = when {
        userRepository.findByEmail(email).isPresent -> true
        else -> false
    }
}
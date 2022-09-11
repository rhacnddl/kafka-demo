package org.gorany.kafkademo.service.command.impl

import org.gorany.kafkademo.dto.user.request.RequestCreateUser
import org.gorany.kafkademo.repository.UserRepository
import org.gorany.kafkademo.service.command.UserCommandService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = false)
class UserCommandServiceImpl(
    val userRepository: UserRepository,
): UserCommandService {

    override fun create(request: RequestCreateUser): Long = userRepository.save(RequestCreateUser.from(request)).id
}
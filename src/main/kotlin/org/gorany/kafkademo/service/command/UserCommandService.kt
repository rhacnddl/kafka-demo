package org.gorany.kafkademo.service.command

import org.gorany.kafkademo.dto.user.request.RequestCreateUser

interface UserCommandService {

    fun create(request: RequestCreateUser): Long
}
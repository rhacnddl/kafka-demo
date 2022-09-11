package org.gorany.kafkademo.kafka.producer

import org.gorany.kafkademo.dto.user.request.RequestCreateUser

interface CreateUserProducer {

    fun produce(request: RequestCreateUser)
}
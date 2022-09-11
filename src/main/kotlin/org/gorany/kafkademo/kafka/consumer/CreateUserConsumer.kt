package org.gorany.kafkademo.kafka.consumer

import org.springframework.messaging.handler.annotation.Payload

interface CreateUserConsumer {

    fun consume(message: String)
}
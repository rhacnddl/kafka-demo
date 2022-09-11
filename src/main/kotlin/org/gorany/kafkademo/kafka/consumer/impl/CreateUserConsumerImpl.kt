package org.gorany.kafkademo.kafka.consumer.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.gorany.kafkademo.dto.user.request.RequestCreateUser
import org.gorany.kafkademo.kafka.consumer.CreateUserConsumer
import org.gorany.kafkademo.service.command.UserCommandService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class CreateUserConsumerImpl(
    val userCommandService: UserCommandService,
): CreateUserConsumer {

    companion object {
        private val log = LoggerFactory.getLogger(Logger::class.java)

        val mapper: ObjectMapper = jacksonObjectMapper()
    }

    @KafkaListener(topics = ["\${spring.kafka.consumer.topic.create-user}"])
    override fun consume(@Payload message: String) {
        log.info("[Consumer][Create User] message : $message")

        val request = mapper.readValue(message, RequestCreateUser::class.java)

        userCommandService.create(request)
    }
}
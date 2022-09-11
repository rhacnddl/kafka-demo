package org.gorany.kafkademo.kafka.producer.impl

import org.gorany.kafkademo.dto.user.request.RequestCreateUser
import org.gorany.kafkademo.kafka.producer.CreateUserProducer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CreateUserProducerImpl(
    val kafkaTemplate: KafkaTemplate<String, Any>,
    @Value("\${spring.kafka.consumer.topic.create-user}") val topic: String,
): CreateUserProducer {

    companion object {
        private val log = LoggerFactory.getLogger(Logger::class.java)
    }

    override fun produce(request: RequestCreateUser) {
        log.info("[Producer][Create User] request: $request")

        kafkaTemplate.send(topic, request.email, request)
    }
}
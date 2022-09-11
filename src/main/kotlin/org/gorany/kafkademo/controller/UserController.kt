package org.gorany.kafkademo.controller

import org.gorany.kafkademo.dto.user.request.RequestCreateUser
import org.gorany.kafkademo.kafka.producer.CreateUserProducer
import org.gorany.kafkademo.service.query.UserQueryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    val createUserProducer: CreateUserProducer,
    val userQueryService: UserQueryService,
) {

    @PostMapping("/api/v1/users/create")
    fun createUser(@RequestBody request: RequestCreateUser): ResponseEntity<*> {

        if (isExistUser(request.email)) {
            return ResponseEntity("이미 ${request.email}로 등록된 계정이 있습니다.", HttpStatus.BAD_REQUEST)
        }

        createUserProducer.produce(request)
        return ResponseEntity("success", HttpStatus.OK)
    }

    private fun isExistUser(email: String): Boolean = userQueryService.isExist(email)
}
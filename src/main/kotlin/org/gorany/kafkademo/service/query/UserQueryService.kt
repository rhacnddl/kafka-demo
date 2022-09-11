package org.gorany.kafkademo.service.query

interface UserQueryService {

    fun isExist(email: String): Boolean
}
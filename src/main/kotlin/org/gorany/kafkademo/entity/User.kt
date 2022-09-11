package org.gorany.kafkademo.entity

import org.gorany.kafkademo.entity.base.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val email: String,
    val password: String,
    val nickname: String,
): BaseEntity() {
}
package org.gorany.kafkademo.entity.base

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false, columnDefinition = "DATE")
    var createdDate: LocalDateTime = LocalDateTime.now()
        protected set

    @LastModifiedDate
    @Column(name = "updated_date", columnDefinition = "DATE")
    var updatedDate: LocalDateTime? = null
        protected set
}
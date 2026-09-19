package com.riskflow.customer.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Generated
import java.util.UUID
import java.time.Instant

@Entity
@Table(name = "customers")
class Customer(
    @Column(name = "first_name", nullable = false, length = 50)
    val firstName: String,

    @Column(name = "last_name", nullable = false, length = 50)
    val lastName: String,

    @Column(nullable = false, unique = true, length = 150)
    val email: String,

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    val id: UUID? = null,

    @Generated
    @Column(
        name = "created_at",
        nullable = false,
        insertable = false,
        updatable = false
    )
    val createdAt: Instant? = null
)

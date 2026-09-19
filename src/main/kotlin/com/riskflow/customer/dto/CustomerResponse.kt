package com.riskflow.customer.dto

import java.util.UUID
import java.time.Instant

data class CustomerResponse(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val createdAt: Instant
    )
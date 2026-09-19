package com.riskflow.customer.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateCustomerRequest(

    @field:NotBlank
    @field:Size(max = 50)
    val firstName: String,

    @field:NotBlank
    @field:Size(max = 50)
    val lastName: String,

    @field:NotBlank
    @field:Email
    @field:Size(max = 150)
    val email: String,
)
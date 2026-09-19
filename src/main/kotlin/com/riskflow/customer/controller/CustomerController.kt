package com.riskflow.customer.controller

import com.riskflow.customer.dto.CreateCustomerRequest
import com.riskflow.customer.dto.CustomerResponse
import com.riskflow.customer.service.CustomerService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(
    private val customerService: CustomerService
) {
    @PostMapping
    fun createCustomer(@Valid @RequestBody request: CreateCustomerRequest
    ): ResponseEntity<CustomerResponse> {
        val customer = customerService.createCustomer(request)

        return ResponseEntity.status(HttpStatus.CREATED).body(customer)
    }
}
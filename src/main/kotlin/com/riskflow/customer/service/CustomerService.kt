package com.riskflow.customer.service

import com.riskflow.customer.dto.CreateCustomerRequest
import com.riskflow.customer.dto.CustomerResponse
import com.riskflow.customer.model.Customer
import com.riskflow.customer.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {

    @Transactional
    fun createCustomer(userRequest: CreateCustomerRequest): CustomerResponse {
        val customer = Customer(
            firstName = userRequest.firstName,
            lastName = userRequest.lastName,
            email = userRequest.email
        )

        val savedCustomer = customerRepository.saveAndFlush(customer)

        return CustomerResponse(
            id = requireNotNull(savedCustomer.id),
            firstName = savedCustomer.firstName,
            lastName = savedCustomer.lastName,
            email = savedCustomer.email,
            createdAt = requireNotNull(savedCustomer.createdAt)
        )
    }
}
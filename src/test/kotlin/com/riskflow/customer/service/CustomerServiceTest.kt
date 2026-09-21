package com.riskflow.customer.service

import com.riskflow.customer.dto.CreateCustomerRequest
import com.riskflow.customer.model.Customer
import com.riskflow.customer.repository.CustomerRepository
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import java.time.Instant
import java.util.UUID
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@ExtendWith(MockKExtension::class)
class CustomerServiceTest {

    @MockK
    lateinit var customerRepository: CustomerRepository

    private lateinit var customerService: CustomerService

    @BeforeEach
    fun setUp() {
        customerService = CustomerService(customerRepository)
    }

    private val customerId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000")

    private val createdAt = Instant.parse("2026-09-21T12:00:00Z")

    @Test
    fun `should create new customer`() {

        //Arrange
        val customerRequest = CreateCustomerRequest(
            "John", "Doe", "john.doe@email.com"
        )

        val savedCustomer = Customer(
            firstName = "John",
            lastName = "Doe",
            email = "john.doe@email.com",
            id = customerId,
            createdAt = createdAt
        )

        every {
            customerRepository.saveAndFlush(any<Customer>())
        } returns savedCustomer

        //Act
        val actual = customerService.createCustomer(customerRequest)

        //Assert
        assertEquals(customerId, actual.id)
        assertEquals("John", actual.firstName)
        assertEquals("Doe", actual.lastName)
        assertEquals("john.doe@email.com", actual.email)
        assertEquals(createdAt, actual.createdAt)

        verify(exactly = 1) {
            customerRepository.saveAndFlush(any<Customer>())
        }

    }

}
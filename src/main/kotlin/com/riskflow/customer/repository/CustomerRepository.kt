package com.riskflow.customer.repository

import com.riskflow.customer.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CustomerRepository: JpaRepository<Customer, UUID> {

}
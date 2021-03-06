package com.aeon.api.module.customerregistration.models.dtos

import com.aeon.api.module.customerregistration.database.entities.Customer
import com.aeon.api.module.customerregistration.models.utils.DataUtils
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

data class CustomerDTO(
    @JsonProperty("customerId")
    val customerId: UUID? = null,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("cpf")
    val cpf: String,

    @JsonProperty("email")
    val email: String,

    @JsonProperty("age")
    val age: Int? = null

) : Serializable {

    constructor(customer: Customer): this(
        customerId = customer.customerId,
        name = customer.name,
        cpf = customer.cpf,
        email = customer.email,
        age = DataUtils().getCustomerAge(customer.birthDate)
    )
}


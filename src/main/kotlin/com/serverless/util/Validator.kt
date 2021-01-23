package com.serverless.util

import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

object Validator {
    fun validator(): Validator {
        val factory: ValidatorFactory = Validation.buildDefaultValidatorFactory()
        return factory.validator
    }
}
package com.clairvoyantcoding.projecttrackerapi.error

import java.util.*

data class ErrorDetails(val date: Date, val restExceptionMessage: String, val detailedExceptionMessage: String)

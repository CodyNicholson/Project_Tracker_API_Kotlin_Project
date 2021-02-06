package com.clairvoyantcoding.projecttrackerapi.error

import com.clairvoyantcoding.projecttrackerapi.ProjecttrackerapiApplication
import com.clairvoyantcoding.projecttrackerapi.constant.Constants.RestErrorMessages
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.util.*

@ControllerAdvice
class ControllerExceptionHandler {
    private val logger: Logger = LoggerFactory.getLogger(ProjecttrackerapiApplication::class.java)

    @ExceptionHandler(value = [BadRequestException::class])
    protected fun handleBadRequestException(ex: Exception, request: WebRequest?): ResponseEntity<ErrorDetails?>? {
        logger.error(RestErrorMessages.BAD_REQUEST_MESSAGE, ex)
        val errorDetails = ErrorDetails(
                Date(),
                RestErrorMessages.BAD_REQUEST_MESSAGE,
                ex.localizedMessage)
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    protected fun handleUnauthorizedException(ex: Exception, request: WebRequest?): ResponseEntity<ErrorDetails?>? {
        logger.error(RestErrorMessages.UNAUTHORIZED_MESSAGE, ex)
        val errorDetails = ErrorDetails(
                Date(),
                RestErrorMessages.UNAUTHORIZED_MESSAGE,
                ex.localizedMessage)
        return ResponseEntity(errorDetails, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(value = [ForbiddenException::class])
    protected fun handleForbiddenException(ex: Exception, request: WebRequest?): ResponseEntity<ErrorDetails?>? {
        logger.error(RestErrorMessages.FORBIDDEN_MESSAGE, ex)
        val errorDetails = ErrorDetails(
                Date(),
                RestErrorMessages.FORBIDDEN_MESSAGE,
                ex.localizedMessage)
        return ResponseEntity(errorDetails, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(value = [NotFoundException::class])
    protected fun handleNotFoundException(ex: Exception, request: WebRequest?): ResponseEntity<ErrorDetails?>? {
        logger.error(RestErrorMessages.NOT_FOUND_MESSAGE, ex)
        val errorDetails = ErrorDetails(
                Date(),
                RestErrorMessages.NOT_FOUND_MESSAGE,
                ex.localizedMessage)
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [ConflictException::class])
    protected fun handleConflictException(ex: Exception, request: WebRequest?): ResponseEntity<ErrorDetails?>? {
        logger.error(RestErrorMessages.CONFLICT_MESSAGE, ex)
        val errorDetails = ErrorDetails(
                Date(),
                RestErrorMessages.CONFLICT_MESSAGE,
                ex.localizedMessage)
        return ResponseEntity(errorDetails, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(value = [InternalServerErrorException::class, RuntimeException::class])
    protected fun handleInternalServerError(ex: Exception, request: WebRequest?): ResponseEntity<ErrorDetails?>? {
        logger.error(RestErrorMessages.INTERNAL_SERVER_ERROR_MESSAGE, ex)
        val errorDetails = ErrorDetails(
                Date(),
                RestErrorMessages.INTERNAL_SERVER_ERROR_MESSAGE,
                ex.localizedMessage)
        return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [ServiceUnavailableException::class])
    protected fun handleServiceUnavailableError(ex: Exception, request: WebRequest?): ResponseEntity<ErrorDetails?>? {
        logger.error(RestErrorMessages.SERVICE_UNAVAILABLE_MESSAGE, ex)
        val errorDetails = ErrorDetails(
                Date(),
                RestErrorMessages.SERVICE_UNAVAILABLE_MESSAGE,
                ex.localizedMessage)
        return ResponseEntity(errorDetails, HttpStatus.SERVICE_UNAVAILABLE)
    }
}

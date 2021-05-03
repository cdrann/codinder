package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InterestedInGenderController {

    InterestedInGenderService interestedInGenderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond interestedInGenderService.list(params), model:[interestedInGenderCount: interestedInGenderService.count()]
    }

    def show(Long id) {
        respond interestedInGenderService.get(id)
    }

    def create() {
        respond new InterestedInGender(params)
    }

    def save(InterestedInGender interestedInGender) {
        if (interestedInGender == null) {
            notFound()
            return
        }

        try {
            interestedInGenderService.save(interestedInGender)
        } catch (ValidationException e) {
            respond interestedInGender.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'interestedInGender.label', default: 'InterestedInGender'), interestedInGender.id])
                redirect interestedInGender
            }
            '*' { respond interestedInGender, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond interestedInGenderService.get(id)
    }

    def update(InterestedInGender interestedInGender) {
        if (interestedInGender == null) {
            notFound()
            return
        }

        try {
            interestedInGenderService.save(interestedInGender)
        } catch (ValidationException e) {
            respond interestedInGender.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'interestedInGender.label', default: 'InterestedInGender'), interestedInGender.id])
                redirect interestedInGender
            }
            '*'{ respond interestedInGender, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        interestedInGenderService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'interestedInGender.label', default: 'InterestedInGender'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'interestedInGender.label', default: 'InterestedInGender'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

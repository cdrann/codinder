package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InterestedInTechController {

    InterestedInTechService interestedInTechService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond interestedInTechService.list(params), model:[interestedInTechCount: interestedInTechService.count()]
    }

    def show(Long id) {
        respond interestedInTechService.get(id)
    }

    def create() {
        respond new InterestedInTech(params)
    }

    def save(InterestedInTech interestedInTech) {
        if (interestedInTech == null) {
            notFound()
            return
        }

        try {
            interestedInTechService.save(interestedInTech)
        } catch (ValidationException e) {
            respond interestedInTech.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'interestedInTech.label', default: 'InterestedInTech'), interestedInTech.id])
                redirect interestedInTech
            }
            '*' { respond interestedInTech, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond interestedInTechService.get(id)
    }

    def update(InterestedInTech interestedInTech) {
        if (interestedInTech == null) {
            notFound()
            return
        }

        try {
            interestedInTechService.save(interestedInTech)
        } catch (ValidationException e) {
            respond interestedInTech.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'interestedInTech.label', default: 'InterestedInTech'), interestedInTech.id])
                redirect interestedInTech
            }
            '*'{ respond interestedInTech, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        interestedInTechService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'interestedInTech.label', default: 'InterestedInTech'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'interestedInTech.label', default: 'InterestedInTech'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

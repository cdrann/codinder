package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InterestedInRelationController {

    InterestedInRelationService interestedInRelationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond interestedInRelationService.list(params), model:[interestedInRelationCount: interestedInRelationService.count()]
    }

    def show(Long id) {
        respond interestedInRelationService.get(id)
    }

    def create() {
        respond new InterestedInRelation(params)
    }

    def save(InterestedInRelation interestedInRelation) {
        if (interestedInRelation == null) {
            notFound()
            return
        }

        try {
            interestedInRelationService.save(interestedInRelation)
        } catch (ValidationException e) {
            respond interestedInRelation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'interestedInRelation.label', default: 'InterestedInRelation'), interestedInRelation.id])
                redirect interestedInRelation
            }
            '*' { respond interestedInRelation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond interestedInRelationService.get(id)
    }

    def update(InterestedInRelation interestedInRelation) {
        if (interestedInRelation == null) {
            notFound()
            return
        }

        try {
            interestedInRelationService.save(interestedInRelation)
        } catch (ValidationException e) {
            respond interestedInRelation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'interestedInRelation.label', default: 'InterestedInRelation'), interestedInRelation.id])
                redirect interestedInRelation
            }
            '*'{ respond interestedInRelation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        interestedInRelationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'interestedInRelation.label', default: 'InterestedInRelation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'interestedInRelation.label', default: 'InterestedInRelation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

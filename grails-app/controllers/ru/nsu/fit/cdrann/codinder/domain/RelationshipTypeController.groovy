package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RelationshipTypeController {

    RelationshipTypeService relationshipTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond relationshipTypeService.list(params), model:[relationshipTypeCount: relationshipTypeService.count()]
    }

    def show(Long id) {
        respond relationshipTypeService.get(id)
    }

    def create() {
        respond new RelationshipType(params)
    }

    def save(RelationshipType relationshipType) {
        if (relationshipType == null) {
            notFound()
            return
        }

        try {
            relationshipTypeService.save(relationshipType)
        } catch (ValidationException e) {
            respond relationshipType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'relationshipType.label', default: 'RelationshipType'), relationshipType.id])
                redirect relationshipType
            }
            '*' { respond relationshipType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond relationshipTypeService.get(id)
    }

    def update(RelationshipType relationshipType) {
        if (relationshipType == null) {
            notFound()
            return
        }

        try {
            relationshipTypeService.save(relationshipType)
        } catch (ValidationException e) {
            respond relationshipType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'relationshipType.label', default: 'RelationshipType'), relationshipType.id])
                redirect relationshipType
            }
            '*'{ respond relationshipType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        relationshipTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'relationshipType.label', default: 'RelationshipType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'relationshipType.label', default: 'RelationshipType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

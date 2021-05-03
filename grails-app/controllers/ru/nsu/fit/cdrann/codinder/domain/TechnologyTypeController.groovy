package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TechnologyTypeController {

    TechnologyTypeService technologyTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond technologyTypeService.list(params), model:[technologyTypeCount: technologyTypeService.count()]
    }

    def show(Long id) {
        respond technologyTypeService.get(id)
    }

    def create() {
        respond new TechnologyType(params)
    }

    def save(TechnologyType technologyType) {
        if (technologyType == null) {
            notFound()
            return
        }

        try {
            technologyTypeService.save(technologyType)
        } catch (ValidationException e) {
            respond technologyType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'technologyType.label', default: 'TechnologyType'), technologyType.id])
                redirect technologyType
            }
            '*' { respond technologyType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond technologyTypeService.get(id)
    }

    def update(TechnologyType technologyType) {
        if (technologyType == null) {
            notFound()
            return
        }

        try {
            technologyTypeService.save(technologyType)
        } catch (ValidationException e) {
            respond technologyType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'technologyType.label', default: 'TechnologyType'), technologyType.id])
                redirect technologyType
            }
            '*'{ respond technologyType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        technologyTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'technologyType.label', default: 'TechnologyType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'technologyType.label', default: 'TechnologyType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

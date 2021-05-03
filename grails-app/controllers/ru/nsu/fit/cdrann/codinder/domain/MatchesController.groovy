package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MatchesController {

    MatchesService matchesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond matchesService.list(params), model:[matchesCount: matchesService.count()]
    }

    def show(Long id) {
        respond matchesService.get(id)
    }

    def create() {
        respond new Matches(params)
    }

    def save(Matches matches) {
        if (matches == null) {
            notFound()
            return
        }

        try {
            matchesService.save(matches)
        } catch (ValidationException e) {
            respond matches.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'matches.label', default: 'Matches'), matches.id])
                redirect matches
            }
            '*' { respond matches, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond matchesService.get(id)
    }

    def update(Matches matches) {
        if (matches == null) {
            notFound()
            return
        }

        try {
            matchesService.save(matches)
        } catch (ValidationException e) {
            respond matches.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'matches.label', default: 'Matches'), matches.id])
                redirect matches
            }
            '*'{ respond matches, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        matchesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'matches.label', default: 'Matches'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'matches.label', default: 'Matches'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

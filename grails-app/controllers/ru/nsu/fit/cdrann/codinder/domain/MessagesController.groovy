package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MessagesController {

    MessagesService messagesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond messagesService.list(params), model:[messagesCount: messagesService.count()]
    }

    def show(Long id) {
        respond messagesService.get(id)
    }

    def create() {
        respond new Messages(params)
    }

    def save(Messages messages) {
        if (messages == null) {
            notFound()
            return
        }

        try {
            messagesService.save(messages)
        } catch (ValidationException e) {
            respond messages.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'messages.label', default: 'Messages'), messages.id])
                redirect messages
            }
            '*' { respond messages, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond messagesService.get(id)
    }

    def update(Messages messages) {
        if (messages == null) {
            notFound()
            return
        }

        try {
            messagesService.save(messages)
        } catch (ValidationException e) {
            respond messages.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'messages.label', default: 'Messages'), messages.id])
                redirect messages
            }
            '*'{ respond messages, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        messagesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'messages.label', default: 'Messages'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'messages.label', default: 'Messages'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

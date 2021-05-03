package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ConversationController {

    ConversationService conversationService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond conversationService.list(params), model:[conversationCount: conversationService.count()]
    }

    def show(Long id) {
        respond conversationService.get(id)
    }

    def create() {
        respond new Conversation(params)
    }

    def save(Conversation conversation) {
        if (conversation == null) {
            notFound()
            return
        }

        try {
            conversationService.save(conversation)
        } catch (ValidationException e) {
            respond conversation.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'conversation.label', default: 'Conversation'), conversation.id])
                redirect conversation
            }
            '*' { respond conversation, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond conversationService.get(id)
    }

    def update(Conversation conversation) {
        if (conversation == null) {
            notFound()
            return
        }

        try {
            conversationService.save(conversation)
        } catch (ValidationException e) {
            respond conversation.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'conversation.label', default: 'Conversation'), conversation.id])
                redirect conversation
            }
            '*'{ respond conversation, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        conversationService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'conversation.label', default: 'Conversation'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'conversation.label', default: 'Conversation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

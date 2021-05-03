package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserAccountController {

    UserAccountService userAccountService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userAccountService.list(params), model:[userAccountCount: userAccountService.count()]
    }

    def show(Long id) {
        respond userAccountService.get(id)
    }

    def create() {
        respond new UserAccount(params)
    }

    def save(UserAccount userAccount) {
        if (userAccount == null) {
            notFound()
            return
        }

        try {
            userAccountService.save(userAccount)
        } catch (ValidationException e) {
            respond userAccount.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'userAccount.label', default: 'UserAccount'), userAccount.id])
                redirect userAccount
            }
            '*' { respond userAccount, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond userAccountService.get(id)
    }

    def update(UserAccount userAccount) {
        if (userAccount == null) {
            notFound()
            return
        }

        try {
            userAccountService.save(userAccount)
        } catch (ValidationException e) {
            respond userAccount.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'userAccount.label', default: 'UserAccount'), userAccount.id])
                redirect userAccount
            }
            '*'{ respond userAccount, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        userAccountService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'userAccount.label', default: 'UserAccount'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'userAccount.label', default: 'UserAccount'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package ru.nsu.fit.cdrann.codinder.domain

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InterestedInPeopleFromCityController {

    InterestedInPeopleFromCityService interestedInPeopleFromCityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond interestedInPeopleFromCityService.list(params), model:[interestedInPeopleFromCityCount: interestedInPeopleFromCityService.count()]
    }

    def show(Long id) {
        respond interestedInPeopleFromCityService.get(id)
    }

    def create() {
        respond new InterestedInPeopleFromCity(params)
    }

    def save(InterestedInPeopleFromCity interestedInPeopleFromCity) {
        if (interestedInPeopleFromCity == null) {
            notFound()
            return
        }

        try {
            interestedInPeopleFromCityService.save(interestedInPeopleFromCity)
        } catch (ValidationException e) {
            respond interestedInPeopleFromCity.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'interestedInPeopleFromCity.label', default: 'InterestedInPeopleFromCity'), interestedInPeopleFromCity.id])
                redirect interestedInPeopleFromCity
            }
            '*' { respond interestedInPeopleFromCity, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond interestedInPeopleFromCityService.get(id)
    }

    def update(InterestedInPeopleFromCity interestedInPeopleFromCity) {
        if (interestedInPeopleFromCity == null) {
            notFound()
            return
        }

        try {
            interestedInPeopleFromCityService.save(interestedInPeopleFromCity)
        } catch (ValidationException e) {
            respond interestedInPeopleFromCity.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'interestedInPeopleFromCity.label', default: 'InterestedInPeopleFromCity'), interestedInPeopleFromCity.id])
                redirect interestedInPeopleFromCity
            }
            '*'{ respond interestedInPeopleFromCity, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        interestedInPeopleFromCityService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'interestedInPeopleFromCity.label', default: 'InterestedInPeopleFromCity'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'interestedInPeopleFromCity.label', default: 'InterestedInPeopleFromCity'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

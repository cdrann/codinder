package ru.nsu.fit.cdrann.codinder.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InterestedInGenderServiceSpec extends Specification {

    InterestedInGenderService interestedInGenderService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InterestedInGender(...).save(flush: true, failOnError: true)
        //new InterestedInGender(...).save(flush: true, failOnError: true)
        //InterestedInGender interestedInGender = new InterestedInGender(...).save(flush: true, failOnError: true)
        //new InterestedInGender(...).save(flush: true, failOnError: true)
        //new InterestedInGender(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //interestedInGender.id
    }

    void "test get"() {
        setupData()

        expect:
        interestedInGenderService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InterestedInGender> interestedInGenderList = interestedInGenderService.list(max: 2, offset: 2)

        then:
        interestedInGenderList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        interestedInGenderService.count() == 5
    }

    void "test delete"() {
        Long interestedInGenderId = setupData()

        expect:
        interestedInGenderService.count() == 5

        when:
        interestedInGenderService.delete(interestedInGenderId)
        sessionFactory.currentSession.flush()

        then:
        interestedInGenderService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InterestedInGender interestedInGender = new InterestedInGender()
        interestedInGenderService.save(interestedInGender)

        then:
        interestedInGender.id != null
    }
}

package ru.nsu.fit.cdrann.codinder.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InterestedInPeopleFromCityServiceSpec extends Specification {

    InterestedInPeopleFromCityService interestedInPeopleFromCityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InterestedInPeopleFromCity(...).save(flush: true, failOnError: true)
        //new InterestedInPeopleFromCity(...).save(flush: true, failOnError: true)
        //InterestedInPeopleFromCity interestedInPeopleFromCity = new InterestedInPeopleFromCity(...).save(flush: true, failOnError: true)
        //new InterestedInPeopleFromCity(...).save(flush: true, failOnError: true)
        //new InterestedInPeopleFromCity(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //interestedInPeopleFromCity.id
    }

    void "test get"() {
        setupData()

        expect:
        interestedInPeopleFromCityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InterestedInPeopleFromCity> interestedInPeopleFromCityList = interestedInPeopleFromCityService.list(max: 2, offset: 2)

        then:
        interestedInPeopleFromCityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        interestedInPeopleFromCityService.count() == 5
    }

    void "test delete"() {
        Long interestedInPeopleFromCityId = setupData()

        expect:
        interestedInPeopleFromCityService.count() == 5

        when:
        interestedInPeopleFromCityService.delete(interestedInPeopleFromCityId)
        sessionFactory.currentSession.flush()

        then:
        interestedInPeopleFromCityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InterestedInPeopleFromCity interestedInPeopleFromCity = new InterestedInPeopleFromCity()
        interestedInPeopleFromCityService.save(interestedInPeopleFromCity)

        then:
        interestedInPeopleFromCity.id != null
    }
}

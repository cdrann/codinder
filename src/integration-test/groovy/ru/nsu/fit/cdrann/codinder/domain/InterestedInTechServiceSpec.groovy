package ru.nsu.fit.cdrann.codinder.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InterestedInTechServiceSpec extends Specification {

    InterestedInTechService interestedInTechService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InterestedInTech(...).save(flush: true, failOnError: true)
        //new InterestedInTech(...).save(flush: true, failOnError: true)
        //InterestedInTech interestedInTech = new InterestedInTech(...).save(flush: true, failOnError: true)
        //new InterestedInTech(...).save(flush: true, failOnError: true)
        //new InterestedInTech(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //interestedInTech.id
    }

    void "test get"() {
        setupData()

        expect:
        interestedInTechService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InterestedInTech> interestedInTechList = interestedInTechService.list(max: 2, offset: 2)

        then:
        interestedInTechList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        interestedInTechService.count() == 5
    }

    void "test delete"() {
        Long interestedInTechId = setupData()

        expect:
        interestedInTechService.count() == 5

        when:
        interestedInTechService.delete(interestedInTechId)
        sessionFactory.currentSession.flush()

        then:
        interestedInTechService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InterestedInTech interestedInTech = new InterestedInTech()
        interestedInTechService.save(interestedInTech)

        then:
        interestedInTech.id != null
    }
}

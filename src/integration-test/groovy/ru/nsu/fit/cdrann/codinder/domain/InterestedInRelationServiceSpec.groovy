package ru.nsu.fit.cdrann.codinder.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InterestedInRelationServiceSpec extends Specification {

    InterestedInRelationService interestedInRelationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InterestedInRelation(...).save(flush: true, failOnError: true)
        //new InterestedInRelation(...).save(flush: true, failOnError: true)
        //InterestedInRelation interestedInRelation = new InterestedInRelation(...).save(flush: true, failOnError: true)
        //new InterestedInRelation(...).save(flush: true, failOnError: true)
        //new InterestedInRelation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //interestedInRelation.id
    }

    void "test get"() {
        setupData()

        expect:
        interestedInRelationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InterestedInRelation> interestedInRelationList = interestedInRelationService.list(max: 2, offset: 2)

        then:
        interestedInRelationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        interestedInRelationService.count() == 5
    }

    void "test delete"() {
        Long interestedInRelationId = setupData()

        expect:
        interestedInRelationService.count() == 5

        when:
        interestedInRelationService.delete(interestedInRelationId)
        sessionFactory.currentSession.flush()

        then:
        interestedInRelationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InterestedInRelation interestedInRelation = new InterestedInRelation()
        interestedInRelationService.save(interestedInRelation)

        then:
        interestedInRelation.id != null
    }
}

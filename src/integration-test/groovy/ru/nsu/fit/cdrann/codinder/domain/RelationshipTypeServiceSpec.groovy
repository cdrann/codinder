package ru.nsu.fit.cdrann.codinder.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RelationshipTypeServiceSpec extends Specification {

    RelationshipTypeService relationshipTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new RelationshipType(...).save(flush: true, failOnError: true)
        //new RelationshipType(...).save(flush: true, failOnError: true)
        //RelationshipType relationshipType = new RelationshipType(...).save(flush: true, failOnError: true)
        //new RelationshipType(...).save(flush: true, failOnError: true)
        //new RelationshipType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //relationshipType.id
    }

    void "test get"() {
        setupData()

        expect:
        relationshipTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<RelationshipType> relationshipTypeList = relationshipTypeService.list(max: 2, offset: 2)

        then:
        relationshipTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        relationshipTypeService.count() == 5
    }

    void "test delete"() {
        Long relationshipTypeId = setupData()

        expect:
        relationshipTypeService.count() == 5

        when:
        relationshipTypeService.delete(relationshipTypeId)
        sessionFactory.currentSession.flush()

        then:
        relationshipTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        RelationshipType relationshipType = new RelationshipType()
        relationshipTypeService.save(relationshipType)

        then:
        relationshipType.id != null
    }
}

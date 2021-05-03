package ru.nsu.fit.cdrann.codinder.domain

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BlockUserServiceSpec extends Specification {

    BlockUserService blockUserService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new BlockUser(...).save(flush: true, failOnError: true)
        //new BlockUser(...).save(flush: true, failOnError: true)
        //BlockUser blockUser = new BlockUser(...).save(flush: true, failOnError: true)
        //new BlockUser(...).save(flush: true, failOnError: true)
        //new BlockUser(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //blockUser.id
    }

    void "test get"() {
        setupData()

        expect:
        blockUserService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<BlockUser> blockUserList = blockUserService.list(max: 2, offset: 2)

        then:
        blockUserList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        blockUserService.count() == 5
    }

    void "test delete"() {
        Long blockUserId = setupData()

        expect:
        blockUserService.count() == 5

        when:
        blockUserService.delete(blockUserId)
        sessionFactory.currentSession.flush()

        then:
        blockUserService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        BlockUser blockUser = new BlockUser()
        blockUserService.save(blockUser)

        then:
        blockUser.id != null
    }
}

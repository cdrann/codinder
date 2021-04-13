package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(InterestedInRelation)
interface InterestedInRelationService {

    InterestedInRelation get(Serializable id)

    List<InterestedInRelation> list(Map args)

    Long amount()

    void delete(Serializable id)

    InterestedInRelation save(InterestedInRelation interestedInRelation)

}

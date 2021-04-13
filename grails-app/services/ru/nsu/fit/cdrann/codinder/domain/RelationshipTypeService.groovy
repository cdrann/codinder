package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(RelationshipType)
interface RelationshipTypeService {

    RelationshipType get(Serializable id)

    List<RelationshipType> list(Map args)

    Long amount()

    void delete(Serializable id)

    RelationshipType save(RelationshipType relationshipType)

}

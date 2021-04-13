package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(InterestedInTech)
interface InterestedInTechService {

    InterestedInTech get(Serializable id)

    List<InterestedInTech> list(Map args)

    Long amount()

    void delete(Serializable id)

    InterestedInTech save(InterestedInTech interestedInTech)

}

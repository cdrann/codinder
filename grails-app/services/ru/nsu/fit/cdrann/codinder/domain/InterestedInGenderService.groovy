package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(InterestedInGender)
interface InterestedInGenderService {

    InterestedInGender get(Serializable id)

    List<InterestedInGender> list(Map args)

    Long count()

    void delete(Serializable id)

    InterestedInGender save(InterestedInGender interestedInGender)

}
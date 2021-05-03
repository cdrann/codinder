package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(InterestedInPeopleFromCity)
interface InterestedInPeopleFromCityService {

    InterestedInPeopleFromCity get(Serializable id)

    List<InterestedInPeopleFromCity> list(Map args)

    Long count()

    void delete(Serializable id)

    InterestedInPeopleFromCity save(InterestedInPeopleFromCity interestedInPeopleFromCity)

}
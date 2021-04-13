package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(TechnologyType)
interface TechnologyTypeService {

    TechnologyType get(Serializable id)

    List<TechnologyType> list(Map args)

    Long amount()

    void delete(Serializable id)

    TechnologyType save(TechnologyType technologyType)

}

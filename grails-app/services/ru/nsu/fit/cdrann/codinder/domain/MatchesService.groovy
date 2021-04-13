package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(Matches)
interface MatchesService {

    Matches get(Serializable id)

    List<Matches> list(Map args)

    Long amount()

    void delete(Serializable id)

    Matches save(Matches matches)

}

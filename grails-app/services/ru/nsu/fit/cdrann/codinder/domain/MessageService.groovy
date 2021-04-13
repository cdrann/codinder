package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(Messages)
interface MessageService {

    Messages get(Serializable id)

    List<Messages> list(Map args)

    Long amount()

    void delete(Serializable id)

    Messages save(Messages message)

}

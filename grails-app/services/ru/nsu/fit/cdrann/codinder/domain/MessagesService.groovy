package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(Messages)
interface MessagesService {

    Messages get(Serializable id)

    List<Messages> list(Map args)

    Long count()

    void delete(Serializable id)

    Messages save(Messages messages)

}
package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(Conversation)
interface ConversationService {

    Conversation get(Serializable id)

    List<Conversation> list(Map args)

    Long amount()

    void delete(Serializable id)

    Conversation save(Conversation conversation)

}

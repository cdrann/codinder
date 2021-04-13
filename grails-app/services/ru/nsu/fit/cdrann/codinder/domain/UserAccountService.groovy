package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(UserAccount)
interface UserAccountService {

    UserAccount get(Serializable id)

    List<UserAccount> list(Map args)

    Long amount()

    void delete(Serializable id)

    UserAccount save(UserAccount userAccount)

}

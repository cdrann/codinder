package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

@Service(BlockUser)
interface BlockUserService {

    BlockUser get(Serializable id)

    List<BlockUser> list(Map args)

    Long amount()

    void delete(Serializable id)

    BlockUser save(BlockUser blockUser)

}

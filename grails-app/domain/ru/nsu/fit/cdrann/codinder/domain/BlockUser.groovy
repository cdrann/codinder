package ru.nsu.fit.cdrann.codinder.domain

class BlockUser {

    UserAccount user_account_id_blocked // FK

    static constraints = {
        user_account_id_blocked blank: false, size: 2..10, unique: true // TODO ?

    }
}

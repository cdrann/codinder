package ru.nsu.fit.cdrann.codinder.domain

class Messages {

    String   message
    String dateCreated
    String lastUpdated

    static belongsTo = [user: UserAccount]

    static constraints = {
    }
}

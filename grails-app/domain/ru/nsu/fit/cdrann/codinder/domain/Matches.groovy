package ru.nsu.fit.cdrann.codinder.domain

class Matches {
    static belongsTo = [user: UserAccount]
    static hasOne = [conv: Conversation]

    static constraints = {
    }
}

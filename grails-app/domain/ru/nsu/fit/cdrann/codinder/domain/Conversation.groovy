package ru.nsu.fit.cdrann.codinder.domain

class Conversation {

    static hasMany = [messages:Messages]
    static hasOne = [match: Matches]
    static belongsTo = [user: UserAccount]

    static constraints = {
    }
}

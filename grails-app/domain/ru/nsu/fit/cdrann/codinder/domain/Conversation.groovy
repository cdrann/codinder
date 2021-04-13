package ru.nsu.fit.cdrann.codinder.domain

class Conversation {

    static hasMany = [messages:Messages]

    static constraints = {
    }
}

package ru.nsu.fit.cdrann.codinder.domain

class Messages {

    static belongsTo = [user: Conversation]

    String   message

    static constraints = {

    }

    @Override
    String toString() {
        return message
    }
}

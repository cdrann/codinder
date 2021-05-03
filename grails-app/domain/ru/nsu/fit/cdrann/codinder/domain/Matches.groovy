package ru.nsu.fit.cdrann.codinder.domain

class Matches {
    Date createdAt

    static belongsTo = [user: UserAccount]
    static hasOne = [conv: Conversation]

    static constraints = {
        createdAt validator: { if (it != null && it.after(new Date())) return ["invalid date"] }
    }
}

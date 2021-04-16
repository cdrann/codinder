package ru.nsu.fit.cdrann.codinder.domain

class InterestedInGender {
    static belongsTo = [gender: Gender, user:UserAccount]

    static constraints = {
        gender unique: 'user'
    }
}

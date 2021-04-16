package ru.nsu.fit.cdrann.codinder.domain

class Gender {

    String name

    Gender(String name) {
        this.name = name
    }

    static hasMany = [user: UserAccount]

    static constraints = {
        name blank: false, size: 2..50, unique: true, inList: ['Male', 'Female']
    }

    String toString() {
        name
    }
}

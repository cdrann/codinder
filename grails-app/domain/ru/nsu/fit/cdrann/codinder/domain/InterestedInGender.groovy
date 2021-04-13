package ru.nsu.fit.cdrann.codinder.domain

class InterestedInGender {

    String name

    static constraints = {
        name blank: false, size: 2..50, unique: true
    }

    @Override
    String toString() {
        return name
    }
}

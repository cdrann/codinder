package ru.nsu.fit.cdrann.codinder.domain

class Gender {

    String name

    static constraints = {
        name blank: false, size: 2..10, unique: true
    }


    @Override
    String toString() {
        return name
    }
}

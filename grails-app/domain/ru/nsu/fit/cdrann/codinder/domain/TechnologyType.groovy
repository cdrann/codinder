package ru.nsu.fit.cdrann.codinder.domain

class TechnologyType {
    String name

    static hasMany = [interestedInTech:InterestedInTech]

    static constraints = {
        name blank: false, size: 2..50, unique: true
    }

    @Override
    String toString() {
        return name
    }
}

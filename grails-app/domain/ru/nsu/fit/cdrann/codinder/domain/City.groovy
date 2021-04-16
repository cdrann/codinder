package ru.nsu.fit.cdrann.codinder.domain

class City {

    String name

    static hasMany = [user: UserAccount, interestedInPeopleFromCity: InterestedInPeopleFromCity]


    static constraints = {
        name blank: false, nullable: false, size: 2..50, unique: true
    }

    @Override
    String toString() {
        return name
    }
}

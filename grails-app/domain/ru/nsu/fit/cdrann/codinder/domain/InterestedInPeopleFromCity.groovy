package ru.nsu.fit.cdrann.codinder.domain

class InterestedInPeopleFromCity {
    static belongsTo = [user:UserAccount, city:City]

}

package ru.nsu.fit.cdrann.codinder.domain

class InterestedInTech {
    static belongsTo = [user:UserAccount, tech:TechnologyType]

    static constraints = {}
}

package ru.nsu.fit.cdrann.codinder.domain

class InterestedInRelation {
    static belongsTo = [user:UserAccount, relationshipType:RelationshipType]

    static constraints = {
        relationshipType unique: 'user'

    }
}

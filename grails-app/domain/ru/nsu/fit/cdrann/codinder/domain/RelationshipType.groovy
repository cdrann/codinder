package ru.nsu.fit.cdrann.codinder.domain

class RelationshipType {
    String name

    RelationshipType(String name) {
        this.name = name
    }

    static hasMany = [interestedInRelation:InterestedInRelation]

    static constraints = {
        name blank: false, size: 2..50, unique: true
    }

    @Override
    public String toString() {
        return  name;
    }
}

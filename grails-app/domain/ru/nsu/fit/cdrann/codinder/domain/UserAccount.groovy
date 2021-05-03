package ru.nsu.fit.cdrann.codinder.domain

class UserAccount {

    String name
    Integer age
    Date createdAt
    Boolean isActive
    static belongsTo = [city: City, gender: Gender]
    static hasMany = [interestedInPeipleFromCity: InterestedInPeopleFromCity, matches: Matches, conversation: Conversation,
                      interestedInTech          : InterestedInTech, interestedInRelation: InterestedInRelation, interestedInGender: InterestedInGender]

    static constraints = {
        name blank: false, size: 2..15
        gender nullable: true, size: 2..40
        age validator: { val -> validateAgeNum(val) }
        createdAt validator: { if (it != null && it.after(new Date())) return ["invalid date"] }

    }

    private static def validateAgeNum(int i) {
        if(i < 1 || i > 150)
            return ["invalid date"]
    }

    @Override
    String toString() {
        return name
    }
}
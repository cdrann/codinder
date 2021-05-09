package ru.nsu.fit.cdrann.codinder.domain

class InterestedInRelation {
    Date firstFriendWasMet
    Boolean isInLoveRelationshipsNow
    Integer numFriends
    String comment

    static belongsTo = [user:UserAccount, relationshipType:RelationshipType]

    static constraints = {
        relationshipType unique: 'user', nullable: true, size: 2..40

        numFriends validator: { val -> validateNumFriends(val) }
        comment nullable: true, size: 2..80
        firstFriendWasMet validator: { if (it != null && it.after(new Date())) return ["invalid date"] }

    }

    private static def validateNumFriends(int i) {
        if(i < 0 || i > 10000)
            return ["invalid num Friends"]
    }
}

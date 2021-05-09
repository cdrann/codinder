package ru.nsu.fit.cdrann.codinder.domain

class InterestedInTech {
    Date firstUseOfTech
    Boolean isUsedInWork
    Integer numProjectWritten
    String personalComment

    static belongsTo = [user:UserAccount, tech:TechnologyType]

    static constraints = {
        tech nullable: true, size: 2..40, unique: 'user'
        numProjectWritten validator: { val -> validateProjectNum(val) }
        personalComment nullable: true, size: 2..80
        firstUseOfTech validator: { if (it != null && it.after(new Date())) return ["invalid date"] }

    }

    private static def validateProjectNum(int i) {
        if(i < 0 || i > 10000)
            return ["invalid num of projects"]
    }
}

package ru.nsu.fit.cdrann.codinder.domain

class UserAccount {

    String name
    Integer age
    Gender gender
    UserPhoto userPhoto
    City city

    InterestedInGender interestedInGender
    InterestedInRelation interestedInRelation
    InterestedInTech interestedInTech
    InterestedInPeopleFromCity interestedInPeopleFromCity

    private BlockUser[] blockUsers //TODO ?
    private Matches matches
    private Conversation conversation

    static constraints = {
        name blank: false, size: 2..15
        gender nullable: true, size: 2..40
        city nullable: true, size: 2..40
        userPhoto nullable: true, size: 2..40
        age min: 18

        interestedInTech nullable: true
        interestedInRelation nullable: true
        interestedInPeopleFromCity nullable: true
        interestedInGender nullable: true
        
    }


    @Override
    public String toString() {
        return "UserAccount{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", interestedInGender=" + interestedInGender +
                ", interestedInRelation=" + interestedInRelation +
                ", interestedInTech=" + interestedInTech +
                ", userPhoto=" + userPhoto +
                ", city=" + city +
                '}';
    }
}
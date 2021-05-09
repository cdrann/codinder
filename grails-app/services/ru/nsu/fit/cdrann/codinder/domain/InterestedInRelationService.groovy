package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

import java.text.SimpleDateFormat

@Service(InterestedInRelation)
abstract class InterestedInRelationService {

    abstract InterestedInRelation get(Serializable id)

    abstract List<InterestedInRelation> list(Map args)

    List<InterestedInRelation> listWithParams(Map args) {
        Date fromDate = parseDate(args.get("fromDate"))

        Long relationshipId = args.get("relationship") as Long
        if (relationshipId < 0) {
            relationshipId = null
        }

        String isInLoveRelationshipsNow = args.get("love")
        if (isInLoveRelationshipsNow != null && !(isInLoveRelationshipsNow == "true" || isInLoveRelationshipsNow == "false")) {
            isInLoveRelationshipsNow = null
        }

        String name = args.get("name")
        if (name.toString().empty) {
            name = null
        }


        return InterestedInRelation.list(args).findAll {
            (name != null && it.comment == name || name == null)
        }.findAll {
            (isInLoveRelationshipsNow != null && it.isInLoveRelationshipsNow.toString() == isInLoveRelationshipsNow || isInLoveRelationshipsNow == null)
        }.findAll {
            (relationshipId != null && it.relationship.id == relationshipId || relationshipId == null)
        }.findAll {
            (fromDate != null && it.createdAt.after(fromDate) || fromDate == null)
        }
    }

    abstract Long count()

    abstract void delete(Serializable id)

    abstract InterestedInRelation save(InterestedInRelation userAccount)


    private static Date parseDate(Object stringObject) {
        if (stringObject == null || stringObject.toString().empty) {
            return null
        }
        try {
            String pattern = "yyyy-MM-dd"
            return new SimpleDateFormat(pattern).parse(stringObject.toString())
        } catch(Exception ignored) {
            return null
        }
    }
}
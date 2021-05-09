package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

import java.text.SimpleDateFormat

@Service(InterestedInTech)
abstract class InterestedInTechService {

    abstract InterestedInTech get(Serializable id)

    abstract List<InterestedInTech> list(Map args)

    List<InterestedInTech> listWithParams(Map args) {
        Date fromDate = parseDate(args.get("fromDate"))

        Long techId = args.get("tech") as Long
        if (techId < 0) {
            techId = null
        }
        String name = args.get("name")
        if (name.toString().empty) {
            name = null
        }

        String isUsedInWork = args.get("used")
        if (isUsedInWork != null && !(isUsedInWork == "true" || isUsedInWork == "false")) {
            isUsedInWork = null
        }


        return InterestedInTech.list(args).findAll {
            (name != null && it.name == name || name == null)
        }.findAll {
            (isUsedInWork != null && it.isUsedInWork.toString() == isUsedInWork || isUsedInWork == null)
        }.findAll {
            (techId != null && it.tech.id == techId || techId == null)
        }.findAll {
            (fromDate != null && it.createdAt.after(fromDate) || fromDate == null)
        }
    }

    abstract Long count()

    abstract void delete(Serializable id)

    abstract InterestedInTech save(InterestedInTech userAccount)


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
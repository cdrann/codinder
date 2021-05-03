package ru.nsu.fit.cdrann.codinder.domain

import grails.gorm.services.Service

import java.text.SimpleDateFormat

@Service(UserAccount)
abstract class UserAccountService {

    abstract UserAccount get(Serializable id)

    abstract List<UserAccount> list(Map args)

    List<UserAccount> listWithParams(Map args) {
        Date fromDate = parseDate(args.get("fromDate"))
        Date toDate = parseDate(args.get("toDate"))

        Long genderId = args.get("gender") as Long
        if (genderId < 0) {
            genderId = null
        }
        String name = args.get("name")
        if (name.toString().empty) {
            name = null
        }
        String isActive = args.get("active")
        if (isActive != null && !(isActive == "true" || isWorking == "false")) {
            isActive = null
        }



        return UserAccount.list(args).findAll {
            (name != null && it.name == name || name == null)
        }.findAll {
            (isActive != null && it.isActive.toString() == isActive || isActive == null)
        }.findAll {
            (genderId != null && it.gender.id == genderId || genderId == null)
        }.findAll {
            (fromDate != null && it.createdAt.after(fromDate) || fromDate == null)
        }.findAll {
            (toDate != null && it.createdAt.before(toDate) || toDate == null)
        }
    }

    abstract Long count()

    abstract void delete(Serializable id)

    abstract UserAccount save(UserAccount userAccount)


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
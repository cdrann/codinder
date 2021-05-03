package ru.nsu.fit.cdrann.codinder.domain

import groovy.sql.Sql

import javax.sql.DataSource

class ExtraInfoController {

    def dataSource

    def index() { }


    /*
       вывести количество UserAccount для каждого City
   */
    def groupBy = {
        def results = UserAccount.findAll().groupBy {
            it.city
        }

        render(view: 'groupBy',
                model: [results: results, resultCount: results.size()])
    }

    def filteringAndSorting = {
        params.ageFrom = params.ageFrom ?: 10000
        Long age = params.ageFrom as Integer

        def results = UserAccount.listOrderByName(order: 'asc').findAll {
            it.age >= age
        }

        render(view: 'filteringAndSorting',
                model: [results: results, resultCount: results.size()])
    }

    /*
       Вывести имена Userов, у которых возраст выше среднего по городу
   */
    def having = {
        def queryString = "SELECT UA.city_id as city_id, ARRAY_AGG(UA.id) as U_ARRAY " +
                "FROM user_account UA GROUP BY UA.city_id, UA.age " +
                "HAVING UA.age >= (SELECT AVG(d.age) FROM user_account d WHERE d.city_id = UA.city_id)"
        def sql = new Sql(dataSource as DataSource)
        Map<City, List<UserAccount>> results = new HashMap<City, List<UserAccount>>()
        sql.rows(queryString).each {
            results.put(City.findById(it.city_id), UserAccount.findAllByIdInList(it.U_ARRAY as List<Long>))
            println(it)
        }

        render(view: 'having',
                model: [results: results, resultCount: results.size()])
    }

    /* Найти всех пользователей, заинтерисованных в людях в своем городе */
    def innerJoin = {
        def queryString = "SELECT UA.id user_id FROM " +
                "USER_ACCOUNT UA INNER JOIN INTERESTED_IN_PEOPLE_FROM_CITY IC " +
                "ON UA.id = IC.user_id " +
                "WHERE UA.city_id = IC.city_id ORDER BY UA.age"
        def sql = new Sql(dataSource as DataSource)
        List<UserAccount> results = new LinkedList<>();
        sql.rows(queryString).each {
            results.add(UserAccount.findById(it.user_id))
            print(it)
        }

        render(view: 'innerJoin',
                model: [results: results, resultCount: results.size()])
    }

    /* Выбрать всех пользователей, не заинтерисованных в технологиях */
    def outerJoin = {
        def queryString = "SELECT UA.id user_id FROM " +
                "USER_ACCOUNT UA LEFT JOIN INTERESTED_IN_TECH IT " +
                "ON UA.id = IT.user_id WHERE IT.user_id IS NULL " +
                "ORDER BY UA.age"
        def sql = new Sql(dataSource as DataSource)
        List<UserAccount> results = new LinkedList<>();
        sql.rows(queryString).each {
            results.add(UserAccount.findById(it.user_id))
            print(it)
        }

        render(view: 'outerJoin',
                model: [results: results, resultCount: results.size()])
    }

}

package codinder

import ru.nsu.fit.cdrann.codinder.domain.Gender
import ru.nsu.fit.cdrann.codinder.domain.GenderService
import ru.nsu.fit.cdrann.codinder.domain.RelationshipType
import ru.nsu.fit.cdrann.codinder.domain.RelationshipTypeService

class BootStrap {

    GenderService genderService
    RelationshipTypeService relationshipTypeService

    def init = { servletContext ->
        genderService.save(new Gender('Male'))
        genderService.save(new Gender('Female'))

        relationshipTypeService.save(new RelationshipType('Friendship'))
        relationshipTypeService.save(new RelationshipType('Love'))
        relationshipTypeService.save(new RelationshipType('Partners'))

    }
    def destroy = {
    }
}

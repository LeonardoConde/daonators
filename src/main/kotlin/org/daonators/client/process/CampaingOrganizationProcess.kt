package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.CampaingOrganizationDao
import org.daonators.model.filter.CampaingOrganizationListFilter
import org.daonators.model.resource.CampaingOrganization
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * CampaingOrganization business logic
 * @author Simpli CLI generator
 */
class CampaingOrganizationProcess(val context: RequestContext) {

    val dao = CampaingOrganizationDao(context.con)

    fun get(id1: Long?, id2: Long?): CampaingOrganization {
        // TODO: review generated method
        if (id1 == null) throw BadRequestException()
        if (id2 == null) throw BadRequestException()

        return dao.getOne(id1, id2) ?: throw NotFoundException()
    }

    fun list(filter: CampaingOrganizationListFilter): PageCollection<CampaingOrganization> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: CampaingOrganization): Long {
        val exist = dao.exist(model.id1, model.id2)

        if (exist) {
            update(model)
        } else {
            create(model)
        }

        return model.id1
    }

    fun create(model: CampaingOrganization): Long {
        // TODO: review generated method
        model.apply {
            validate(context.lang)
        }

        dao.run {
            validate(model, updating = false)
            insert(model)
        }

        return 1L
    }

    fun update(model: CampaingOrganization): Int {
        // TODO: review generated method
        model.apply {
            validate(context.lang)
        }

        return dao.run {
            validate(model, updating = true)
            update(model)
        }
    }

    private fun CampaingOrganizationDao.validate(model: CampaingOrganization, updating: Boolean) {
        if (updating) {
            if (!exist(model.id1, model.id2)) {
                throw BadRequestException(context.lang["does_not_exist"])
            }
        } else {
            if (exist(model.id1, model.id2)) {
                throw BadRequestException(context.lang["already_exists"])
            }
        }
    }

}

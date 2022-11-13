package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.OrganizationDao
import org.daonators.dao.CampaingOrganizationDao
import org.daonators.model.filter.OrganizationListFilter
import org.daonators.model.resource.Organization
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * Organization business logic
 * @author Simpli CLI generator
 */
class OrganizationProcess(val context: RequestContext) {

    val dao = OrganizationDao(context.con)

    fun get(id: Long?): Organization {
        // TODO: review generated method
        if (id == null) throw BadRequestException()

        val campaingOrganizationDao = CampaingOrganizationDao(context.con)

        val model = dao.getOne(id) ?: throw NotFoundException()
        model.campaingOrganization = campaingOrganizationDao.listCampaingOfOrganization(id)

        return model
    }

    fun list(filter: OrganizationListFilter): PageCollection<Organization> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: Organization): Long {
        if (model.id > 0) {
            update(model)
        } else {
            create(model)
        }

        val campaingOrganizationDao = CampaingOrganizationDao(context.con)

        campaingOrganizationDao.removeAllFromOrganization(model.id)

        model.campaingOrganization?.let { list ->
            list.forEach { campaingOrganizationDao.insert(model.id, it.id) }
        }

        return model.id
    }

    fun create(model: Organization): Long {
        // TODO: review generated method
        model.apply {
            active = true
            validate(context.lang)
        }

        model.id = dao.run {
            validate(model, updating = false)
            insert(model)
        }

        return model.id
    }

    fun update(model: Organization): Int {
        // TODO: review generated method
        model.apply {
            active = true
            validate(context.lang)
        }

        return dao.run {
            validate(model, updating = true)
            update(model)
        }
    }

    fun remove(id: Long?): Long {
        // TODO: review generated method
        if (id == null) throw BadRequestException()

        val affectedRows = dao.softDelete(id)
        if (affectedRows == 0) throw NotFoundException()

        return id
    }

    private fun OrganizationDao.validate(model: Organization, updating: Boolean) {
        if (updating) {
            if (!exist(model.id)) {
                throw BadRequestException(context.lang["does_not_exist"])
            }
        } else {
            if (exist(model.id)) {
                throw BadRequestException(context.lang["already_exists"])
            }
        }
    }

}

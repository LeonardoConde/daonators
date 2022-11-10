package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.CampaingDao
import org.daonators.dao.CampaingOrganizationDao
import org.daonators.model.filter.CampaingListFilter
import org.daonators.model.resource.Campaing
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * Campaing business logic
 * @author Simpli CLI generator
 */
class CampaingProcess(val context: RequestContext) {

    val dao = CampaingDao(context.con)

    fun get(id: Long?): Campaing {
        // TODO: review generated method
        if (id == null) throw BadRequestException()

        val campaingOrganizationDao = CampaingOrganizationDao(context.con)

        val model = dao.getOne(id) ?: throw NotFoundException()
        model.campaingOrganization = campaingOrganizationDao.listOrganizationOfCampaing(id)

        return model
    }

    fun list(filter: CampaingListFilter): PageCollection<Campaing> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: Campaing): Long {
        if (model.id > 0) {
            update(model)
        } else {
            create(model)
        }

        val campaingOrganizationDao = CampaingOrganizationDao(context.con)

        campaingOrganizationDao.removeAllFromCampaing(model.id)

        model.campaingOrganization?.let { list ->
            list.forEach { campaingOrganizationDao.insert(model.id, it.id) }
        }

        return model.id
    }

    fun create(model: Campaing): Long {
        // TODO: review generated method
        model.apply {
            validate(context.lang)
        }

        model.id = dao.run {
            validate(model, updating = false)
            insert(model)
        }

        return model.id
    }

    fun update(model: Campaing): Int {
        // TODO: review generated method
        model.apply {
            validate(context.lang)
        }

        return dao.run {
            validate(model, updating = true)
            update(model)
        }
    }

    private fun CampaingDao.validate(model: Campaing, updating: Boolean) {
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

package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.CampaingTypeDao
import org.daonators.model.filter.CampaingTypeListFilter
import org.daonators.model.resource.CampaingType
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * CampaingType business logic
 * @author Simpli CLI generator
 */
class CampaingTypeProcess(val context: RequestContext) {

    val dao = CampaingTypeDao(context.con)

    fun get(id: Long?): CampaingType {
        // TODO: review generated method
        if (id == null) throw BadRequestException()

        return dao.getOne(id) ?: throw NotFoundException()
    }

    fun list(filter: CampaingTypeListFilter): PageCollection<CampaingType> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: CampaingType): Long {
        if (model.id > 0) {
            update(model)
        } else {
            create(model)
        }

        return model.id
    }

    fun create(model: CampaingType): Long {
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

    fun update(model: CampaingType): Int {
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

    private fun CampaingTypeDao.validate(model: CampaingType, updating: Boolean) {
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

package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.VotingTypeDao
import org.daonators.model.filter.VotingTypeListFilter
import org.daonators.model.resource.VotingType
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * VotingType business logic
 * @author Simpli CLI generator
 */
class VotingTypeProcess(val context: RequestContext) {

    val dao = VotingTypeDao(context.con)

    fun get(id: Long?): VotingType {
        // TODO: review generated method
        if (id == null) throw BadRequestException()

        return dao.getOne(id) ?: throw NotFoundException()
    }

    fun list(filter: VotingTypeListFilter): PageCollection<VotingType> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: VotingType): Long {
        if (model.id > 0) {
            update(model)
        } else {
            create(model)
        }

        return model.id
    }

    fun create(model: VotingType): Long {
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

    fun update(model: VotingType): Int {
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

    private fun VotingTypeDao.validate(model: VotingType, updating: Boolean) {
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

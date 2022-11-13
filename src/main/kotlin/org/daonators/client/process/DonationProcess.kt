package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.DonationDao
import org.daonators.model.filter.DonationListFilter
import org.daonators.model.resource.Donation
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * Donation business logic
 * @author Simpli CLI generator
 */
class DonationProcess(val context: RequestContext) {

    val dao = DonationDao(context.con)

    fun get(id1: Long?): Donation {
        // TODO: review generated method
        if (id1 == null) throw BadRequestException()

        return dao.getOne(id1) ?: throw NotFoundException()
    }

    fun list(filter: DonationListFilter): PageCollection<Donation> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: Donation): Long {
        val exist = dao.exist(model.id1, model.id2, model.id3)

        if (exist) {
            update(model)
        } else {
            create(model)
        }

        return model.id1
    }

    fun create(model: Donation): Long {
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

    fun update(model: Donation): Int {
        // TODO: review generated method
        model.apply {
            validate(context.lang)
        }

        return dao.run {
            validate(model, updating = true)
            update(model)
        }
    }

    private fun DonationDao.validate(model: Donation, updating: Boolean) {
        if (updating) {
            if (!exist(model.id1, model.id2, model.id3)) {
                throw BadRequestException(context.lang["does_not_exist"])
            }
        } else {
            if (exist(model.id1, model.id2, model.id3)) {
                throw BadRequestException(context.lang["already_exists"])
            }
        }
    }

}

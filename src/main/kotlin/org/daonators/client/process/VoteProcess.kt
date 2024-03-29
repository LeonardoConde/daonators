package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.VoteDao
import org.daonators.model.filter.VoteListFilter
import org.daonators.model.resource.Vote
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * Vote business logic
 * @author Simpli CLI generator
 */
class VoteProcess(val context: RequestContext) {

    val dao = VoteDao(context.con)

    fun get(id1: Long?, id2: Long?): Vote {
        // TODO: review generated method
        if (id1 == null) throw BadRequestException()
        if (id2 == null) throw BadRequestException()

        return dao.getOne(id1, id2) ?: throw NotFoundException()
    }

    fun list(filter: VoteListFilter): PageCollection<Vote> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: Vote): Long {
        val exist = dao.exist(model.id1, model.id2)

        if (exist) {
            update(model)
        } else {
            create(model)
        }

        return model.id1
    }

    fun create(model: Vote): Long {
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

    fun update(model: Vote): Int {
        // TODO: review generated method
        model.apply {
            validate(context.lang)
        }

        return dao.run {
            validate(model, updating = true)
            update(model)
        }
    }

    private fun VoteDao.validate(model: Vote, updating: Boolean) {
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

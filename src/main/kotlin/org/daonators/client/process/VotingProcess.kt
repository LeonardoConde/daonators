package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.VotingDao
import org.daonators.model.filter.VotingListFilter
import org.daonators.model.resource.Voting
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * Voting business logic
 * @author Simpli CLI generator
 */
class VotingProcess(val context: RequestContext) {

    val dao = VotingDao(context.con)

    fun get(id1: Long?, id2: Long?): Voting {
        // TODO: review generated method
        if (id1 == null) throw BadRequestException()
        if (id2 == null) throw BadRequestException()

        return dao.getOne(id1, id2) ?: throw NotFoundException()
    }

    fun list(filter: VotingListFilter): PageCollection<Voting> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: Voting): Long {
        val exist = dao.exist(model.id1, model.id2)

        if (exist) {
            update(model)
        } else {
            create(model)
        }

        return model.id1
    }

    fun create(model: Voting): Long {
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

    fun update(model: Voting): Int {
        // TODO: review generated method
        model.apply {
            validate(context.lang)
        }

        return dao.run {
            validate(model, updating = true)
            update(model)
        }
    }

    private fun VotingDao.validate(model: Voting, updating: Boolean) {
        model.idCampaingFk?.also {
            if (existIdCampaingFk(it, model.id1, model.id2)) {
                throw BadRequestException(context.lang.alreadyExist(context.lang["Voting.idCampaingFk"]))
            }
        }

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

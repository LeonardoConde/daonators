package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.AuthAdmDao
import org.daonators.model.filter.AuthAdmListFilter
import org.daonators.model.resource.AuthAdm
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * AuthAdm business logic
 * @author Simpli CLI generator
 */
class AuthAdmProcess(val context: RequestContext) {

    val dao = AuthAdmDao(context.con)

    fun get(id: Long?): AuthAdm {
        // TODO: review generated method
        if (id == null) throw BadRequestException()

        return dao.getOne(id) ?: throw NotFoundException()
    }

    fun list(filter: AuthAdmListFilter): PageCollection<AuthAdm> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: AuthAdm): Long {
        if (model.id > 0) {
            update(model)
        } else {
            create(model)
        }

        return model.id
    }

    fun create(model: AuthAdm): Long {
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

    fun update(model: AuthAdm): Int {
        // TODO: review generated method
        model.apply {
            validate(context.lang)
        }

        return dao.run {
            validate(model, updating = true)
            update(model)
        }
    }

    private fun AuthAdmDao.validate(model: AuthAdm, updating: Boolean) {
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

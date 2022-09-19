package org.daonators.client.process

import org.daonators.client.context.RequestContext
import org.daonators.dao.OrganizationTypeDao
import org.daonators.dao.OrganizationTypeListDao
import org.daonators.model.filter.OrganizationTypeListFilter
import org.daonators.model.resource.OrganizationType
import org.daonators.exception.response.BadRequestException
import org.daonators.exception.response.NotFoundException
import br.com.simpli.model.PageCollection
import java.util.Date

/**
 * OrganizationType business logic
 * @author Simpli CLI generator
 */
class OrganizationTypeProcess(val context: RequestContext) {

    val dao = OrganizationTypeDao(context.con)

    fun get(id: Long?): OrganizationType {
        // TODO: review generated method
        if (id == null) throw BadRequestException()

        val organizationTypeListDao = OrganizationTypeListDao(context.con)

        val model = dao.getOne(id) ?: throw NotFoundException()
        model.organizationTypeList = organizationTypeListDao.listOrganizationOfOrganizationType(id)

        return model
    }

    fun list(filter: OrganizationTypeListFilter): PageCollection<OrganizationType> {
        // TODO: review generated method
        val items = dao.getList(filter)
        val total = dao.count(filter)

        return PageCollection(items, total)
    }

    /**
     * Use this to handle similarities between create and update
     */
    fun persist(model: OrganizationType): Long {
        if (model.id > 0) {
            update(model)
        } else {
            create(model)
        }

        val organizationTypeListDao = OrganizationTypeListDao(context.con)

        organizationTypeListDao.removeAllFromOrganizationType(model.id)

        model.organizationTypeList?.let { list ->
            list.forEach { organizationTypeListDao.insert(model.id, it.id) }
        }

        return model.id
    }

    fun create(model: OrganizationType): Long {
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

    fun update(model: OrganizationType): Int {
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

    private fun OrganizationTypeDao.validate(model: OrganizationType, updating: Boolean) {
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

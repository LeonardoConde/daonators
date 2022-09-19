package org.daonators.dao

import org.daonators.model.filter.CampaingListFilter
import org.daonators.model.resource.Campaing
import org.daonators.model.rm.CampaingRM
import org.daonators.model.rm.CampaingTypeRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of Campaing from table campaing
 * @author Simpli CLI generator
 */
class CampaingDao(val con: AbstractConnector) {
    fun getOne(idCampaingPk: Long): Campaing? {
        // TODO: review generated method
        val query = Query()
                .selectCampaing()
                .from("campaing")
                .whereEq("idCampaingPk", idCampaingPk)

        return con.getOne(query) {
            CampaingRM.build(it)
        }
    }

    fun getList(filter: CampaingListFilter): MutableList<Campaing> {
        // TODO: review generated method
        val query = Query()
                .selectFields(CampaingRM.selectFields() + CampaingTypeRM.selectFields())
                .from("campaing")
                .innerJoin("campaing_type", "campaing_type.idCampaingTypePk", "campaing.idCampaingTypePk")
                .whereCampaingFilter(filter)
                .orderAndLimitCampaing(filter)

        return con.getList(query) {
            CampaingRM.build(it).apply {
                campaingType = CampaingTypeRM.build(it)
            }
        }
    }

    fun count(filter: CampaingListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idCampaingPk")
                .from("campaing")
                .whereCampaingFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(campaing: Campaing): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("campaing")
                .updateCampaingSet(campaing)
                .whereEq("idCampaingPk", campaing.id)

        return con.execute(query).affectedRows
    }

    fun insert(campaing: Campaing): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("campaing")
                .insertCampaingValues(campaing)

        return con.execute(query).key
    }

    fun exist(idCampaingPk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idCampaingPk")
                .from("campaing")
                .whereEq("idCampaingPk", idCampaingPk)

        return con.exist(query)
    }

    private fun Query.selectCampaing() = selectFields(CampaingRM.selectFields())

    private fun Query.updateCampaingSet(campaing: Campaing) = updateSet(CampaingRM.updateSet(campaing))

    private fun Query.insertCampaingValues(campaing: Campaing) = insertValues(CampaingRM.insertValues(campaing))

    private fun Query.whereCampaingFilter(filter: CampaingListFilter, alias: String = "campaing"): Query {
        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(CampaingRM.fieldsToSearch(alias), "%$it%")
            }
        }

        filter.idCampaingTypePk?.also {
            if (it.isNotEmpty()) {
                whereIn("$alias.idCampaingTypePk", *it.toTypedArray())
            }
        }

        filter.startBeginDate?.also {
            where("DATE($alias.beginDate) >= DATE(?)", it)
        }
        filter.endBeginDate?.also {
            where("DATE($alias.beginDate) <= DATE(?)", it)
        }

        filter.startEndDate?.also {
            where("DATE($alias.endDate) >= DATE(?)", it)
        }
        filter.endEndDate?.also {
            where("DATE($alias.endDate) <= DATE(?)", it)
        }

        return this
    }

    private fun Query.orderAndLimitCampaing(filter: CampaingListFilter, alias: String = "campaing"): Query {
        CampaingRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}

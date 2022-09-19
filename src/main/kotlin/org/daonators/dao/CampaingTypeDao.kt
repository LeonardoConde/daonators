package org.daonators.dao

import org.daonators.model.filter.CampaingTypeListFilter
import org.daonators.model.resource.CampaingType
import org.daonators.model.rm.CampaingTypeRM
import br.com.simpli.sql.AbstractConnector
import br.com.simpli.sql.Query

/**
 * Data Access Object of CampaingType from table campaing_type
 * @author Simpli CLI generator
 */
class CampaingTypeDao(val con: AbstractConnector) {
    fun getOne(idCampaingTypePk: Long): CampaingType? {
        // TODO: review generated method
        val query = Query()
                .selectCampaingType()
                .from("campaing_type")
                .whereEq("idCampaingTypePk", idCampaingTypePk)

        return con.getOne(query) {
            CampaingTypeRM.build(it)
        }
    }

    fun getList(filter: CampaingTypeListFilter): MutableList<CampaingType> {
        // TODO: review generated method
        val query = Query()
                .selectCampaingType()
                .from("campaing_type")
                .whereCampaingTypeFilter(filter)
                .orderAndLimitCampaingType(filter)

        return con.getList(query) {
            CampaingTypeRM.build(it)
        }
    }

    fun count(filter: CampaingTypeListFilter): Int {
        // TODO: review generated method
        val query = Query()
                .countRaw("DISTINCT idCampaingTypePk")
                .from("campaing_type")
                .whereCampaingTypeFilter(filter)

        return con.getFirstInt(query) ?: 0
    }

    fun update(campaingType: CampaingType): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("campaing_type")
                .updateCampaingTypeSet(campaingType)
                .whereEq("idCampaingTypePk", campaingType.id)

        return con.execute(query).affectedRows
    }

    fun insert(campaingType: CampaingType): Long {
        // TODO: review generated method
        val query = Query()
                .insertInto("campaing_type")
                .insertCampaingTypeValues(campaingType)

        return con.execute(query).key
    }

    fun exist(idCampaingTypePk: Long): Boolean {
        // TODO: review generated method
        val query = Query()
                .select("idCampaingTypePk")
                .from("campaing_type")
                .whereEq("idCampaingTypePk", idCampaingTypePk)

        return con.exist(query)
    }

    fun softDelete(idCampaingTypePk: Long): Int {
        // TODO: review generated method
        val query = Query()
                .updateTable("campaing_type")
                .updateSet("active" to false)
                .whereEq("idCampaingTypePk", idCampaingTypePk)

        return con.execute(query).affectedRows
    }

    private fun Query.selectCampaingType() = selectFields(CampaingTypeRM.selectFields())

    private fun Query.updateCampaingTypeSet(campaingType: CampaingType) = updateSet(CampaingTypeRM.updateSet(campaingType))

    private fun Query.insertCampaingTypeValues(campaingType: CampaingType) = insertValues(CampaingTypeRM.insertValues(campaingType))

    private fun Query.whereCampaingTypeFilter(filter: CampaingTypeListFilter, alias: String = "campaing_type"): Query {
        whereEq("$alias.active", true)

        filter.query?.also {
            if (it.isNotEmpty()) {
                whereSomeLikeThis(CampaingTypeRM.fieldsToSearch(alias), "%$it%")
            }
        }

        return this
    }

    private fun Query.orderAndLimitCampaingType(filter: CampaingTypeListFilter, alias: String = "campaing_type"): Query {
        CampaingTypeRM.orderMap(alias)[filter.orderBy]?.also {
            orderByAsc(it, filter.ascending)
        }

        filter.limit?.also {
            val index = (filter.page ?: 0) * it
            limit(index, it)
        }

        return this
    }
}

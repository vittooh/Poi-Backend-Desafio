package com.xy.inc.dbl.pois.poi

import org.hibernate.engine.internal.Collections
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Service
import kotlin.math.pow
import kotlin.math.sqrt

@Service
class PoiService(
    val poiRepository: PoiRepository
) {


    fun createPoi(poi: Poi): Poi {
        return poiRepository.save(
            poi
        )
    }

    fun listAll(page: Pageable): Page<Poi> {
        return poiRepository.findAll(page)
    }

    fun filterProximityPois(x: Int, y: Int, distance: Int): List<Poi> {
        return poiRepository.findAll()
            .filter { poi ->
                calcDistance(poi, x, y, distance)
            }.toList()
    }

    fun calcDistance(poi: Poi, x: Int, y: Int, distance: Int): Boolean {
        val xPow = (x - poi.x).toDouble().pow(2.0).toInt()
        val yPow = (y - poi.y).toDouble().pow(2.0).toInt()
        return sqrt((xPow + yPow).toDouble()) < distance
    }
}
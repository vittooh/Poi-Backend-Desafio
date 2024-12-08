package com.xy.inc.dbl.pois.poi

import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/pois")
class PoiController(
    val poiService: PoiService
) {

    @PostMapping
    fun createPoi(@Valid @RequestBody poiCreateDto: PoiCreateDto): PoiCreateDto {
        return poiService.createPoi(
            poiCreateDto.toPoi()
        ).toCreateDto()
    }

    @GetMapping("/all")
    fun listAll(@PageableDefault pageableDefault: Pageable): Page<PoiCreateDto> {
        return poiService.listAll(pageableDefault)
            .map { it.toCreateDto() }
    }

    @PostMapping("/filter")
    fun listAll(@Valid @RequestBody filterPoiDto: FilterPoiDto): List<PoiCreateDto> {
        return poiService.filterProximityPois(
            filterPoiDto.x,
            filterPoiDto.y,
            filterPoiDto.distance
        ).map { it.toCreateDto() }
    }
}
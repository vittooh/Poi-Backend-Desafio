package com.xy.inc.dbl.pois.poi


fun Poi.toCreateDto(): PoiCreateDto {
    return PoiCreateDto(
        id = this.id,
        name = this.name,
        x = this.x,
        y = this.y
    )
}

fun PoiCreateDto.toPoi(): Poi {
    return Poi(
        id = this.id,
        name = this.name,
        x = this.x,
        y = this.y
    )
}
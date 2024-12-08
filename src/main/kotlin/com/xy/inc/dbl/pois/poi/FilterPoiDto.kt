package com.xy.inc.dbl.pois.poi

import jakarta.validation.constraints.Min

class FilterPoiDto(
    @field:Min(value = 0, message = "x >= 0 ")
    val x: Int,
    @field:Min(value = 0, message = "y >= 0")
    val y: Int,
    @field:Min(value = 0, message = "distancia >= 0 ")
    val distance: Int
)

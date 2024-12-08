package com.xy.inc.dbl.pois.poi

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

class PoiCreateDto(
    val id : String? = null,
    @field:NotBlank(message = "Cabeça de pudim, envia o nome")
    var name: String,
    @field:Min(value = 0, message = "x >= 0 zé ruela")
    var x: Int,
    @field:Min(value = 0, message = "y >= 0 maria das couves")
    var y: Int
)



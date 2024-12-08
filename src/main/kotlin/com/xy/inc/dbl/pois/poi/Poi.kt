package com.xy.inc.dbl.pois.poi

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Poi(
    @Id
    var id : String? = null,
    var name: String,
    var x: Int,
    var y: Int
)
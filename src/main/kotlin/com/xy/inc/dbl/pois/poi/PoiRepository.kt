package com.xy.inc.dbl.pois.poi

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PoiRepository  : MongoRepository<Poi,String>
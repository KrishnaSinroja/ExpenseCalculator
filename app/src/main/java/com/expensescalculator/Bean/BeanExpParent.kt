package com.expensescalculator.Bean

import java.util.*

class BeanExpParent {
    var month: String? = null
    var category: String? = null
    var date: String? = null
    var expense: String? = null
    var children = ArrayList<BeanExpChild>()

}
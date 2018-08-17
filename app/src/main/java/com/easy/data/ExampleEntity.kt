package com.easy.data

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class ExampleEntity(@Id var id: Long, var name: String?) {
    constructor() : this(0, null)
}
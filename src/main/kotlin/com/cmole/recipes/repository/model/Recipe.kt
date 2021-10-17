package com.cmole.recipes.repository.model;

import org.jetbrains.exposed.dao.IntIdTable

object Recipe : IntIdTable() {
    val title = varchar("title", 255)
    val procedure = text("procedure")
    val note = text("note")
}
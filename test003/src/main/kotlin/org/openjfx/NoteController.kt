package org.openjfx

import javafx.collections.FXCollections
import javafx.stage.Screen
import javafx.stage.Stage
import tornadofx.Controller
import tornadofx.asObservable

class NoteController: Controller() {
    var currentStage: Stage? = null
    val primaryScreenBounds = Screen.getPrimary().visualBounds

    val notelist = FXCollections.observableArrayList<Note>(
        Note(0,"Alpha"),
        Note(1,"Beta"),
        Note(2,"Gamma"),
        Note(3,"Beta")
        )
}
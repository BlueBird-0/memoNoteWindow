package org.openjfx

import javafx.collections.FXCollections
import tornadofx.Controller
import tornadofx.asObservable

class NoteController: Controller() {
    val notelist = FXCollections.observableArrayList<Note>(
        Note(0,"Alpha"),
        Note(1,"Beta"),
        Note(2,"Gamma"),
        Note(3,"Beta")
        )
}
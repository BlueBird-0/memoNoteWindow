package org.openjfx

import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel
import java.util.*
import kotlin.collections.ArrayList



class Note(val id:Long, val content:String, val createdTime: Date?=Date(), val checkedTime: Date?=null, val pictureUris:ArrayList<String>?= null ) {
//    val idProperty = SimpleLongProperty(this, "id", id)
//    var id by idProperty
//    val contentProperty = SimpleStringProperty(this, "content", content)
//    var content by contentProperty
}

class NoteModel(note: Note) : ItemViewModel<Note>(note){
//    val id = bind(Note::idProperty)
//    val content = bind(Note::contentProperty)
}
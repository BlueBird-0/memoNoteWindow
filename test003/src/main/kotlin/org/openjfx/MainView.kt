package org.openjfx

import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*


class MainView: View(){
    val controller: NoteController by inject()
    init {
        title = "MemoNote"
    }

    override val root = vbox {
        style {
            prefHeight = Dimension(300.0, Dimension.LinearUnits.px)
        }
        listview(controller.notelist){
            style {
                //                prefHeight = Dimension(parent.layoutY, Dimension.LinearUnits.px)
                prefHeight = Dimension(3000.0, Dimension.LinearUnits.px)
            }
            cellFormat {
                style{
                    padding = box(0.px)
                    backgroundColor = multi(c(AppColor.white))//background
                }
                graphic = //cache {
                    fieldset {
                        vbox{
                            label("${it.content}") {
                                style {
                                    useMaxHeight = true
                                    useMaxWidth = true
                                    alignment = Pos.CENTER
                                    padding = box(10.px,0.px,10.px,0.px)
                                }
                            }
                            vbox {
                                style{
                                    minHeight = Dimension(1.0, Dimension.LinearUnits.px)
                                    backgroundColor = multi(Color.LIGHTGRAY)
                                }
                            }
                        }
//                  }
                    }
            }
        }
    }

    override fun onDock() {
        println("Docking MyView2!")
    }
    override fun onUndock() {
        println("Undocking MyView2!")
    }
}
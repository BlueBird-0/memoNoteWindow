package org.openjfx

import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.*

class MainStyle: Stylesheet() {
    companion object {
        val tackyButton by cssclass()

    }

    init {
        label {
            fontSize = 14.px
        }
        listView {
            backgroundColor = multi(Color.RED)
            padding = box(0.px)
            listCell {
                backgroundColor = multi(c(AppColor.background))
                and(selected) {
                    label {
                        textFill = Paint.valueOf(AppColor.accent)
                    }
                }
            }
        }

    }
}
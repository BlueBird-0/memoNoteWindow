package org.openjfx

import javafx.application.Platform
import javafx.geometry.Pos
import javafx.scene.image.Image
import javafx.scene.paint.Color
import javafx.stage.Modality
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.StageStyle
import tornadofx.*
import java.awt.TrayIcon
import java.awt.Window
import javax.imageio.ImageIO
import javax.swing.Spring.height

fun main(args: Array<String>) {
    launch<MyApp>(args)
}

class MyApp: App(RootView::class, MainStyle::class) {
    val controller: NoteController by inject()
    init{
        reloadStylesheetsOnFocus()
    }

    override fun start(stage: Stage) {
        //작업표시줄 가리기
        stage.initStyle(StageStyle.UNDECORATED)
        stage.width = 200.0
        stage.height = 200.0
        stage.x = controller.primaryScreenBounds.maxX - stage.width - 100
        stage.y = controller.primaryScreenBounds.maxY - stage.height - 100
        super.start(stage)
//        stage.toBack()
        //TrayIcon 전시할 이미지 가져옴
        val resource = this.javaClass.getResourceAsStream("/org.openjfx/icon_high.png")
        val trayIcon = TrayIcon(ImageIO.read(resource))

        //SystemTray지원 가능 여부 확인
        trayicon(resources.stream("/org.openjfx/icon_high.png")){
            setOnMouseClicked(fxThread = true){
                FX.primaryStage.show()
                FX.primaryStage.toFront()
            }

            menu("Open") {
                item("Show...") {
                    setOnAction(fxThread = true) {
                        var mainView = MainView()
                        mainView.openWindow(owner = null, stageStyle = StageStyle.UTILITY,
                        escapeClosesWindow = false)
                    }
                }
                item("Exit") {
                    setOnAction (fxThread = true){
                        Platform.exit()
                    }
                }
            }
        }
    }
}
class RootView: View(){
    val controller: NoteController by inject()
    init{
        primaryStage.icons.clear()
        primaryStage.icons.add(Image(this.javaClass.getResourceAsStream("/org.openjfx/icon_high.png")))
        System.out.println("icon test : " + primaryStage.icons)
    }

    override val root = vbox{
        button ("openMainView"){
            action {
                MainView().openWindow(owner = null, stageStyle = StageStyle.UTILITY,
                    escapeClosesWindow = false).apply {
                    this?.x = controller.primaryScreenBounds.maxX - this!!.width - 100
                    this?.y = controller.primaryScreenBounds.maxY - this!!.height
                    this?.toFront()
                    this?.isAlwaysOnTop = true
                }
            }
        }
        button ("create data"){
            action {
                var id : Long = 4
                controller.notelist.add(Note(id++, "created Note"))
            }
        }
        button ("exit") {
            action {
                primaryStage.hide()
//                Platform.exit()
//                exitProcess(0)
            }
        }
    }
}
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
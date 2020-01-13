package org.openjfx

import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

class KakaoController {
    private val CLIENT_ID = "e64db7cd5bfe39fbc7eaa50706606695"
    private val REDIRECT_URI = "https://kakao.com"

}

@SpringBootApplication
class ServingWebContentApplication {
    fun main(args: Array<String>) {
        System.out.println("service start!")
    }
}

@Controller
class ExRedirectController {
    @RequestMapping(value = ["/kakaoLogin.do"], produces = ["application/json"], method = arrayOf(RequestMethod.GET))
    fun kakaoLogin(@RequestParam("code") code : String): String {
//    @RequestParam"code"
        System.out.println("Redirect fun excute")
        return "redirect:kakaoLogin.do"
    }
}

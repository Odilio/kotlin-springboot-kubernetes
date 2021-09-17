package kt.boilerplate_spring_boot.controller

import org.springframework.web.bind.annotation.*
import kt.boilerplate_spring_boot.model.Product
import kt.boilerplate_spring_boot.service.WebClientCommand
import kt.boilerplate_spring_boot.service.WebClientCommand.*
import kt.boilerplate_spring_boot.service.WebClientService
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/test")
class TestController(
    private val webClientService: WebClientService
) {

    @GetMapping("/webclient/{webClientCommand}")
    fun command(@PathVariable webClientCommand: WebClientCommand): ResponseEntity<String> = ResponseEntity.ok(when (webClientCommand) {
        GetSynchronous -> webClientService.getSynchronous()
        GetAsynchronous -> webClientService.getAsynchronous().block()
        PostSynchronous -> TODO()
        PostAsynchronous -> TODO()
        PutSynchronous -> TODO()
        DeleteSynchronous -> TODO()
        Exchange -> TODO()
    }.toString())
}

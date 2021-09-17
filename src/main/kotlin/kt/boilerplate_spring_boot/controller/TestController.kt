package kt.boilerplate_spring_boot.controller

import org.springframework.web.bind.annotation.*
import kt.boilerplate_spring_boot.model.Product
import kt.boilerplate_spring_boot.service.WebClientService
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/test")
class TestController(
    private val webClientService: WebClientService
) {

    @GetMapping("/webclient/{id}")
    fun command(@PathVariable id:Integer): ResponseEntity<Product>? = webClientService.getSynchronous(id)

}

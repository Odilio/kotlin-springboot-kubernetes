package kt.boilerplate_spring_boot.controller

import org.springframework.web.bind.annotation.*
import kt.boilerplate_spring_boot.model.Product
import kt.boilerplate_spring_boot.service.WebClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping()
class TestController(
    private val webClientService: WebClientService
) {

    @Autowired
    private val discoveryClient: DiscoveryClient? = null

    @GetMapping("/webclient/{id}")
    fun command(@PathVariable id:Integer): ResponseEntity<Product>? = webClientService.getSynchronous(id)

    @GetMapping("/print")
    fun print(): Unit = println("imprimir o discovery ${discoveryClient?.services}")
}

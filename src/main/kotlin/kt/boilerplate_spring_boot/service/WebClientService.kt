package kt.boilerplate_spring_boot.service

import kt.boilerplate_spring_boot.model.Product
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono

class WebClientService(
        private val webClient: WebClient
) {
        @Value("\${url.products}")
        private val url: String? = null

    fun getSynchronous(): ResponseEntity<Product>? = webClient
            .get()
            .uri(UriComponentsBuilder
                    .fromHttpUrl(url!!)
                    .path("/products/1")
                    .build()
                    .toUri())
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
            .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
            .toEntity(Product::class.java)
            .block()

    fun getAsynchronous(): Mono<Product> = webClient
            .get()
            .uri(UriComponentsBuilder
                    .fromHttpUrl(url!!)
                    .path("/products/1")
                    .build()
                    .toUri())
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
            .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
            .bodyToMono(Product::class.java)

    fun postSynchronous(): ResponseEntity<Product>? = webClient
            .post()
            .uri(UriComponentsBuilder
                    .fromHttpUrl(url!!)
                    .path("/products/1")
                    .build()
                    .toUri())
            .body(BodyInserters.fromValue(Product(1, "A new beautiful product")))
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
            .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
            .toEntity(Product::class.java)
            .block()

    fun postAsynchronous(): Mono<Product> = webClient
            .post()
            .uri(UriComponentsBuilder
                    .fromHttpUrl(url!!)
                    .path("/products/1")
                    .build()
                    .toUri())
            .body(BodyInserters.fromValue(Product(1, "A new beautiful product")))
            .retrieve()
            .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
            .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
            .bodyToMono(Product::class.java)

    fun putSynchronous(): String {
        val product = Product(1, "A new beautiful product")
        webClient
                .put()
                .uri(UriComponentsBuilder
                        .fromHttpUrl(url!!)
                        .path("/products/1")
                        .build()
                        .toUri())
                .body(BodyInserters.fromValue(product))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
                .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
                .bodyToMono(Void::class.java)
                .block()
        return "Product resource created $product"
    }

    fun deleteSynchronous(): String {
        webClient
                .put()
                .uri(UriComponentsBuilder
                        .fromHttpUrl(url!!)
                        .path("/products/1")
                        .build()
                        .toUri())
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError) { Mono.error(RuntimeException("4XX Error ${it.statusCode()}")) }
                .onStatus(HttpStatus::is5xxServerError) { Mono.error(RuntimeException("5XX Error ${it.statusCode()}")) }
                .bodyToMono(Void::class.java)
                .block()
        return "Product resource deleted"
    }

    fun exchange(): Mono<Product> = webClient
            .get()
            .uri(UriComponentsBuilder
                    .fromHttpUrl(url!!)
                    .path("/products/1")
                    .build()
                    .toUri())
            .exchangeToMono { response ->
                when(response.statusCode()) {
                    HttpStatus.OK -> response.bodyToMono(Product::class.java)
                    else -> Mono.error(RuntimeException("4XX Error ${response.statusCode()}"))
                }
            }
}
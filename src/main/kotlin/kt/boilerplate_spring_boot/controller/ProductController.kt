package kt.boilerplate_spring_boot.controller

import org.springframework.web.bind.annotation.*
import kt.boilerplate_spring_boot.model.Product
import kt.boilerplate_spring_boot.service.ProductService

@RestController
@RequestMapping("/products")
class ProductController(val service: ProductService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Product? = service.findById(id)

    @GetMapping
    fun findAll(): List<Product> = service.findAll()

    @PostMapping
    fun add(@RequestBody product: Product): Product = service.save(product)

    @PutMapping
    fun update(@RequestBody product: Product): Product = service.update(product)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Long): Unit = service.removeById(id)

}

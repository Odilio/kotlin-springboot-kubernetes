package kt.boilerplate_spring_boot.controller

import kt.boilerplate_spring_boot.model.Category
import org.springframework.web.bind.annotation.*
import kt.boilerplate_spring_boot.model.Product
import kt.boilerplate_spring_boot.service.CategoryService
import kt.boilerplate_spring_boot.service.ProductService

@RestController
@RequestMapping("/categories")
class CategoryController(val service: CategoryService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Category? = service.findById(id)

    @GetMapping
    fun findAll(): List<Category> = service.findAll()

    @PostMapping
    fun add(@RequestBody category: Category): Category = service.save(category)

    @PutMapping
    fun update(@RequestBody category: Category): Category = service.update(category)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Long): Unit = service.removeById(id)

}

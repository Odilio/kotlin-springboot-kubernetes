package kt.boilerplate_spring_boot.service

import org.springframework.stereotype.Repository
import kt.boilerplate_spring_boot.model.Product
import kt.boilerplate_spring_boot.repository.ProductRepository

@Repository
class ProductService(val repository: ProductRepository)  {

    fun findById(id: Long): Product? = repository.findById(id).get()

    fun findAll(): List<Product> = repository.findAll()

    fun save(product: Product): Product {
        return repository.save(product)
    }

    fun update(product: Product): Product {
        return repository.save(product)
    }

    fun removeById(id: Long): Unit = repository.deleteById(id)

}

package kt.boilerplate_spring_boot.service

import kt.boilerplate_spring_boot.model.Category
import org.springframework.stereotype.Repository
import kt.boilerplate_spring_boot.model.Product
import kt.boilerplate_spring_boot.repository.CategoryRepository
import kt.boilerplate_spring_boot.repository.ProductRepository

@Repository
class CategoryService(val repository: CategoryRepository)  {

    fun findById(id: Long): Category? = repository.findById(id).get()

    fun findAll(): List<Category> = repository.findAll()

    fun save(category: Category): Category {
        return repository.save(category)
    }

    fun update(category: Category): Category {
        return repository.save(category)
    }

    fun removeById(id: Long): Unit = repository.deleteById(id)

}

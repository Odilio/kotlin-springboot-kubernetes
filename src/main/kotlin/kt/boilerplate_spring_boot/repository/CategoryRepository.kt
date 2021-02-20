package kt.boilerplate_spring_boot.repository

import kt.boilerplate_spring_boot.model.Category
import kt.boilerplate_spring_boot.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>
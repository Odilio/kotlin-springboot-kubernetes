package kt.boilerplate_spring_boot

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import kt.boilerplate_spring_boot.model.Category
import kt.boilerplate_spring_boot.model.Product

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class ProductControllerTests {

    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    @Order(1)
    fun shouldAddProduct() {
        var category = Category(1,"ELECTRONIC")
        var product = Product(1, "Celular", 20, category)
        product = template.postForObject("/products", product, Product::class.java)
        Assertions.assertNotNull(product)
        Assertions.assertNotNull(product.id)
        Assertions.assertEquals(4, product.id)
    }

    @Test
    @Order(2)
    fun shouldUpdateProduct() {
        var category = Category(1,"ELECTRONIC")
        var product = Product(1, "Notebook", 21, category)
        template.put("/products", product)
        product = template.getForObject("/products/{id}", Product::class.java, 1)
        Assertions.assertNotNull(product)
        Assertions.assertEquals(21, product.price)
    }

    @Test
    @Order(3)
    fun shouldDeletePerson() {
        template.delete("/products/{id}", 1)
        val product = template.getForObject("/products/{id}", Product::class.java, 1)
        Assertions.assertNull(product)
    }

}
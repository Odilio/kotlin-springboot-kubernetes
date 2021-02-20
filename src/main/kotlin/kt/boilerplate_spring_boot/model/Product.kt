package kt.boilerplate_spring_boot.model

import com.sun.istack.NotNull
import javax.persistence.*

@Entity
data class Product(
    @Id @NotNull @Column()
    var id: Long,
    @Column()
    var name: String,
    @Column(nullable = true)
    var price: Int? = null,
    @ManyToOne
    @JoinColumn(name="fk_categories_id")
    var category: Category? = null)
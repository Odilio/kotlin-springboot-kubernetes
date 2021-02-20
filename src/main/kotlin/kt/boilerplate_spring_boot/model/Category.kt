package kt.boilerplate_spring_boot.model

import com.sun.istack.NotNull
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Category(
    @Id @NotNull @Column()
    var id: Long,
    @Column()
    var name: String
)
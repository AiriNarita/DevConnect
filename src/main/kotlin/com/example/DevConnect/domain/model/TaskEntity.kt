import org.seasar.doma.Entity
import org.seasar.doma.Table

@Entity(immutable = true)
@Table(name = "tasks")
data class TaskEntity(
    val id: Int,
    val title: String,
    val description: String,
    val done: Boolean,
)
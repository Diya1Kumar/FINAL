import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")  // Ensure this matches the table name in the query
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val email: String,  // This must match the query
    val password: String
)

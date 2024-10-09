import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import java.util.concurrent.Flow

@Dao
abstract class UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(userEntity: User)

    @Update
    abstract fun update(user: User)

    @Delete
    abstract fun delete(user: User)

    @Query("SELECT * FROM `users` WHERE email = :email LIMIT 1")
    abstract fun getUserByEmail(email: String): User?

}

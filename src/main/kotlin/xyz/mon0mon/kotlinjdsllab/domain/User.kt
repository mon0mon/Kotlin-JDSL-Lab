package xyz.mon0mon.kotlinjdsllab.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.ColumnDefault
import java.time.OffsetDateTime

@Entity
class User (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(length = 100, nullable = false)
    var name: String,

    @Column(length = 255, nullable = false)
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    var status: UserStatus = UserStatus.ACTIVE,

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    var role: UserRole = UserRole.USER,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(updatable = false, nullable = false)
    val createdAt: OffsetDateTime = OffsetDateTime.now(),

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(nullable = false)
    var updatedAt: OffsetDateTime = OffsetDateTime.now()

)

enum class UserStatus {
    ACTIVE,
    DELETED
}

enum class UserRole {
    USER,
    ADMIN
}

package xyz.mon0mon.kotlinjdsllab.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.annotations.ColumnDefault
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
class Post (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(length = 500, nullable = false)
    var content: String,

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(updatable = false, nullable = false)
    val createdAt: OffsetDateTime = OffsetDateTime.now(),

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(nullable = false)
    var updatedAt: OffsetDateTime = OffsetDateTime.now()

)

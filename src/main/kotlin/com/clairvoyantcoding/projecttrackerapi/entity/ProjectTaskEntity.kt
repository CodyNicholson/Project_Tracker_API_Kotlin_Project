package com.clairvoyantcoding.projecttrackerapi.entity

import com.clairvoyantcoding.projecttrackerapi.model.ProjectTaskDto
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "project_task")
class ProjectTaskEntity {
    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private val id: UUID? = null
    private val projectId: UUID? = null
    private val name: String? = null
    private val description: String? = null
    private val acceptanceCriteria: String? = null
    private val points: Double? = null
    private val status: String? = null

    fun toDto(): ProjectTaskDto {
        return ProjectTaskDto(this.id, this.projectId, this.name, this.description, this.acceptanceCriteria, this.points, this.status)
    }
}
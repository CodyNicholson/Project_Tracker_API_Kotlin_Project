package com.clairvoyantcoding.projecttrackerapi.entity

import com.clairvoyantcoding.projecttrackerapi.model.ProjectDto
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "project")
class ProjectEntity {
    @Id
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private val id: UUID? = null
    private val name: String? = null
    private val description: String? = null
    private val startDate: Date? = null
    private val endDate: Date? = null
    private val deployedLink: String? = null
    private val documentationLink: String? = null
    private val codeLink: String? = null

    fun toDto(): ProjectDto? {
        return ProjectDto(this.id, this.name, this.description, this.startDate, this.endDate, this.deployedLink, this.documentationLink, this.codeLink)
    }
}
package com.clairvoyantcoding.projecttrackerapi.repository

import com.clairvoyantcoding.projecttrackerapi.entity.ProjectTaskEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProjectTaskRepository : CrudRepository<ProjectTaskEntity, UUID> {
    fun getById(projectTaskEntity: ProjectTaskEntity)
}
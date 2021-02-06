package com.clairvoyantcoding.projecttrackerapi.repository

import com.clairvoyantcoding.projecttrackerapi.entity.ProjectEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProjectRepository : CrudRepository<ProjectEntity, UUID>{
    fun getById(projectEntity: ProjectEntity)
}

package com.clairvoyantcoding.projecttrackerapi.model

import java.util.*

data class ProjectTaskDto(
    var id: UUID?,
    var projectId: UUID?,
    var name: String?,
    var description: String?,
    var acceptanceCriteria: String?,
    var points: Double?,
    var status: String?)

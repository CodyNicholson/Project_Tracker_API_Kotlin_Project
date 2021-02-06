package com.clairvoyantcoding.projecttrackerapi.model

import java.util.*

data class ProjectDto(
    var id: UUID?,
    var name: String?,
    var description: String?,
    var startDate: Date?,
    var endDate: Date?,
    var deployedLink: String?,
    var documentationLink: String?,
    var codeLink: String?)

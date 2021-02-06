package com.clairvoyantcoding.projecttrackerapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class ProjectController {

    @GetMapping("/")
    fun getAllProjects(): String {
        return "all projects"
    }
}
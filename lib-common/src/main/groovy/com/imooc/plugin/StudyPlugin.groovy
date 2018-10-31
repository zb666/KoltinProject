package com.imooc.plugin

import org.gradle.api.Project

class StudyPlugin implements org.gradle.api.Plugin<Project>{

    @Override
    void apply(Project project) {
        println "SelftPlugin Test"
    }

}
package eu.xtrf.custom.Task1.macros.services

import com.radzisz.xtrf.filter2.ProjectFilter
import com.radzisz.xtrf.model.dictionary.Category
import com.radzisz.xtrf.model.project.Project
import com.radzisz.xtrf.service.ProjectService
import com.radzisz.xtrf.service.dictionary.CategoryService
import eu.xtrf.custom.breputils.utils.MacroServiceFactory

class Task4Macro {

    def list
    def params

    int categoryId = 52
    ProjectService projectService = MacroServiceFactory.getService(ProjectService)
    CategoryService categoryService = MacroServiceFactory.getService(CategoryService)


    Task4Macro(list, params) {
        this.list = list
        this.params = params
    }

    def runMacro() {
        Category category = categoryService.getById(categoryId,true)


        ProjectFilter filter = projectService.getFilter()
        filter.categories().in(category)
        filter.name().endsWith("Tasks")
        List<Project> projects = projectService.getAll(filter)

        return projects*.name
    }

}

new Task4Macro(list, params).runMacro()
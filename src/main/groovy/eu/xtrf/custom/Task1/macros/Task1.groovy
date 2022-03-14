package eu.xtrf.custom.Task1.macros

import com.radzisz.xtrf.model.project.Project
import com.radzisz.xtrf.utils.velocity.VelocityTagUtils

class Task1Macro {
    List<Project> list
    Map params
    VelocityTagUtils utils = new VelocityTagUtils()

    Task1Macro(List<Project> list, Map params) {
        this.list = list
        this.params = params
    }

    def runMacro() {
        list.each {
            Date date = new Date()
            date +=2
            it.getDateBoundaries().setDeadline(date)

        }

    }
}

new Task1Macro(list, params).runMacro()
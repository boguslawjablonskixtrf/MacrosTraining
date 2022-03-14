package eu.xtrf.custom.Task1.macros.csvki

import com.radzisz.xtrf.model.project.Project
import eu.xtrf.custom.breputils.output.csv.CsvOutput
import eu.xtrf.custom.breputils.output.csv.elements.Header

class Task3csvMacro {

    List<Project> list
    Map params

    Task3csvMacro(List<Project> list, Mapparams) {
        this.list = list
        this.params = params
    }

    def runMacro() {
        CsvOutput csvOutput = new CsvOutput()
        csvOutput.setLineLength(4)
        csvOutput.setSeparator(';' as char)
        Header header = new Header(';' as char, ["name",
                                                 "desc",
                                                 "deadline",
                                                 "idk"])
        csvOutput.setHeader(header)

        list.each {Project project ->
            csvOutput.addLine(project.name
                    ,project.internalDescription
                    ,project.getDateBoundaries().getDeadline()
                    ,project.getId())
        }
return csvOutput.toString()


    }
}

new Task3csvMacro(list, params).runMacro()
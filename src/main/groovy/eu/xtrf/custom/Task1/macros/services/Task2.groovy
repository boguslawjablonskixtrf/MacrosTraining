package eu.xtrf.custom.Task1.macros.services

import com.radzisz.xtrf.model.partner.customer.Customer
import com.radzisz.xtrf.model.partner.customer.CustomerPriceProfile
import com.radzisz.xtrf.model.project.Project
import com.radzisz.xtrf.model.system.User
import com.radzisz.xtrf.service.CustomerService
import com.radzisz.xtrf.service.ProjectService
import com.radzisz.xtrf.service.UserService
import eu.xtrf.custom.breputils.utils.MacroServiceFactory

class Task2Macro {

    def list
    def params

    Task2Macro(list, params) {
        this.list = list
        this.params = params
    }
    ProjectService projectService = MacroServiceFactory.getService(ProjectService)
    CustomerService customerService = MacroServiceFactory.getService(CustomerService)
    UserService userService = MacroServiceFactory.getService(UserService)



    def runMacro() {
        Customer customer = customerService.getById(3372, true)
        CustomerPriceProfile priceProfile = customer.priceProfiles.first()
        User user = userService.getByLogin("bjablonski", true)

        Project project = new Project(priceProfile,user )
        Project project2 = new Project(priceProfile,user )
        projectService.create(project)
        projectService.create(project2)


        return project.toString()+" "+project2.toString()


    }
}

new Task2Macro(list, params).runMacro()
import com.zynx.spike.*

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def user = new User(username: 'user', enabled: true, password: 'password#1')
        user.save(flush: true)
        def admin = new User(username: 'admin', enabled: true, password: 'password#1')
        admin.save(flush: true)

        UserRole.create(user, userRole, true)
        UserRole.create(admin, userRole, true)
        UserRole.create(admin, adminRole, true)

    }

    def destroy = {
    }
}

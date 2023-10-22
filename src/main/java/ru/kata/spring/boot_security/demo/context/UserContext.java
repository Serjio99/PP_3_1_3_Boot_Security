package ru.kata.spring.boot_security.demo.context;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Set;

@Component
public class UserContext implements ApplicationRunner {

    private final RoleService roleService;

    private final UserService userService;


    public UserContext(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");

        Set<Role>adminList = Set.of(admin);

        roleService.save(admin);
        roleService.save(user);

        User adminUser = new User();
        adminUser.setRoles(adminList);
        adminUser.setEmail("9066346633@bk.ru");
        adminUser.setPhoneNumber("777");
        adminUser.setName("Serge");
        adminUser.setSurname("Tsymbalov");
        adminUser.setPassword("555");
        userService.saveUser(adminUser);
    }
}
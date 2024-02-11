package Assissment.Assissment.controller;
import Assissment.Assissment.Model.User;
import Assissment.Assissment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userSer;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.OK)
    public User save(@RequestBody User user){
        return userSer.saveUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user){
        String userName= user.getUserName();
        String password=user.getPassword();
        return userSer.userLogin(userName,password);
    }
}

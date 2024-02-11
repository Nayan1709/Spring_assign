package Assissment.Assissment.Service;

import Assissment.Assissment.Model.User;
import Assissment.Assissment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepo;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepo, TokenService tokenService) {
        this.userRepo = userRepo;
        this.tokenService = tokenService;
    }
    public User saveUser(User user){
        return userRepo.save(user);
    }

    public String userLogin(String userName,String password){
        boolean foundUsers= existByUserName(userName);
        if(foundUsers){
            User user=userRepo.getUserByUserName(userName);
            if(user.getPassword().equals(password)){
                return  "{" +
                        "\"message\":"+"Successfully logged in\",\n"+
                        "\"data\": "+user+",\n"+
                        "\"Email: "+ user.getUserName()+"\n" +
                        "\"token: " + tokenService.createTokenFunction(user.getId()) + "\""+
                        "}";
            }
        }
        return "{" +
                "\"message\":"+"Authentication Failed\",\n"+
                "}";

    }

    public boolean existByUserName(String userName){
        Optional<User> userObj= Optional.ofNullable(userRepo.getUserByUserName(userName));
        if(!userObj.isEmpty())
            return true;
        return false;
    }

}


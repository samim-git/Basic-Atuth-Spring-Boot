package com.hs.basicauth.user;

import com.hs.basicauth.response.RestResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("user")
public class UserController {
    final UserRepo userRepo;
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/registerUser")
    ResponseEntity<Object> registerUser(@RequestBody User user){
        RestResponse res = new RestResponse();
        try{
            User createdUser = userRepo.save(user);
            res.setData(createdUser);
            res.setResponseCode(0);
            res.setMessage("Success");
        }catch (DataIntegrityViolationException e){
            res.setErrorMessage(e.getLocalizedMessage());
            res.setResponseCode(45);
            res.setMessage("This email address is already exist");
        } catch (Exception e){
            res.setErrorMessage(e.getLocalizedMessage());
            res.setResponseCode(34);
            res.setMessage("Unknown Exception");
        }
        return ResponseEntity.ok(res);
    }
    @GetMapping("/getUserProfile")
    ResponseEntity<Object> getUserProfile(@RequestParam(value = "userid", defaultValue = "0") int userId){
       RestResponse res = new RestResponse();
       res.setData(userRepo.findUserById(userId));
        return ResponseEntity.ok(res);
    }
}

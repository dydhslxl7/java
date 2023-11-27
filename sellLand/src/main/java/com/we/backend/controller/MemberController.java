package monthsago.travel16.controller;

import monthsago.travel16.Model.User;
import monthsago.travel16.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    //create user
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return memberService.createUser(user);
    }
}

package com.example.finalproject.api;


import com.example.finalproject.model.User;
import com.example.finalproject.service.impl.MyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {
    private final MyServiceImpl myServiceImpl;
    @GetMapping
    public String getAuth(){
        return "hello";
    }

    @PostMapping("/registr")
    public String getRegistr(@RequestBody User user){
        myServiceImpl.register(user);
        return "done";
    }

}

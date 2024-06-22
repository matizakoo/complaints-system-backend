package pl.tanielazienki.tanielazienki.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.tanielazienki.tanielazienki.user.UserRegistrationDTO;
import pl.tanielazienki.tanielazienki.user.UserService;

@RestController
@RequestMapping("/api/v1/")
public class TestController {

    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody UserRegistrationDTO userRegisterationDto) {
        System.out.println("xxx");
        userService.register(userRegisterationDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/unsecured", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> unsecured() {
        return new ResponseEntity<>("{\"msg\":\"Hello unsecure World\"}", HttpStatus.OK);
    }

    @GetMapping(value = "/register",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerL() {
        return new ResponseEntity<>("{\"msg\":\"Hello secure World\"}", HttpStatus.OK);
    }

    @GetMapping(value = "/secured", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> secured() {
        return new ResponseEntity<>("{\"msg\":\"Hello secure World\"}", HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/secured-admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> securedForAdmin() {
        return new ResponseEntity<>("{\"msg\":\"Hello admin\"}", HttpStatus.OK);
    }
}
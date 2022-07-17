package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.AccountDTO;
import al.sda.finalproject.bakeoff.dto.UserDTO;
import al.sda.finalproject.bakeoff.entity.UserEntity;
import al.sda.finalproject.bakeoff.exception.EmailExistException;
import al.sda.finalproject.bakeoff.exception.UserNotFoundException;
import al.sda.finalproject.bakeoff.exception.UsernameExistException;
import al.sda.finalproject.bakeoff.repository.UserRepository;
import al.sda.finalproject.bakeoff.security.JwtUtils;
import al.sda.finalproject.bakeoff.service.AccountService;
import al.sda.finalproject.bakeoff.service.UserService;
import al.sda.finalproject.bakeoff.utils.LoginResponse;
import al.sda.finalproject.bakeoff.utils.SignInModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder encoder;

    private final UserRepository userRepository;
    private final UserService userService;

    JwtUtils jwtUtils;
    public AuthenticationController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, UserService userService, UserRepository userRepository){
        this.authenticationManager = authenticationManager;
        this.encoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody SignInModel signInModel) throws UserNotFoundException, EmailExistException, UsernameExistException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInModel.getUsername(), signInModel.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserEntity user = this.userRepository.findUserEntityByUsername(signInModel.getUsername());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("jwtToken", jwt);
        LoginResponse loginResponse = new LoginResponse(user, jwt);
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(loginResponse);
    }

    @PostMapping("/user-add")
    public ResponseEntity<UserDTO>addUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(this.userService.add(userDTO), HttpStatus.OK);
    }
}

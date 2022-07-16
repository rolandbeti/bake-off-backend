package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.AccountDTO;
import al.sda.finalproject.bakeoff.dto.AuthorityDTO;
import al.sda.finalproject.bakeoff.service.AccountService;
import al.sda.finalproject.bakeoff.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorityController {

    private AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService){
        this. authorityService =  authorityService;
    }

    @GetMapping("/authority")
    public ResponseEntity<List<AuthorityDTO>> getAllAuthoritys(){
        return new ResponseEntity<>(this. authorityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/authority/{id}")
    public ResponseEntity<AuthorityDTO>getAuthorityById(@PathVariable Long id){
        return new ResponseEntity<>(this. authorityService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/authority/{id}")
    public ResponseEntity<Void>deleteAuthorityById(@PathVariable Long id){
        this. authorityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/authority")
    public ResponseEntity<Void>addAuthority(@RequestBody AuthorityDTO authorityDTO){
        this. authorityService.save(authorityDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

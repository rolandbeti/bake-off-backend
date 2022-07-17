package al.sda.finalproject.bakeoff.controller;

import al.sda.finalproject.bakeoff.dto.AccountDTO;
import al.sda.finalproject.bakeoff.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class AccountController {

    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        return new ResponseEntity<>(this.accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDTO>getAccountById(@PathVariable Long id){
        return new ResponseEntity<>(this.accountService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/accountss/{id}")
    public ResponseEntity<Void>deleteAccountById(@PathVariable Long id){
        this.accountService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Void>addAccount(@RequestBody AccountDTO accountDTO){
        this.accountService.save(accountDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package main.java.br.com.fiap.doctorchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dindin.models.Credencial;
import br.com.fiap.dindin.models.Cadastro;
import br.com.fiap.dindin.repository.CadastroRepository;
import br.com.fiap.dindin.service.TokenJwtService;
import jakarta.validation.Valid;

@RestController
public class CadastroControlle {

    @Autowired
    CadastroRepository repository;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenJwtService tokenJwtService;

    @PostMapping("/api/cadastro")
    public ResponseEntity<Cadastro> registrar(@RequestBody @Valid Cadastro cadastro){
        cadastro.setSenha(encoder.encode(cadastro.getSenha()));
        repository.save(cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
    }

    @PostMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial){
        manager.authenticate(credencial.toAuthentication());
        var token = tokenJwtService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }
    
}
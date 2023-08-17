package com.ishqelliot.auth.controller;

import com.ishqelliot.auth.entity.UserInfo;
import com.ishqelliot.auth.model.CrudDto;
import com.ishqelliot.auth.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CrudController {

    @Autowired
    private CrudService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<CrudDto> getAllTheProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public CrudDto getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }
}

package com.ishqelliot.auth.controller;

import com.ishqelliot.auth.model.CrudDto;
import com.ishqelliot.auth.service.CrudService;
import com.ishqelliot.auth.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CrudController {

    @Autowired
    private CrudService crudService;

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<CrudDto> getAllTheProducts() {
        return crudService.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public CrudDto getProductById(@PathVariable int id) {
        return crudService.getProduct(id);
    }
}

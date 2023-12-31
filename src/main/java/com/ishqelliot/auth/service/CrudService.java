package com.ishqelliot.auth.service;

import com.ishqelliot.auth.entity.UserInfo;
import com.ishqelliot.auth.model.CrudDto;
import com.ishqelliot.auth.repository.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CrudService {
    List<CrudDto> productList = null;

    @PostConstruct
    public void loadProductsFromDB() {
        productList = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> CrudDto.builder()
                        .productId(i)
                        .name("product " + i)
                        .qty(new Random().nextInt(10))
                        .price(new Random().nextInt(5000)).build()
                ).collect(Collectors.toList());
    }


    public List<CrudDto> getProducts() {
        return productList;
    }

    public CrudDto getProduct(int id) {
        return productList.stream()
                .filter(product -> product.getProductId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    }

}

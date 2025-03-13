package com.java.yajoba_querylab.global;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InitController {
    private final CategoryInitService categoryInitService;
    private final ProductDataInitService productDataInitService;
    @GetMapping("/category")
    public void initCategories() throws Exception {
        categoryInitService.run();
    }

    @GetMapping("/products")
    public void initProducts() throws Exception {
        productDataInitService.run();
    }
}

package de.ait.ksdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
@Controller
public class RootController {

    @Value("${app.root-redirect-url}")
    private String redirectUrl;

    @GetMapping("/")
    public String redirect() {
        return "redirect:/" + redirectUrl;
    }
}

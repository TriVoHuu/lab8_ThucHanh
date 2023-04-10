package com.example.lab8_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contactGet(Model model) {
        return "contact";
    }

    @PostMapping("/contact")
    public String contactPost(@RequestParam String name, @RequestParam String email, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "response";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "About this site";
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, Model model) {
        String message = "HTTP " + ex.getMethod() + " method is not supported for this request";
        model.addAttribute("errorMessage", message);
        return "error";
    }

    @RequestMapping(value = "/**")
    public String handleInvalidUrls(Model model) {
        model.addAttribute("errorMessage", "Invalid URL");
        return "error";
    }
}



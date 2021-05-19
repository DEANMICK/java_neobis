package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.User;
import com.example.demo.Form.UserRegisterForm;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getMainPage(Model model, Principal principal) {
        model.addAttribute("user", principal);
        return "index";
    }

    @GetMapping("/detail")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.findAllUser());
        return "detail";
    }

    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal) {
        var user = userService.findUserByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }

    @GetMapping("/search")
    public String getUserByName(@RequestParam("name") String name,
                                Model model) {
        List<User> users = userService.findUserByName(name);
        model.addAttribute("foodByName", users);
        return "search";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new UserRegisterForm());
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterForm userRegisterForm, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("dto", userRegisterForm);
        userService.register(userRegisterForm);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }
}

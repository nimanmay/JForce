package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;
import com.example.model.Event;
import com.example.model.User;
import com.example.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {

        Optional<User> user =
                userRepository.findByUsername(username);

        if(user.isPresent() &&
           user.get().getPassword().equals(password)) {

            return "redirect:/events.html";
        }

        return "redirect:/login.html";
    }
    @GetMapping("/create-event")
    public String showCreateEventPage() {
        return "create-event";
    }

    @PostMapping("/createEvent")
    public String createEvent(
            @RequestParam String eventName,
            @RequestParam String eventDate,
            @RequestParam String location,
            @RequestParam String details) {

        System.out.println(eventName);
        System.out.println(eventDate);
        System.out.println(location);
        System.out.println(details);

        return "redirect:/event-management";
    }

    @GetMapping("/event-management")
    public String eventManagement() {
        return "event-management";
    }
    
    @PostMapping("/Reg")
    public String register(@ModelAttribute User user) {

        user.setRole("USER");

        userRepository.save(user);

        return "redirect:/login";
    }
    
    @PostMapping("/registerEvent")
    public String registerEvent(
            @RequestParam Long eventId,
            HttpSession session) {

        User user =
            (User) session.getAttribute("user");

        Registration registration =
                new Registration();

        registration.setUserId(user.getId());
        registration.setEventId(eventId);

        registrationRepository.save(registration);

        return "redirect:/events";
    }
    @GetMapping("/admin/add-event")
    public String addEventPage() {
        return "create-event";
    }

    @PostMapping("/admin/add-event")
    public String addEvent(@ModelAttribute Event event) {

        eventRepository.save(event);

        return "redirect:/admin/events";
    }
}
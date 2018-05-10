package me.soulyana.springsecuritybasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    AppUserRepository users;

    @Autowired
    AppRoleRepository roles;

    @Autowired
    CategoryRepository categories;

    @RequestMapping("/register")
    public String registerNewUser(Model model) {
        model.addAttribute("aUser", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String processNewUser(@Valid @ModelAttribute("aUser") AppUser user, BindingResult result) {
        if(result.hasErrors()) {
            return "register";
        } else {
            users.save(user);
        }
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/addcategory")
    public String addCategories(Model model) {
        model.addAttribute("aCategory", new Category());
        return "addcategory";
    }

    @PostMapping("/addcategory")
    public String addCategories(@Valid @ModelAttribute("aCategory") Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "addcategory";
        } else {
            categories.save(category);
        }
        return "redirect:/";
    }

    @RequestMapping("/")
    public String showIndex(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=595fb788918a4fdcb687e51bcd5b06f7", News.class);
        model.addAttribute("articles", news.getArticles());
        return "index";
    }

    @RequestMapping("/entertainment")
    public String showEntertainment(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=entertainment&apiKey=595fb788918a4fdcb687e51bcd5b06f7", News.class);
        model.addAttribute("articles", news.getArticles());
        return "entertainment";
    }

    @RequestMapping("/business")
    public String showBusiness(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=595fb788918a4fdcb687e51bcd5b06f7", News.class);
        model.addAttribute("articles", news.getArticles());
        return "business";
    }

    @RequestMapping("/general")
    public String showGeneral(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=general&apiKey=595fb788918a4fdcb687e51bcd5b06f7", News.class);
        model.addAttribute("articles", news.getArticles());
        return "general";
    }

    @RequestMapping("/health")
    public String showHealth(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=595fb788918a4fdcb687e51bcd5b06f7", News.class);
        model.addAttribute("articles", news.getArticles());
        return "health";
    }

    @RequestMapping("/science")
    public String showScience(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=science&apiKey=595fb788918a4fdcb687e51bcd5b06f7", News.class);
        model.addAttribute("articles", news.getArticles());
        return "science";
    }
    @RequestMapping("/sports")
    public String showSports(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=595fb788918a4fdcb687e51bcd5b06f7", News.class);
        model.addAttribute("articles", news.getArticles());
        return "sports";
    }

    @RequestMapping("/technology")
    public String showTechnology(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?country=us&category=technology&apiKey=595fb788918a4fdcb687e51bcd5b06f7", News.class);
        model.addAttribute("articles", news.getArticles());
        return "technology";
    }
}

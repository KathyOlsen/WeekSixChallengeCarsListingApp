package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());

        return "index";
    }

    @GetMapping("/addcategory")
    public String categoryForm(Model model){
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/processcategory")
    public String processCategoryForm(@Valid Category category, BindingResult result){
        if (result.hasErrors()){
            return "categoryform";
        }
        categoryRepository.save(category);

        return "redirect:/categorylist";
    }

    @RequestMapping("/categorylist")
    public String categoryList(Model model){
        model.addAttribute("categories", categoryRepository.findAll());

        return "categorylist";
    }

    @GetMapping("/addcar")
    public String carForm(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/processcar")
    public String processCarForm(@Valid Car car, BindingResult result, int price){
        if (result.hasErrors()){
            return "carform";
        }
        String priceString = "$" + String.format("%,d", price);
        car.setPriceString(priceString);
        carRepository.save(car);

        return "redirect:/carlist";
    }

    @RequestMapping("/carlist")
    public String carList(Model model){
        model.addAttribute("cars", carRepository.findAll());

        return "carlist";
    }

    @RequestMapping("/detail_category/{id}")
    public String showCategory(@PathVariable("id") long id, Model model){
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "showcategory";
    }

    @RequestMapping("/update_category/{id}")
    public String updateCategory(@PathVariable("id") long id, Model model){
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "categoryform";
    }

    @RequestMapping("/delete_category/{id}")
    public String delCategory(@PathVariable("id") long id){
        categoryRepository.deleteById(id);
        return "index";
    }

    @RequestMapping("/detail_car/{id}")
    public String showCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "showcar";
    }

    @RequestMapping("/update_car/{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        model.addAttribute("categories",categoryRepository.findAll());
        return "carform";
    }

    @RequestMapping("/delete_car/{id}")
    public String delCar(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "index";
    }
}

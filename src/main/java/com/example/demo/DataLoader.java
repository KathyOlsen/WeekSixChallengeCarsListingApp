package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... strings) throws Exception{
        Category category;
        category = new Category("Hatchback");
        categoryRepository.save(category);

        category = new Category("Coupe");
        categoryRepository.save(category);

        category = new Category("Sedan");
        categoryRepository.save(category);

        category = new Category("Electric/Hybrid");
        categoryRepository.save(category);

        category = new Category("Wagon");
        categoryRepository.save(category);

        category = new Category("Minivan/Van");
        categoryRepository.save(category);

        category = new Category("SUV");
        categoryRepository.save(category);

        category = new Category("Crossover");
        categoryRepository.save(category);

        category = new Category("Light Truck");
        categoryRepository.save(category);

        Category hatchback = categoryRepository.findByCategoryNameEquals("Hatchback");
        Category coupe = categoryRepository.findByCategoryNameEquals("Coupe");
        Category sedan = categoryRepository.findByCategoryNameEquals("Sedan");
        Category electric = categoryRepository.findByCategoryNameEquals("Electric/Hybrid");
        Category wagon = categoryRepository.findByCategoryNameEquals("Wagon");
        Category minivan = categoryRepository.findByCategoryNameEquals("Minivan/Van");
        Category suv = categoryRepository.findByCategoryNameEquals("SUV");
        Category crossover = categoryRepository.findByCategoryNameEquals("Crossover");
        Category truck = categoryRepository.findByCategoryNameEquals("Light Truck");

        Car car;
        car=new Car("Toyota","Sienna AWD Limited",2006,"Silver",minivan,6000);
        carRepository.save(car);

        car=new Car("Nissan","Maxima V6 ",2008,"Red",sedan,4000);
        carRepository.save(car);

        car=new Car("Toyota","Camry LE",2016,"Beige",sedan,12000);
        carRepository.save(car);

        car=new Car("Ford","F 150",2019,"Blue",truck,38000);
        carRepository.save(car);

        car=new Car("Chevrolet","Camaro ZL1",2019,"Red",coupe,58800);
        carRepository.save(car);

        car=new Car("Audi","Q7 3.0T Premium Plus",2018,"White",suv,43900);
        carRepository.save(car);

        car=new Car("Toyota","Highlander",2017,"Black",suv,40000);
        carRepository.save(car);
    }
}

package org.sample.springboot.future.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.sample.springboot.future.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.sample.springboot.future.dao.entity.Car;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity uploadFile(@RequestParam(value = "files") MultipartFile[] files) {
        try {
            for (final MultipartFile file : files) {
                carService.saveCars(file.getInputStream());
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (final Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody CompletableFuture<ResponseEntity> getAllCars() /* throws InterruptedException */ {
//        CompletableFuture<List<Car>> cars1 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars2 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars3 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars4 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars5 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars6 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars7 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars8 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars9 = carService.getAllCars();
//        CompletableFuture<List<Car>> cars10 = carService.getAllCars();
//        CompletableFuture.allOf(cars1, cars2, cars3, cars4, cars5, cars6, cars7, cars8, cars9, cars10).join();
        return carService.getAllCars().<ResponseEntity>thenApply(ResponseEntity::ok).exceptionally(handleGetCarFailure);
    }

    private static Function<Throwable, ResponseEntity<? extends List<Car>>> handleGetCarFailure = throwable -> {
        LOGGER.error("Failed to read records: {}", throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    };
}

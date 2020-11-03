package org.sample.springboot.future.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import org.sample.springboot.future.dao.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sample.springboot.future.dao.entity.Car;
import org.springframework.scheduling.annotation.Async;

@Service
public class CarService {
    
    private static Logger LOGGER = LoggerFactory.getLogger(CarService.class);
    
    @Autowired
    private CarRepository carRepository;
    
    @Async
    public CompletableFuture<List<Car>> saveCars(final InputStream inputStream) throws Exception {
        final long start = System.currentTimeMillis();
        
        List<Car> cars = parseCSV(inputStream);
        
        LOGGER.info("Saving a list of cars of size {} records", cars.size());
        cars = carRepository.saveAll(cars);
        LOGGER.info("Elapsed time: {}", (System.currentTimeMillis() - start));
        
        return CompletableFuture.completedFuture(cars);
    }

    private List<Car> parseCSV(final InputStream inputStream) throws Exception {

        final List<Car> cars = new ArrayList<>();
        try {
            final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = br.readLine()) != null) {
                final String[] data = line.split(";");
                final Car car = new Car();
                car.setManufacturer(data[0]);
                car.setModel(data[1]);
                car.setType(data[2]);
                
                cars.add(car);
            }
            
            return cars;
        } catch (IOException ex) {
            LOGGER.error("Failed to parse CSV file {}", ex);
            throw new Exception("Failed to parse CSV file {}", ex);
        }
    }
    
    @Async
    public CompletableFuture<List<Car>> getAllCars() /* throws InterruptedException */ {
        
//        Thread.sleep(1000L);
        LOGGER.info("Request to get a list of cars");
        final List<Car> cars = carRepository.findAll();
        
        return CompletableFuture.completedFuture(cars);
    }
}

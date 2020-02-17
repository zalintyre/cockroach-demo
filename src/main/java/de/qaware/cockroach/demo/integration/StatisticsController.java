package de.qaware.cockroach.demo.integration;

import de.qaware.cockroach.demo.car.CarRepository;
import de.qaware.cockroach.demo.dealer.DealerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class StatisticsController {

    @Inject
    private CarRepository carRepository;

    @Inject
    private DealerRepository dealerRepository;

    public Map<String, Object> getStatisticsForBrand(String brand) {
        Map<String, Object> statistics = new HashMap<>();
        statistics.put("Car count", carRepository.count());
        statistics.put("Dealer count", dealerRepository.count());
        statistics.put("Car count for dealers named roger", dealerRepository.getCarCountForDealersNamedRoger());
        statistics.put("", dealerRepository.getDealersWithMostCarsOfBrand(brand));
        return statistics;
    }
}

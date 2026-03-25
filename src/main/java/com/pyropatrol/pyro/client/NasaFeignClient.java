package com.pyropatrol.pyro.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "nasaClient", url = "https://firms.modaps.eosdis.nasa.gov/api/area/csv")
public interface NasaFeignClient {

    @GetMapping("/{key}/VIIRS_SNPP_NRT/{coords}/{days}")
    String getFireData(
            @PathVariable("key") String apiKey,
            @PathVariable("coords") String coords,
            @PathVariable("days") int days
    );
}
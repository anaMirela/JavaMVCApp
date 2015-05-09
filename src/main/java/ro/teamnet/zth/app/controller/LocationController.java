package ro.teamnet.zth.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.domain.Location;
import ro.teamnet.zth.app.service.LocationServiceImpl;

import java.util.List;

/**
 * Created by Mi on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/locations")
public class LocationController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Location> getAllLocations() {
        LocationServiceImpl locationService = new LocationServiceImpl();
        return locationService.findAllLocations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Location getOneLocation(@PathVariable("id") String idLocation) {
        LocationServiceImpl locationService = new LocationServiceImpl();
        return locationService.findOneLocation(Integer.valueOf(idLocation));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteLocation(@PathVariable("id") String idLocation) {
        LocationServiceImpl locationService = new LocationServiceImpl();
        locationService.deleteLocation(Integer.valueOf(idLocation));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void save(@RequestBody Location location) {
        LocationServiceImpl locationService = new LocationServiceImpl();
        locationService.saveLocation(location);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestBody Location location) {
        LocationServiceImpl locationService = new LocationServiceImpl();
        locationService.updateLocation(location);
    }
}
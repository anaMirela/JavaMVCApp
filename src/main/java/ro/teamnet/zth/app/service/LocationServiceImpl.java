package ro.teamnet.zth.app.service;

import ro.teamnet.zth.app.dao.LocationDao;
import ro.teamnet.zth.app.domain.Location;

import java.util.List;

/**
 * Created by Mi on 5/8/2015.
 */
public class LocationServiceImpl implements LocationService {
    @Override
    public List<Location> findAllLocations() {
        LocationDao locationDao = new LocationDao();
        return locationDao.getAllLocations();
    }

    @Override
    public Location findOneLocation(int id) {
        LocationDao locationDao = new LocationDao();
        return locationDao.getLocationById(id);
    }

    @Override
    public void deleteLocation(int id) {
        LocationDao locationDao = new LocationDao();
        locationDao.deleteLocation(locationDao.getLocationById(id));
    }

    @Override
    public void saveLocation(Location location) {
        LocationDao locationDao = new LocationDao();
        locationDao.insertLocation(location);
    }

    @Override
    public void updateLocation(Location location) {
        LocationDao locationDao = new LocationDao();
        locationDao.updateLocation(location);
    }
}

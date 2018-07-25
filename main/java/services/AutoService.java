package services;

import dao.AutoDao;
import models.Auto;
import models.User;

import java.util.List;

public class AutoService {

    private AutoDao autosDao = new AutoDao();

    public AutoService() {
    }

    public Auto findAuto(int id) {
        return autosDao.findById(id);
    }

    public void saveAuto(Auto auto) {
        autosDao.save(auto);
    }

    public void deleteAuto(Auto auto) {
        autosDao.delete(auto);
    }

    public void updateAuto(Auto auto) {
        autosDao.update(auto);
    }

    public List<Auto> findAllAutos() {
        return autosDao.findAll();
    }

    public List<Auto> findAutosByModel(String model) {
        return autosDao.findByModel(model);
    }

    public User findUserById(int id) {
        return autosDao.findUserById(id);
    }


    public User findUserByAuto(Auto auto) {
        return autosDao.findUserByAuto(auto);
    }


}
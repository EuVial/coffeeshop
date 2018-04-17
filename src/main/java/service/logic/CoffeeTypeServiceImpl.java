package service.logic;

import dao.PersistException;
import dao.mysql.coffee.MySqlCoffeeTypeDao;
import domain.coffee.CoffeeType;
import service.ServiceException;
import service.coffee.CoffeeTypeService;

import java.util.List;

public class CoffeeTypeServiceImpl implements CoffeeTypeService {
    //TODO: LOGGER
    private MySqlCoffeeTypeDao coffeeTypeDao;

    public void setCoffeeTypeDao(final MySqlCoffeeTypeDao coffeeTypeDao) {
        this.coffeeTypeDao = coffeeTypeDao;
    }

    @Override
    public CoffeeType findById(final Integer id) throws ServiceException {
        try {
            return coffeeTypeDao.read(id);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<CoffeeType> findAll() throws ServiceException {
        try {
            return coffeeTypeDao.getAll();
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(final CoffeeType coffeeType) throws ServiceException {
        try {
            coffeeTypeDao.create(coffeeType);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean canDelete(final CoffeeType coffeeType) throws ServiceException {
        try {
            return !coffeeTypeDao.isInitiatesTransfers(coffeeType);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(final CoffeeType coffeeType) throws ServiceException {
        if (coffeeType.getId() != null) {
            try {
                coffeeTypeDao.delete(coffeeType);
            } catch (PersistException e) {
                throw new ServiceException(e);
            }
        }
    }
}

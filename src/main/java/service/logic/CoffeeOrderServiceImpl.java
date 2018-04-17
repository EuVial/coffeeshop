package service.logic;

import dao.PersistException;
import dao.mysql.coffee.MySqlCoffeeOrderDao;
import domain.coffee.CoffeeOrder;
import service.ServiceException;
import service.coffee.CoffeeOrderService;

import java.util.List;

public class CoffeeOrderServiceImpl implements CoffeeOrderService {
    //TODO: LOGGER
    private MySqlCoffeeOrderDao coffeeOrderDao;

    public void setCoffeeOrderDao(final MySqlCoffeeOrderDao coffeeOrderDao) {
        this.coffeeOrderDao = coffeeOrderDao;
    }

    @Override
    public CoffeeOrder findById(final Integer id) throws ServiceException {
        try {
            return coffeeOrderDao.read(id);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<CoffeeOrder> findAll() throws ServiceException {
        try {
            return coffeeOrderDao.getAll();
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void save(final CoffeeOrder coffeeOrder) throws ServiceException {
        try {
            coffeeOrderDao.create(coffeeOrder);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean canDelete(final CoffeeOrder coffeeOrder) throws ServiceException {
        try {
            return !coffeeOrderDao.isInitiatesTransfers(coffeeOrder);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(final CoffeeOrder coffeeOrder) throws ServiceException {
        if (coffeeOrder.getId() != null) {
            try {
                coffeeOrderDao.delete(coffeeOrder);
            } catch (PersistException e) {
                throw new ServiceException(e);
            }
        }
    }
}

//package service.logic;
//
//import dao.PersistException;
//import domain.coffee.CoffeeOrderItem;
//import service.ServiceException;
//import service.coffee.CoffeeOrderItemService;
//
//import java.util.List;
//
//public class CoffeeOrderItemServiceImpl implements CoffeeOrderItemService {
//    //TODO: LOGGER
//    private MySqlCoffeeOrderItemDao coffeeOrderItemDao;
//
//    public void setCoffeeOrderItemDao(final MySqlCoffeeOrderItemDao coffeeOrderItemDao) {
//        this.coffeeOrderItemDao = coffeeOrderItemDao;
//    }
//
//    @Override
//    public CoffeeOrderItem findById(final Integer id) throws ServiceException {
//        try {
//            return coffeeOrderItemDao.read(id);
//        } catch (PersistException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    @Override
//    public List<CoffeeOrderItem> findAll() throws ServiceException {
//        try {
//            return coffeeOrderItemDao.getAll();
//        } catch (PersistException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    @Override
//    public void save(final CoffeeOrderItem coffeeOrderItem) throws ServiceException {
//        try {
//            coffeeOrderItemDao.create(coffeeOrderItem);
//        } catch (PersistException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    @Override
//    public boolean canDelete(final CoffeeOrderItem coffeeOrderItem) throws ServiceException {
//        try {
//            return !coffeeOrderItemDao.isInitiatesTransfers(coffeeOrderItem);
//        } catch (PersistException e) {
//            throw new ServiceException(e);
//        }
//    }
//
//    @Override
//    public void delete(final CoffeeOrderItem coffeeOrderItem) throws ServiceException {
//        if (coffeeOrderItem.getId() != null) {
//            try {
//                coffeeOrderItemDao.delete(coffeeOrderItem);
//            } catch (PersistException e) {
//                throw new ServiceException(e);
//            }
//        }
//    }
//}
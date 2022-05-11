package service;

import entity.Entity;

//common interface to be implemented by all persistence services. 
public interface PersistenceService<T extends Entity>
{
    void save(T entity);

    void delete(T entity);

    T findById(Long id);

    // This method has been removed since it's only used in a single class, and it was breaking the Interface
    // Segregation principle because this interface was being implemented in a class that this method didn't make sense.
//    List<T> findByName(String name);

}

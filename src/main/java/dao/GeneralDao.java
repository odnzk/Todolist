package dao;

public interface GeneralDao <T>{
    void insert(T item);
    void delete(T item);
    void update(T item);
}

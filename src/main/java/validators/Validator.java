package validators;

public interface Validator<T> {
    boolean validate(T entity);
}

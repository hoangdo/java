package phx.em.service;

import java.util.List;

import phx.em.model.Customer;

public interface CustomerService {
	List<Customer> getAll();

	Customer getById(Long id);

	void delete(Customer customer);

	void save(Customer customer);
}

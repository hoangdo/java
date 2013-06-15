package phx.em.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import phx.em.model.Customer;
import phx.em.repository.CustomerRepository;
import phx.em.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Long id) {
		return customerRepository.findOne(id);
	}

	@Override
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
}

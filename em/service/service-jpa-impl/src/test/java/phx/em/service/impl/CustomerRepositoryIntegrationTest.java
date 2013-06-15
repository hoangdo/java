/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package phx.em.service.impl;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import phx.em.model.Customer;
import phx.em.model.EmailAddress;
import phx.em.repository.CustomerRepository;

/**
 * Integration tests for {@link CustomerRepository}.
 */
public class CustomerRepositoryIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	CustomerRepository repository;

	@Test
	public void findsCustomerById() {
		Customer customer = repository.findOne(1L);

		assertThat(customer, is(notNullValue()));
		assertThat(customer.getFirstname(), is("Dave"));
		assertThat(customer.getLastname(), is("Matthews"));
	}

	@Test
	public void savesNewCustomer() {
		Customer stefan = new Customer("Stefan", "Lassard");
		Customer result = repository.save(stefan);

		assertThat(result, is(notNullValue()));
		assertThat(result.getId(), is(notNullValue()));
		assertThat(result.getFirstname(), is("Stefan"));
		assertThat(result.getLastname(), is("Lassard"));
	}

	@Test
	public void savesExistingCustomer() {
		Customer dave = repository.findOne(1L);
		dave.setEmailAddress(new EmailAddress("davematthews@dmband.com"));
		repository.save(dave);

		Customer result = repository.findOne(1L);

		assertThat(result, is(notNullValue()));
		assertThat(result.getId(), is(notNullValue()));
		assertThat(result.getFirstname(), is("Dave"));
		assertThat(result.getEmailAddress(), is(new EmailAddress("davematthews@dmband.com")));
	}

	@Test
	public void findsCustomersByEmailAddress() {
		Customer result = repository.findByEmailAddress(new EmailAddress("dave@dmband.com"));
		assertThat(result, is(notNullValue()));
		assertThat(result.getFirstname(), is("Dave"));
		assertThat(result.getLastname(), is("Matthews"));
	}

	@Test
	public void findsAllCustomers() {
		List<Customer> customers = repository.findAll();
		assertThat(customers, hasSize(3));
	}

	@Test
	public void deletesCustomer() {
		repository.delete(1L);
		assertThat(repository.findOne(1L), is(nullValue()));
	}

	@Test
	public void accessesCustomersPageByPage() {
		Page<Customer> result = repository.findAll(new PageRequest(1, 1));

		assertThat(result, is(notNullValue()));
		assertThat(result.isFirstPage(), is(false));
		assertThat(result.isLastPage(), is(false));
		assertThat(result.getNumberOfElements(), is(1));
	}
}

package io.xkapil.chap2.good_code.step3_generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kmalhotra on 18-02-2016.
 */
public class Customer {

    public static List<Customer> customers = new ArrayList<>();

    private String name;
    private String city;
    private String domain;
    private boolean enabled = true;

    public static List<String> getEnabledCustomerNames() {
        return getEnabledCustomerInfoByField(new Customer2NameConverter());
    }

    public static List<String> getEnabledCustomerCities() {
        return getEnabledCustomerInfoByField(new Customer2CityConverter());
    }

    public static List<String> getEnabledCustomerDomains() {
        return getEnabledCustomerInfoByField(new Customer2DomainConverter());
    }

    public static List<Customer> getEnabledCustomers() {
        return getEnabledCustomerInfoByField(new Customer2CustomerConverter());
    }

    private static <T> List<T> getEnabledCustomerInfoByField(Converter<Customer, T> converter) {
        List<T> list = new ArrayList<>();
        for (Customer customer : Customer.customers) {
            if (customer.enabled) {
                list.add(converter.convert(customer));
            }
        }
        return list;
    }

    private interface Converter<S, T> {
        public T convert(S customer);
    }

    private static class Customer2NameConverter implements Converter<Customer, String> {
        @Override
        public String convert(Customer customer) {
            return customer.name;
        }
    }

    private static class Customer2CityConverter implements Converter<Customer, String> {
        @Override
        public String convert(Customer customer) {
            return customer.city;
        }
    }

    private static class Customer2DomainConverter implements Converter<Customer, String> {
        @Override
        public String convert(Customer customer) {
            return customer.domain;
        }
    }

    /* This wouldn't have been possible without Generics*/
    private static class Customer2CustomerConverter implements Converter<Customer, Customer> {
        @Override
        public Customer convert(Customer customer) {
            return customer;
        }
    }

}

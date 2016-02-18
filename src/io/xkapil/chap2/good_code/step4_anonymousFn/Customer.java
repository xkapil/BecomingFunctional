package io.xkapil.chap2.good_code.step4_anonymousFn;

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
        return getEnabledCustomerInfoByField(new Converter<Customer, String>() {
            @Override
            public String convert(Customer customer) {
                return customer.name;
            }
        });
    }

    public static List<String> getEnabledCustomerCities() {
        return getEnabledCustomerInfoByField(new Converter<Customer, String>() {
            @Override
            public String convert(Customer customer) {
                return customer.city;
            }
        });
    }

    public static List<String> getEnabledCustomerDomains() {
        return getEnabledCustomerInfoByField(new Converter<Customer, String>() {
            @Override
            public String convert(Customer customer) {
                return customer.domain;
            }
        });
    }

    public static List<Customer> getEnabledCustomers() {
        return getEnabledCustomerInfoByField(new Converter<Customer, Customer>() {
            @Override
            public Customer convert(Customer customer) {
                return customer;
            }
        });
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

}

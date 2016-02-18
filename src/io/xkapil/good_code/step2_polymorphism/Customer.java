package io.xkapil.good_code.step2_polymorphism;

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

    private static List<String> getEnabledCustomerInfoByField(Converter converter) {
        List<String> list = new ArrayList<>();
        for (Customer customer : Customer.customers) {
            if (customer.enabled) {
                list.add(converter.convert(customer));
            }
        }
        return list;
    }

    private interface Converter {
        public String convert(Customer customer);
    }

    private static class Customer2NameConverter implements Converter {
        @Override
        public String convert(Customer customer) {
            return customer.name;
        }
    }

    private static class Customer2CityConverter implements Converter {
        @Override
        public String convert(Customer customer) {
            return customer.city;
        }
    }

    private static class Customer2DomainConverter implements Converter {
        @Override
        public String convert(Customer customer) {
            return customer.domain;
        }
    }
}



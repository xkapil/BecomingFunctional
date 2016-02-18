package io.xkapil.bad_code;

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
        List<String> names = new ArrayList<>();
        for (Customer customer : Customer.customers) {
            if (customer.enabled == true) {
                names.add(customer.name);
            }
        }
        return names;
    }

    public static List<String> getEnabledCustomerCities() {
        List<String> cities = new ArrayList<>();
        for (Customer customer : Customer.customers) {
            if (customer.enabled == true) {
                cities.add(customer.city);
            }
        }
        return cities;
    }

    public static List<String> getEnabledCustomerDomains() {
        List<String> domains = new ArrayList<>();
        for (Customer customer : Customer.customers) {
            if (customer.enabled == true) {
                domains.add(customer.domain);
            }
        }
        return domains;
    }
}

package io.xkapil.chap2.good_code.step1_DRY_Principle;

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
        return getEnabledCustomerByField("name");
    }

    public static List<String> getEnabledCustomerCities() {
        return getEnabledCustomerByField("city");
    }

    public static List<String> getEnabledCustomerDomains() {
        return getEnabledCustomerByField("domain");
    }

    private static List<String> getEnabledCustomerByField(String field) {
        List<String> list = new ArrayList<>();
        for (Customer customer : Customer.customers) {
            if (customer.enabled) {
                if (field.equals("name")) {
                    list.add(customer.name);
                } else if (field.equals("city")) {
                    list.add(customer.city);
                } else if (field.equals("domain")) {
                    list.add(customer.domain);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return list;
    }
}

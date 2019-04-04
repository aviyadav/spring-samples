package com.sample.spring.boot.rest.customerservice;

import com.sample.spring.boot.rest.customerservice.domain.Account;
import com.sample.spring.boot.rest.customerservice.domain.Customer;
import com.sample.spring.boot.rest.customerservice.repository.AccountRepository;
import com.sample.spring.boot.rest.customerservice.repository.CustomerRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DBInit implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer mattZhang = new Customer();
        mattZhang.setCustomerName("Matt Zang");
        mattZhang.setDateofBirth(LocalDate.of(1980, 03, 16));
        mattZhang.setPhoneNumber("+610452623758");
        mattZhang = customerRepository.save(mattZhang);

        Account esaverMZ = new Account();
        esaverMZ.setAccountNumber(10881061);
        esaverMZ.setBalance(8000.00);
        esaverMZ.setOpeningDate(LocalDate.of(2016, 05, 16));
        esaverMZ.setCustomer(mattZhang);
        esaverMZ.setAccountName("westpac esaver");

        accountRepository.save(esaverMZ);

        
        
        
        
        
        
        Account choiceMZ = new Account();
        choiceMZ.setAccountNumber(10881069);
        choiceMZ.setBalance(12000.00);
        choiceMZ.setOpeningDate(LocalDate.of(2016, 05, 16));
        choiceMZ.setCustomer(mattZhang);
        choiceMZ.setAccountName("westpac choice");

        accountRepository.save(choiceMZ);

        Customer andrewDavis = new Customer();
        andrewDavis.setCustomerName("Andrew Davis");
        andrewDavis.setDateofBirth(LocalDate.of(1985, 03, 16));
        andrewDavis.setPhoneNumber("+610452623798");
        andrewDavis = customerRepository.save(andrewDavis);

        Account esaverAD = new Account();
        esaverAD.setAccountNumber(10981061);
        esaverAD.setBalance(8000.00);
        esaverAD.setOpeningDate(LocalDate.of(2016, 05, 16));
        esaverAD.setCustomer(andrewDavis);
        esaverAD.setAccountName("westpac esaver");

        accountRepository.save(esaverAD);

        Account choiceAD = new Account();
        choiceAD.setAccountNumber(10881059);
        choiceAD.setBalance(12000.00);
        choiceAD.setOpeningDate(LocalDate.of(2016, 05, 16));
        choiceAD.setCustomer(andrewDavis);
        choiceAD.setAccountName("westpac choice");

        accountRepository.save(choiceAD);
    }
}

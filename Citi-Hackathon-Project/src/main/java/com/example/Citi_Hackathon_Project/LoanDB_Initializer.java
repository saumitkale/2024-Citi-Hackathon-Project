package com.example.Citi_Hackathon_Project;



import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Citi_Hackathon_Project.model.Loan;
import com.example.Citi_Hackathon_Project.repository.LoanRepository;

@Configuration
public class LoanDB_Initializer{
    @Bean
    CommandLineRunner initDatabase(LoanRepository loanRepository){
        return args -> {
            loanRepository.save(new Loan(1000.00, 12, 0.01, 1, 10000.00));
            loanRepository.save(new Loan(2000.00, 24, 0.02, 2, 10000.00));
            loanRepository.save(new Loan(3000.00, 36, 0.03, 3, 10000.00));
            loanRepository.save(new Loan(4000.00, 48, 0.04, 4, 10000.00));
        };
    }
}
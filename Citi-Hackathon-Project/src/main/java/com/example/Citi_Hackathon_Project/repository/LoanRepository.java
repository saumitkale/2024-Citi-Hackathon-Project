package com.example.Citi_Hackathon_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Citi_Hackathon_Project.model.Loan;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
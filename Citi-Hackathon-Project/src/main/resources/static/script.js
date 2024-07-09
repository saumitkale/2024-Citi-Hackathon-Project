import { getAllLoans, createLoan, borrow, payback, getLoanById } from './service.js';

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('create-loan-form').addEventListener('submit', async (event) => {
        event.preventDefault();
        const currentAmountBorrowed = document.getElementById('loan-amount-create').value;
        const loanType = document.querySelector('input[name="loan-type"]:checked').value;
        const loanTerm = document.getElementById('loan-term-create').value;
        const interestRatePerMonth = document.getElementById('loan-rate-create').value;
        const amountOfLoans = document.getElementById('loan-curr-amount-create').value;
        const maximumLoanAmount = document.getElementById('loan-max-amount-create').value;
        const loan = {
            currentAmountBorrowed,
            loanTerm,
            interestRatePerMonth,
            amountOfLoans,
            maximumLoanAmount,
        };
        console.log(loan);

        try {
            const createdLoan = await createLoan(loan);
            console.log('Loan created:', createdLoan);
            document.getElementById('create-loan').innerHTML += "Congrats, Your Loan Was Stored!" + "<br><br> The ID for this loan is: " + createdLoan.userID;
        } catch (error) {
            console.error('Error creating loan:', error);
        }
    });

    document.getElementById('borrow-loan-form').addEventListener('submit', async (event) => {
        event.preventDefault();
        const loanId = document.getElementById('borrow-loan-id').value;
        const amount = document.getElementById('borrow-loan-amount').value;
        try {
            const updatedLoan = await borrow(loanId, amount);
            console.log('Loan borrowed:', updatedLoan);
            document.getElementById('borrow-loan-result').innerText = `Borrowed successfully. Current amount borrowed: ${updatedLoan.currentAmountBorrowed}`;
        } catch (error) {
            console.error('Error borrowing loan:', error);
        }
    });

    document.getElementById('payback-loan-form').addEventListener('submit', async (event) => {
        event.preventDefault();
        const loanId = document.getElementById('payback-loan-id').value;
        const amount = document.getElementById('payback-loan-amount').value;
        try {
            const updatedLoan = await payback(loanId, amount);
            document.getElementById('payback-loan-result').innerText = `Payed back successfully. Current amount borrowed: ${updatedLoan.currentAmountBorrowed}`;
        } catch (error) {
            console.error('Error paying back loan:', error);
        }
    });

    document.getElementById('check-loan-form').addEventListener('submit', async (event) => {
        event.preventDefault();
        const loanId = document.getElementById('check-loan-id').value;
        try {
            const loan = await getLoanById(loanId);
            document.getElementById('check-loan-result').innerText = `Loan details: \nUser ID: ${loan.userID}\nCurrent Amount Borrowed: ${loan.currentAmountBorrowed}\nLoan Term: ${loan.loanTerm}\nInterest Rate: ${loan.interestRatePerMonth}\nAmount of Loans: ${loan.amountOfLoans}\nMaximum Loan Amount: ${loan.maximumLoanAmount}`;
        } catch (error) {
            console.error('Error retrieving loan:', error);
        }
    });
});

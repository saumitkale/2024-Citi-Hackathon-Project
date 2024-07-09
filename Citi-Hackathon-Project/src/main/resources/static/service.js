const API_URL = 'http://localhost:8080/api/loans';

export const getAllLoans = () => {
    return fetch(API_URL)
        .then(response => response.json());
};

export const createLoan = (loan) => {
    return fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loan)
    }).then(response => response.json());
};

export const borrow = (loanId, amount) => {
    return fetch(`${API_URL}/${loanId}/borrow?amount=${amount}`, {
        method: 'POST'
    }).then(response => response.json());
};

export const payback = (loanId, amount) => {
    return fetch(`${API_URL}/${loanId}/payback?amount=${amount}`, {
        method: 'POST'
    }).then(response => response.json());
};

export const getLoanById = (loanId) => {
    return fetch(`${API_URL}/${loanId}`)
        .then(response => response.json());
};

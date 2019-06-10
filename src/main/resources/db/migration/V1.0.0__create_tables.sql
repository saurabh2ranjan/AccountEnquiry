CREATE TABLE ACCOUNT (
    id INT NOT NULL,
    user_id VARCHAR(50) NOT NULL,
    account_number VARCHAR(100) NOT NULL,
    account_name VARCHAR(100) NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    balance_date DATE,
    currency VARCHAR(50) NOT NULL,
    opening_available_balance DOUBLE NOT NULL
);

CREATE TABLE TRANSACTION (
    id INT NOT NULL,
    account_id INT NOT NULL,
    currency VARCHAR(50) NOT NULL,
    debit_amount DOUBLE,
    credit_amount DOUBLE,
    debit_credit VARCHAR(50) NOT NULL,
    transaction_number VARCHAR(100) NOT NULL,
    foreign key (account_id) references touristinfo(TOURISTINFO_ID)
);

INSERT INTO ACCOUNT VALUES(1, 'user1','100001','Account Name1','Saving',SYSDATE, 'AUD', '300');
INSERT INTO ACCOUNT VALUES(2, 'user1','100002','Account Name2','Current',SYSDATE, 'AUD', '400');
INSERT INTO ACCOUNT VALUES(3, 'user1','100003','Account Name3','Saving',SYSDATE, 'AUD', '500');
# Problem to solve

## Implement the following simplified account bank system application with the following considerations:

1. A Current account could have n movements
2. The movements can't be deleted
3. The accounts can be deleted only if it has no movements associated
4. The accounts have an Account Number (required field and unique), a currency("Pesos, Dolars,Euro") and a balance
5. The movements have a creation date(UTC time), kind of movement(debit or credit), description(200 characters) and a value(number having two decimals)
6. Everytime a new movement is  made, the account's balance asociated with that movement must be updated
7. If a movement generates an overdraft greater than a 1000(for an Account in Pesos), greaterthan a 300(for an Account in Dolars) or greater than a 150(for an Account in Euros) must be rejected

## The endpoints to be created are:

* Create an account
* Delete an account
* List Accounts
* Add movement
* List movements per account
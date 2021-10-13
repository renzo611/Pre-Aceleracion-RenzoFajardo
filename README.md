# Alkemy Challenge de ingreso

### Prerequisites
- Java 11

### Setup Environment Variables

1) Create an account on https://app.sendgrid.com and get an ApiKey
2) Modify the value of the variable 'apiKey' located in the class 'EmailServiceImpl'.
```bash
YOUR_API_KEY=key
```
3) Add the environment variable called 'alkemy.icons.email.sender' inside the application.properties file and assign an email registered in sendgrid.

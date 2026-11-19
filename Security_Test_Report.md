# Security Test Report — Sprint 7 Baseline

## 1. Vulnerability Overview
* **Target Component:** `VulnerableLoginTest.java` (Prototype Authentication Flow)
* **Vulnerability Type:** SQL Injection (CWE-89)
* **Root Cause:** User input is concatenated directly into a raw `java.sql.Statement` string (`+ userInput +`), allowing single quotes (`'`) to break out of the data context and inject arbitrary SQL logic.

## 2. Exploit Execution Evidence ("Before" State)
* **Test Input (Username):** `' OR '1'='1' --`
* **Test Input (Password):** `wrongpass`

### Console Output Log
```text
Enter Username: ' OR '1'='1' --
Enter Password: wrongpass
DEBUG SQL EXECUTED: SELECT * FROM users WHERE username = '' OR '1'='1' --' AND password_hash = 'wrongpass'
🚨 BREACH SUCCESSFUL! Logged in as: admin (Role: ADMIN)
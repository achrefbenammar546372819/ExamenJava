# OOP TP E-Commerce Console App

## Overview

This repository contains the code for a console application developed as part of an Object-Oriented Programming (OOP) university subject. The project focuses on implementing fundamental OOP concepts to create an e-commerce system with enhanced features like user and admin authentication, product management, and secure data storage using SHA-256 hashing.

## Features

### User and Admin Authentication

- **Login Authentication**: Users and admins must authenticate themselves with a valid username and password.
- **Admin Authentication**: Differentiates between user and admin accounts, allowing only authorized users to access admin functionalities.

### User Interface

- **Shopping for Products**: Users can browse, add, subtract, and empty their shopping carts.
- **Account Management**: Users can change their account details securely stored with SHA-256 hashed passwords.

### Admin Interface

- **Product Management**: Admins can add, edit, and remove products from the store.
- **User Account Manipulation**: Admins can manage user accounts without accessing sensitive data, thanks to SHA-256 hashing.

### CSV File Utils

- **Data Storage**: Utilizes CSV file manipulation utilities to store and retrieve user, product, and admin data in a CSV format.
- **Data Persistence**: Ensures persistent storage of user, product, and admin information for later use.

### SHA-256 Hasher

- **Secure Data Storage**: Implements SHA-256 hashing to securely store sensitive user data such as passwords.

## Getting Started

To run the e-commerce console app, follow these steps:

## Getting Started

To run the e-commerce console app, follow these steps:

1. Clone the repository to your local machine and run main.java:

   ```bash
   git clone https://github.com/achrefbenammar546372819/ExamenJava.git

   cd oop-tp-e-commerce/Application
   javac main.java
   java Main



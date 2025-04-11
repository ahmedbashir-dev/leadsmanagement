# Leads Management API

## Overview
Leads Management API is a Spring Boot-based RESTful service designed to handle lead submissions and management for homecare services. The API provides endpoints for storing and retrieving leads efficiently.

## Features
- **Lead Submission**: Securely store lead information.
- **Lead Retrieval**: Fetch stored leads via API.
- **RESTful Architecture**: Built using Spring Boot.
- **Database Integration**: Uses PostgreSQL for persistent storage.
- **Production Deployment**: Hosted on Railway at [Railway](https://leadsmanagement-production.up.railway.app).

## Tech Stack
- **Backend**: Spring Boot
- **Database**: PostgreSQL
- **Deployment**: Railway

## Installation & Setup
### Prerequisites
- Java 17+
- PostgreSQL

### Setup Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/ahmedbashir-dev/leadsmanagement.git
   cd leadsmanagement
   ```
2. Configure database settings in `application.properties`.

3. Build and run the Spring Boot application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints

### Leads Management

#### Get All Leads
**Endpoint:**  
`GET /api/leads`

**Description:**  
Fetch all stored leads.

**Response Example:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "phone": "123-456-7890",
    "message": "Looking for homecare services."
  }
]
```

#### Submit a new lead
**Endpoint:**  
`POST /api/leads`

**Description:**  
Submit a new lead to the system.

**Response Example:**
```json
{
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "phone": "987-654-3210",
  "message": "Need assistance for my elderly parent."
}
```



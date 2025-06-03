# IngeniousAssessment2 - Stock Scraper

A Spring Boot project that scrapes stock market data from [KLSE i3investor](https://klse.i3investor.com/web/index), and stores it into a local PostgreSQL database. The scraping runs on a daily schedule using Quartz.

---

## 🚀 Tech Stack

- **Spring Boot**
- **Spring Web**
- **Spring Data JPA Entity**
- **Spring Data JPA Repository**
- **Spring Service**
- **Quartz Scheduler**
- **Thymeleaf**
- **PostgreSQL**
- **Jsoup** (for web scraping)
- **Maven**

---
## ⚙️ Project Features

- Scrapes stock data (Gainers/Losers) daily at **12:00 AM** by default.
- Stores data in a local PostgreSQL database.
- Displays stored data on a web interface via Thymeleaf.
- Fully configurable cron schedule.
- Modular and easy-to-extend architecture.

## 🛠️ Setup Instructions

### 1. Clone the repository

```bash
git clone <your-repo-url>
cd <project-directory>
```

---
### 2. Configure PostgreSQL
Make sure you have PostgreSQL running locally. Then, update your application.properties:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```
Create the database manually if it doesn’t exist.

---
### 3. Spring Boot Quartz Scheduler Missing Table Error

This project uses Quartz Scheduler but if you encounter missing data source error like qrtz_calendars, qrtz_cron_triggers missing in the PostGresSQL, you might need to go here to download the SQL script to create the missing tables.

🔗 https://github.com/quartznet/quartznet/tree/main/database/tables


---
### 4.⏱️ Change the Cron Schedule
The cron expression for running the job is located in Assessment2Application.java inside the dailyJobTrigger bean.

#### Default schedule (12:00 AM daily):

```java
@Bean
public Trigger dailyJobTrigger() {
    return TriggerBuilder.newTrigger()
            .forJob(dailyJobDetail())
            .withIdentity("dailyJobTrigger")
            .withSchedule(CronScheduleBuilder.cronSchedule("0 0 0 * * ?")) // 12:00 AM daily
            .build();
}
```
You can modify this to suit your desired run time.

---
### 5.📡 Web Scraping Source
This project uses Jsoup to scrape data from:

🔗 https://klse.i3investor.com/web/index

Parsed data is then persisted to the configured PostgreSQL database through StockService.

---
### 6. Run the Application
Run the main class or directly from your IDE by running Assessment2Application.java. The displayed page will be available at http://localhost:8080/, where it displays the data table.

---
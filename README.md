# 🚀 Spring Boot Observability & Monitoring with Prometheus & Grafana

<p align="center">

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-green?style=for-the-badge&logo=springboot)
![Micrometer](https://img.shields.io/badge/Micrometer-Metrics-blue?style=for-the-badge)
![Prometheus](https://img.shields.io/badge/Prometheus-Monitoring-E6522C?style=for-the-badge&logo=prometheus)
![Grafana](https://img.shields.io/badge/Grafana-Dashboard-F46800?style=for-the-badge&logo=grafana)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

</p>

---

# 📖 Overview

This project demonstrates how to build an **observable Spring Boot application** using the modern monitoring stack adopted across enterprise environments.

The application exposes runtime and business metrics using **Spring Boot Actuator** and **Micrometer**, stores them in **Prometheus**, and visualizes them with **Grafana** dashboards.

It provides a practical implementation of application monitoring concepts including:

- JVM Monitoring
- HTTP Request Metrics
- Request Throughput (RPS)
- Response Time Analysis
- Memory Usage
- CPU Utilization
- Prometheus Time-Series Collection
- Grafana Dashboard Visualization

---

# 🏗 Architecture

```text
                    +-----------------------+
                    |     Client Requests   |
                    +----------+------------+
                               |
                               v
                  +---------------------------+
                  | Spring Boot Application   |
                  |                           |
                  | Spring MVC                |
                  | Actuator                  |
                  | Micrometer                |
                  +------------+--------------+
                               |
                /actuator/prometheus
                               |
                               v
                  +---------------------------+
                  |       Prometheus          |
                  |  Time-Series Database     |
                  +------------+--------------+
                               |
                          PromQL Queries
                               |
                               v
                  +---------------------------+
                  |         Grafana           |
                  | Interactive Dashboards    |
                  +---------------------------+
```

---

# ✨ Features

## Application Monitoring

- JVM Heap Memory
- Non-Heap Memory
- CPU Usage
- Thread Count
- Garbage Collection Metrics

## HTTP Metrics

- Request Count
- Request Rate (RPS)
- Response Time
- HTTP Status Codes
- Request Duration Histogram

## Observability

- Spring Boot Actuator
- Micrometer Metrics
- Prometheus Scraping
- Grafana Visualization

---

# 🛠 Technology Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot 3 | Backend Framework |
| Spring Boot Actuator | Production Metrics |
| Micrometer | Metrics Collection |
| Prometheus | Time-Series Database |
| Grafana | Dashboard & Visualization |
| Maven | Dependency Management |

---

# 📂 Project Structure

```text
Monitoring-Application
│
├── docker-compose.yml
├── prometheus.yml
├── pom.xml
│
├── docs
│   └── screenshots
│       └── grafana-dashboard.png
│
└── src
    └── main
        ├── java
        │   └── com
        │       └── monitoring_app
        │           ├── config
        │           ├── controller
        │           ├── service
        │           └── MonitoringApplication.java
        │
        └── resources
            └── application.yml
```

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/Monitoring-Application.git

cd Monitoring-Application
```

---

## Start Monitoring Stack

```bash
docker compose up -d
```

---

## Run Spring Boot

```bash
mvn clean spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

---

# 🔗 Local Services

| Service | URL |
|----------|-----|
| Spring Boot | http://localhost:8888 |
| API Endpoint | http://localhost:8888/api/v1/monitor |
| Actuator | http://localhost:8888/actuator |
| Prometheus Metrics | http://localhost:8888/actuator/prometheus |
| Prometheus UI | http://localhost:9090 |
| Grafana | http://localhost:3000 |

Default Grafana Credentials

```
Username : admin
Password : admin
```

---

# 📈 Dashboard Preview

> Replace this image after taking your dashboard screenshot.

```text
docs/
└── screenshots/
    └── grafana-dashboard.png
```

<p align="center">

<img src="docs/screenshots/grafana-dashboard.png" width="1000"/>

</p>

---

# 📊 Sample PromQL Queries

## Request Rate

```promql
sum(rate(http_server_requests_seconds_count[1m]))
```

---

## Total Requests

```promql
sum(http_server_requests_seconds_count)
```

---

## JVM Heap Memory

```promql
jvm_memory_used_bytes{area="heap"}
```

---

## CPU Usage

```promql
process_cpu_usage
```

---

## Active Threads

```promql
jvm_threads_live_threads
```

---

# 🧪 Generate Test Traffic

PowerShell

```powershell
while ($true) {
    Invoke-RestMethod http://localhost:8888/api/v1/monitor | Out-Null
    Start-Sleep -Milliseconds 500
}
```

or

```powershell
1..500 | % {
    Invoke-RestMethod http://localhost:8888/api/v1/monitor
}
```

---

# 📸 Screenshots

| Grafana Dashboard | Prometheus Targets |
|-------------------|--------------------|
| Add Screenshot | Add Screenshot |

---

# 💡 Learning Outcomes

This project demonstrates practical knowledge of

- Spring Boot Actuator
- Micrometer
- Prometheus
- Grafana
- PromQL
- JVM Monitoring
- Application Observability
- Performance Monitoring
- Metrics Collection
- Dashboard Design

---

# 🔮 Future Enhancements

- Dockerized Spring Boot Application
- Spring Cloud Gateway Metrics
- Distributed Tracing using Zipkin
- Loki Log Aggregation
- Alertmanager Integration
- Kubernetes Deployment
- Grafana Alert Rules
- CI/CD Pipeline using GitHub Actions

---

# 👨‍💻 Author

**Rahul Vikas Kale**

Java Full Stack Developer

- Spring Boot
- Microservices
- React
- Docker
- Kafka
- Redis
- Prometheus
- Grafana
- Azure AZ-900

---

# ⭐ Support

If you found this project helpful,

⭐ Star this repository.

It motivates future improvements.

---

# 📄 License

Licensed under the MIT License.

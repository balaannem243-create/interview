1. What an API Gateway does
2. The **recommended Java approach** (Spring Cloud Gateway)
3. A **minimal working example**
4. Common features (auth, rate-limit, logging)

---

## 1️⃣ What an API Gateway actually does

An API Gateway sits **in front of your microservices** and handles cross-cutting concerns so services stay clean.

Typical responsibilities:

- Route requests to the right service
- Authentication & authorization
- Rate limiting
- Logging & monitoring
- Request/response transformation

![Image](https://miro.medium.com/1%2AgW4JrHTr86HnTrouQYLgJQ.png)

![Image](https://static.spring.io/blog/bwilcock/20190801/demo.png)

---

## 2️⃣ Best way to build an API Gateway in Java

### ✅ Recommended: **Spring Cloud Gateway**

Why?

- Built on Spring WebFlux (non-blocking, fast)
- Minimal boilerplate
- Designed _specifically_ for API gateways
- Production-ready (Netflix Zuul is deprecated)

---

✅**API Gateway with SpringBoot microservices**

✅ **Microservices**
✅ **REST**
✅ **API Keys auth**
✅ **Spring Boot + Spring Cloud Gateway**
✅ **Gradle project**

I’ll keep it practical and copy-paste friendly.

---

## Architecture (what we’re building)

![Image](https://miro.medium.com/v2/resize%3Afit%3A1200/1%2A4ftTwNn2DjnI7TXvdgXk4Q.png)

![Image](https://d2908q01vomqb2.cloudfront.net/1b6453892473a467d07372d45eb05abc2031647a/2021/10/13/Picture1.png)

**Flow**

```
Client → API Gateway → Microservices
        (API Key check)
```

- All requests go through the Gateway
- Gateway validates API key
- Valid requests are routed to services
- Services stay simple (no auth logic)

---

## 1️⃣ Create the Gateway project (Gradle)

### `build.gradle`

```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.2'
    id 'io.spring.dependency-management' version '1.1.4'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

ext {
    set('springCloudVersion', "2023.0.0")
}

dependencies {
    implementation 'org.springframework.cloud:spring-cloud-starter-gateway'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}
```

---

## 2️⃣ Application config (routing)

### `application.yml`

```yaml
server:
  port: 8080

spring:
  cloud:
    gateway:
      default-filters:
        - name: ApiKeyAuth
      routes:
        - id: user-service
          uri: http://localhost:8081
          predicates:
            - Path=/users/**
          filters:
            - StripPrefix=1

        - id: order-service
          uri: http://localhost:8082
          predicates:
            - Path=/orders/**
          filters:
            - StripPrefix=1
```

📌 Every request will now pass through the **API key filter**.

---

## 3️⃣ API Key Authentication Filter

### Header-based API Key

We’ll require:

```
X-API-KEY: my-secret-key
```

---

### Create the filter

#### `ApiKeyAuthFilter.java`

```java
package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyAuthFilter extends AbstractGatewayFilterFactory<ApiKeyAuthFilter.Config> {

    private static final String API_KEY_HEADER = "X-API-KEY";
    private static final String VALID_API_KEY = "my-secret-key";

    public ApiKeyAuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String apiKey = exchange.getRequest()
                    .getHeaders()
                    .getFirst(API_KEY_HEADER);

            if (apiKey == null || !apiKey.equals(VALID_API_KEY)) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {
        // future config options
    }
}
```

✔ Blocks requests without API key
✔ Centralized auth
✔ Easy to extend later (DB, Redis, Vault)

---

## 4️⃣ Call the Gateway

### ❌ Without API key

```http
GET http://localhost:8080/users/1
```

Response:

```
401 Unauthorized
```

### ✅ With API key

```bash
curl -H "X-API-KEY: my-secret-key" \
     http://localhost:8080/users/1
```

Request is routed to:

```
http://localhost:8081/users/1
```

---

## 5️⃣ Example Microservice (User Service)

### `UserController.java`

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return "User " + id;
    }
}
```

### `application.yml`

```yaml
server:
  port: 8081
```

🚫 No auth code here — gateway handles it.

---

## 6️⃣ Improving API Key Security (recommended)

### Instead of hardcoding:

- Store keys in:
  - Database
  - Redis
  - Hashicorp Vault
  - AWS Secrets Manager

### Example improvement

```java
Set<String> validKeys = Set.of("key1", "key2", "key3");
```

Or fetch per client:

```java
X-API-KEY → client_id → permissions
```

---

## 7️⃣ When API Keys are a good choice

✅ Internal services
✅ B2B integrations
✅ Server-to-server calls

❌ Public user authentication
❌ Mobile apps (use OAuth2/JWT instead)

---

## 8️⃣ Final structure

```
api-gateway
 ├── build.gradle
 ├── application.yml
 └── filter
     └── ApiKeyAuthFilter.java
```

---

If you want next steps, I can:

- Add **per-route API keys**
- Add **rate limiting per key**
- Convert API keys → **JWT later**
- Add **OpenAPI / Swagger via Gateway**

Just tell me where this gateway is going 🚀

## 3️⃣ Create a basic API Gateway (Java + Spring)

### Step 1: Create a Spring Boot project

Use **Spring Initializr**:

- Project: Maven
- Language: Java
- Dependencies:
  - **Spring Cloud Gateway**
  - **Spring Boot Actuator** (optional)

---

### Step 2: `pom.xml`

```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-dependencies</artifactId>
      <version>2023.0.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
  </dependency>
</dependencies>
```

---

### Step 3: Configure routes (`application.yml`)

```yaml
server:
  port: 8080

spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: http://localhost:8081
          predicates:
            - Path=/users/**
          filters:
            - StripPrefix=1

        - id: order-service
          uri: http://localhost:8082
          predicates:
            - Path=/orders/**
          filters:
            - StripPrefix=1
```

📌 Result:

- `/users/**` → `http://localhost:8081`
- `/orders/**` → `http://localhost:8082`

---

### Step 4: Run it

```bash
mvn spring-boot:run
```

Now:

```http
GET http://localhost:8080/users/123
GET http://localhost:8080/orders/456
```

🎉 You’ve got a working API Gateway.

---

## 4️⃣ Add common API Gateway features

### 🔐 Authentication filter (JWT example)

```java
@Component
public class AuthFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authHeader = exchange.getRequest()
                .getHeaders()
                .getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // Validate token here
        return chain.filter(exchange);
    }
}
```

Attach it to routes:

```yaml
filters:
  - name: AuthFilter
```

---

### 🚦 Rate limiting

```yaml
filters:
  - name: RequestRateLimiter
    args:
      redis-rate-limiter.replenishRate: 10
      redis-rate-limiter.burstCapacity: 20
```

(Uses Redis under the hood)

---

### 📝 Logging

```java
@Component
public class LoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Request: " + exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}
```

---

## 5️⃣ Alternatives (when NOT to use Spring Cloud Gateway)

| Option                     | When to use                   |
| -------------------------- | ----------------------------- |
| **Spring Cloud Gateway**   | Microservices, cloud-native   |
| **Netflix Zuul**           | Legacy only                   |
| **Custom Servlet / Netty** | Extreme performance tuning    |
| **NGINX / Kong**           | Infra-level gateway, not Java |

---

## 6️⃣ TL;DR

If you’re building an API Gateway in Java **today**:

- ✅ Use **Spring Cloud Gateway**
- Configure routes in YAML
- Add filters for auth, logging, rate limits
- Keep business logic **out** of the gateway

---

---

## 1️⃣ Where should authentication be implemented — API Gateway or microservice?

**Answer:**
Authentication should be implemented at the **API Gateway**, not in individual microservices.

**Why:**

- Single entry point
- Avoids code duplication
- Easier to rotate keys or change auth mechanism
- Microservices focus only on business logic

Microservices should trust traffic coming from the gateway.

---

## 2️⃣ Why use an API Gateway in microservices?

**Answer:**
An API Gateway acts as a **reverse proxy** that handles cross-cutting concerns.

**Responsibilities include:**

- Request routing
- Authentication & authorization
- Rate limiting
- Logging & monitoring
- Request/response transformation

This keeps microservices lightweight and decoupled.

---

## 3️⃣ How does API Key authentication work?

**Answer:**
The client sends an API key in a request header (e.g. `X-API-KEY`).
The API Gateway validates the key and either:

- Forwards the request (valid key)
- Rejects the request (invalid/missing key)

The key identifies the **calling client**, not the user.

---

## 4️⃣ Why are API keys not recommended for public user authentication?

**Answer:**
API keys:

- Are static
- Can be easily leaked
- Don’t support user identity or roles
- Don’t expire automatically

They are best for:

- Internal services
- B2B integrations
- Server-to-server communication

For public users, **JWT or OAuth2** is preferred.

---

## 5️⃣ How does Spring Cloud Gateway differ from Zuul?

**Answer:**

| Spring Cloud Gateway   | Zuul               |
| ---------------------- | ------------------ |
| Non-blocking (WebFlux) | Blocking           |
| Actively maintained    | Deprecated         |
| Better performance     | Older architecture |
| Built for cloud-native | Legacy             |

Spring Cloud Gateway is the recommended solution.

---

## 6️⃣ How do you secure microservices from direct access?

**Answer:**
Common approaches:

1. Expose microservices only on **private network**
2. Block public access using firewall/security groups
3. Allow traffic only from API Gateway
4. Use internal headers or signed tokens from gateway

This ensures all traffic passes through the gateway.

---

## 7️⃣ What happens if someone bypasses the API Gateway?

**Answer:**
If microservices are publicly exposed, they can be accessed directly — which is a **security risk**.

To prevent this:

- Keep microservices private
- Validate internal gateway headers
- Use mTLS or signed JWT between gateway and services

---

## 8️⃣ How do you pass client identity from Gateway to microservice?

**Answer:**
After authentication, the gateway adds headers such as:

```
X-Client-Id
X-Client-Role
```

Microservices read these headers for:

- Authorization
- Auditing
- Rate limiting

Microservices do **not** validate API keys again.

---

## 9️⃣ How do you implement rate limiting per API key?

**Answer:**
Use Spring Cloud Gateway’s `RequestRateLimiter` with Redis.

Each API key is treated as a unique identifier:

- Limits requests per key
- Prevents abuse
- Protects backend services

---

## 🔟 What are Gateway Filters?

**Answer:**
Gateway Filters are components that intercept requests and responses.

Types:

- **GlobalFilter** → applies to all routes
- **Route-specific filters** → apply to specific routes

They are used for:

- Auth
- Logging
- Rate limiting
- Header modification

---

## 1️⃣1️⃣ Difference between authentication and authorization?

**Answer:**

| Authentication           | Authorization              |
| ------------------------ | -------------------------- |
| Who you are              | What you can do            |
| Identity check           | Permission check           |
| API key / JWT validation | Role/permission validation |

Gateway usually handles authentication; services may handle authorization.

---

## 1️⃣2️⃣ How would you rotate API keys without downtime?

**Answer:**

- Store API keys in DB/Redis
- Support multiple active keys
- Gradually expire old keys
- Update clients
- Remove old keys after transition

No service redeploy required if keys are externalized.

---

## 1️⃣3️⃣ How does REST fit into microservices?

**Answer:**
REST is commonly used because:

- Simple
- Stateless
- HTTP-native
- Easy to debug and scale

Each microservice exposes REST endpoints consumed via the gateway.

---

## 1️⃣4️⃣ What is statelessness and why is it important?

**Answer:**
Statelessness means each request contains all necessary information.

Benefits:

- Easy horizontal scaling
- No session affinity
- Better fault tolerance

API Gateway and REST APIs should be stateless.

---

## 1️⃣5️⃣ When would you NOT use an API Gateway?

**Answer:**

- Very small systems
- Single service applications
- Simple internal tools

Gateways add complexity and should be used when they bring value.

---

## ⭐ Bonus “Senior-level” questions

### 🔹 How would you migrate API keys to JWT?

**Answer:**

- Gateway validates API key
- Gateway issues short-lived JWT
- JWT is forwarded to microservices
- Gradually deprecate API keys

---

### 🔹 How do you handle versioning with an API Gateway?

**Answer:**

- URI versioning (`/v1/users`)
- Header-based versioning
- Route different versions to different services

Gateway manages versions centrally.

---

## 🧠 Interview tip (important)

When answering:

- Emphasize **Gateway responsibility**
- Say **“single entry point”**
- Say **“separation of concerns”**
- Say **“defense-in-depth”** (for senior roles)

---

# **Interview Cheat Sheet**

---

# 🧠 API Gateway & Microservices – Interview Cheat Sheet

---

## 🔹 Core Architecture

```
Client → API Gateway → Microservices
```

**API Gateway = single entry point**

Handles:

- Authentication
- Routing
- Rate limiting
- Logging
- Versioning

Microservices handle:

- Business logic only

---

## 🔹 Where Auth Lives

**Authentication → API Gateway**
**Business logic → Microservices**

✔ Avoids duplication
✔ Easier key rotation
✔ Cleaner services

---

## 🔹 API Key Authentication

- Client sends `X-API-KEY`
- Gateway validates key
- Request forwarded if valid
- Request rejected if invalid

**Used for:**

- B2B
- Internal systems
- Server-to-server

**Not for:** public user auth (use JWT/OAuth2)

---

## 🔹 Spring Cloud Gateway

- Non-blocking (WebFlux)
- Actively maintained
- Cloud-native
- Zuul replacement

**Key components:**

- Routes
- Predicates
- Filters

---

## 🔹 Gateway Filters

**Types:**

- GlobalFilter → all routes
- Route Filter → specific route

**Use cases:**

- Auth
- Rate limiting
- Logging
- Header modification

---

## 🔹 Passing Identity to Services

Gateway adds headers after auth:

```
X-Client-Id
X-Client-Role
```

Microservices:

- Read headers
- Do NOT re-authenticate

---

## 🔹 Securing Microservices

Best practices:

- Private network
- No public exposure
- Allow traffic only from gateway
- Optional signed internal tokens

---

## 🔹 Rate Limiting

- Implemented at gateway
- Usually Redis-based
- Per API key / client
- Prevents abuse & overload

---

## 🔹 REST in Microservices

- Stateless
- HTTP-based
- Easy to scale
- Widely supported

Each service exposes REST APIs via gateway.

---

## 🔹 Authentication vs Authorization

| Authentication | Authorization       |
| -------------- | ------------------- |
| Who you are    | What you can do     |
| API Key / JWT  | Roles / permissions |
| Gateway        | Often service-level |

---

## 🔹 API Key Rotation

- Store keys externally (DB / Redis / Vault)
- Support multiple active keys
- Gradual expiry
- No downtime

---

## 🔹 Versioning Strategies

- URL versioning (`/v1/users`)
- Header versioning
- Route different versions via gateway

---

## 🔹 When NOT to Use Gateway

- Single service apps
- Very small systems
- No cross-cutting concerns

---

## ⭐ Senior-Level Talking Points

- Single entry point
- Separation of concerns
- Defense-in-depth
- Stateless design
- Horizontal scalability

---

## 🧠 Interview Power Lines (use these)

- “Authentication is centralized at the API Gateway”
- “Microservices remain lightweight”
- “Gateway handles cross-cutting concerns”
- “API keys identify clients, not users”

---

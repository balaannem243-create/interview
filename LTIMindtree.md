Great 👍 Since you have **4 years experience in Java + Spring Boot + Microservices + Batch + OpenShift**, below are **20 high-probability L2 questions** with **strong, structured answers** suitable for a company like LTIMindtree.

These answers are written in a way that reflects **mid-level ownership mindset**, not fresher-level theory.

---

# 🔥 1️⃣ How does HashMap work internally?

**Answer:**

* HashMap uses **array of buckets (Node<K,V>[])**
* It calculates **hashCode()**
* Applies hash function → determines bucket index
* If collision occurs:

  * Before Java 8 → LinkedList
  * After Java 8 → converts to Balanced Tree (if >8 entries)

Time complexity:

* Average → O(1)
* Worst case → O(log n) (tree)

---

# 🔥 2️⃣ Difference between HashMap and ConcurrentHashMap?

**Answer:**

| HashMap                   | ConcurrentHashMap                   |
| ------------------------- | ----------------------------------- |
| Not thread-safe           | Thread-safe                         |
| Allows 1 null key         | No null keys                        |
| Entire map unsynchronized | Uses segment-level locking (Java 7) |
|                           | CAS + bucket-level locking (Java 8) |

ConcurrentHashMap avoids locking entire map → better performance.

---

# 🔥 3️⃣ What happens internally when @Transactional is used?

**Answer:**

* Spring creates a **proxy object**
* When method is called:

  * Transaction starts
  * Business logic executes
  * If no exception → commit
  * If RuntimeException → rollback

Important:

* Works only on public methods
* Self-invocation won’t work (proxy bypassed)

---

# 🔥 4️⃣ What is the N+1 problem in JPA?

**Answer:**
When fetching parent entity:

* First query → fetch parents
* Then for each parent → separate query for children

Example:
1 query + N queries → performance issue

Solution:

* Use **JOIN FETCH**
* Use EntityGraph
* Use proper fetch strategy

---

# 🔥 5️⃣ Explain First Level and Second Level Cache in Hibernate

**Answer:**

* First Level Cache:

  * Session-level
  * Default enabled
  * Same object reused within session

* Second Level Cache:

  * Application-level
  * Shared across sessions
  * Needs configuration (Ehcache, etc.)

---

# 🔥 6️⃣ How would you optimize a slow API in production?

**Structured Answer:**

1. Check logs (via Kibana)
2. Check response time metrics
3. Analyze DB query (EXPLAIN PLAN)
4. Check N+1 problem
5. Verify indexing
6. Check thread pool usage
7. Check recent deployments

Then:

* Add caching
* Optimize query
* Use pagination
* Tune thread pool

---

# 🔥 7️⃣ How do microservices communicate?

**Answer:**

* REST (HTTP)
* Feign Client
* WebClient
* Messaging (Kafka, if used)

In my project:

* Used REST + Feign
* Implemented timeout + retry

---

# 🔥 8️⃣ How do you handle service failure in microservices?

**Answer:**

* Implement timeout
* Retry mechanism
* Circuit breaker (Resilience4j)
* Fallback method
* Logging & monitoring

Prevents cascading failure.

---

# 🔥 9️⃣ How does Spring Batch work?

**Answer:**
Components:

* Job
* Step
* Reader
* Processor
* Writer

Chunk Processing:

* Read chunk (100 records)
* Process
* Write
* Commit transaction

If failure:

* JobRepository tracks status
* Restart possible from failed step

---

# 🔥 🔟 How did you handle large data (e.g., 10M records) in batch?

**Answer (Scenario Style):**

* Used chunk size tuning
* Enabled parallel processing
* Used paging reader
* Indexed DB columns
* Monitored memory usage
* Increased JVM heap size

---

# 🔥 1️⃣1️⃣ How does ElasticSearch work?

**Answer:**

* Uses inverted index
* Data stored as JSON documents
* Distributed & scalable
* Near real-time search

Used for:

* Log monitoring
* Fast text search

---

# 🔥 1️⃣2️⃣ How do you debug production issues using Kibana?

**Answer:**

1. Filter logs by service name
2. Check error logs
3. Trace request ID
4. Identify exception stacktrace
5. Correlate with deployment timeline

---

# 🔥 1️⃣3️⃣ What happens when a pod crashes in OpenShift?

**Answer:**

* Kubernetes detects failure
* Restarts pod automatically
* If replica count >1 → traffic shifts to other pods

Used rolling deployment strategy in project.

---

# 🔥 1️⃣4️⃣ What is rolling deployment?

**Answer:**

* Gradually replaces old pods with new ones
* Zero downtime
* Health checks ensure safe deployment

---

# 🔥 1️⃣5️⃣ Explain ACID properties

**Answer:**

* Atomicity
* Consistency
* Isolation
* Durability

Used in Oracle DB transactions.

---

# 🔥 1️⃣6️⃣ How do you secure REST APIs?

**Answer:**

* JWT authentication
* Role-based authorization
* HTTPS
* Input validation
* Exception handling

---

# 🔥 1️⃣7️⃣ How do you handle memory leak in production?

**Answer:**

1. Monitor heap usage
2. Take heap dump
3. Analyze using MAT tool
4. Identify object retention
5. Fix unclosed resources / static references

---

# 🔥 1️⃣8️⃣ How does JVM memory model work?

**Answer:**

* Heap (Young + Old)
* Metaspace
* Stack
* PC Register

GC Types:

* Minor GC
* Major GC

---

# 🔥 1️⃣9️⃣ What is dirty checking in Hibernate?

**Answer:**
Hibernate automatically detects changes in persistent object.
No need to call update().
At transaction commit → Hibernate compares snapshot and updates DB.

---

# 🔥 2️⃣0️⃣ Explain one production issue you solved

**Sample Answer:**

“We had API latency issue. Response time increased from 300ms to 2s.

Investigation:

* Checked Kibana logs
* Found slow DB query
* Query missing index
* Added composite index
* Reduced response time to 250ms”

Shows ownership + structured thinking.

---

# 🎯 Final Tip for L2

At your level (4 years), interviewers expect:

✔ Clear architecture understanding
✔ Production troubleshooting
✔ Performance optimization knowledge
✔ Confidence
✔ Ownership mindset

---


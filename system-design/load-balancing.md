# Load Balancing

* Load balancing is a technique used to distribute workloads evenly across multiple computing resources.
* **Goal:** LB ensures, resource optimisation, high availability, reliability, and performance by avoiding overloading a single server and avoiding downtime.
* To achieve full scalability and redundancy, load balancers can be strategically placed at three key locations within the system:
  * **Between the user and the web server.**
  * **Between web servers and an internal platform layer** (such as application servers or cache servers).&#x20;
  * **Between the internal platform layer and the database**.

Load balancers play a crucial role in optimizing system performance and ensuring robustness.&#x20;

<figure><img src="../.gitbook/assets/image (4) (1).png" alt=""><figcaption><p>Design Gurus, 2023a</p></figcaption></figure>

### How Load Balancer Work?

1. The load balancer **receives a request** from a client or user.
2. It **evaluates the incoming request** based on factors like server capacity, response time, active connections, and geographic location.
3. The load balancer **forwards the traffic** to the selected server or resource.
4. The server or resource **processes the request** and sends a response back to the load balancer.
5. Finally, the load balancer **sends the response** to the client or user who made the request.



### Uses of Load Balancing

* Load balancing is used to **distribute workloads** evenly across multiple computing resources.
* Load balancing improves website **performance** by distributing web traffic among multiple servers.
* It ensures **high availability and reliability** by redirecting traffic to available servers in case of failure.
* Load balancing enables **scalability** by adding servers to handle increased demand.
* **Redundancy** is achieved by maintaining redundant copies of data and services across servers.
* Load balancing **optimizes network traffic** by distributing it across multiple paths or links.
* **Geographic distribution** directs users to the nearest data center, reducing latency.
* It optimizes application performance by allocating resources to specific applications or services.
* Load balancers help protect against DDoS attacks by distributing traffic across multiple servers.
* **Cost savings** are achieved by optimizing resource usage and reducing infrastructure costs.
* Some load balancers can **cache** static content, reducing the load on servers and improving response times.



### Load Balancing Algorithms

#### Round Robin

* The Round Robin algorithm distributes incoming requests sequentially to available servers in a circular order.
* **Pros:**
  * Works well when servers have similar capacities;
* **Cons:**
  * May not perform optimally when servers have different capacities or varying workloads.
  * No consideration for server health or response time.



#### Least Connections

* The Least Connections algorithm directs incoming requests to the server with the lowest number of active connections. This approach accounts for the varying workloads of servers.
* **Pros:**
  * Adapts to differing server capacities and workloads.
  * Balances load more effectively when dealing with requests that take a variable amount of time to process.
* **Cons:**
  * Requires tracking the number of active connections for each server, which can increase complexity.
  * May not factor in server response time or health.



#### Weighted Round Robin

* The Weighted Round Robin algorithm is an extension of the Round Robin algorithm that assigns different weights to servers based on their capacities.
* The load balancer distributes requests proportionally to these weights.
* **Pros:**
  * Accounts for different server capacities, balancing load more effectively.
* **Cons:**
  * Weights must be assigned and maintained manually.
  * No consideration for server health or response time.



#### Weight Least Connections

The Weighted Least Connections algorithm combines the Least Connections and Weighted Round Robin algorithms.

* **Pros:**
  * Balances load effectively, accounting for both server capacities and active connections.
  * Adapts to varying server workloads and capacities.
* **Cons:**
  * Requires tracking active connections and maintaining server weights.
  * May not factor in server response time or health.



#### IP Hash

The IP Hash algorithm determines the server to which a request should be sent <mark style="background-color:orange;">based on the source and/or destination IP address</mark>. **This method maintains session persistence**, **ensuring** that **requests from a specific user are directed to the same server**.

* **Pros:**
  * Maintains session persistence, which can be useful for applications requiring a continuous connection with a specific server.
  * Can distribute load evenly when using a well-designed hash function.
* **Cons:**
  * May not balance load effectively when dealing with a small number of clients with many requests.
  * No consideration for server health, response time, or varying capacities.



#### Least Response Time

The Least Response Time algorithm directs incoming requests to the server with the lowest response time and the fewest active connections. This method helps to optimize the user experience by prioritizing faster-performing servers.

* **Pros:**
  * Accounts for server response times, improving user experience.
  * Considers both active connections and response times, providing effective load balancing.
* **Cons:**
  * Requires monitoring and tracking server response times and active connections, adding complexity.
  * May not factor in server health or varying capacities.

#### Custom Load

* Custom Load algorithm: Allows administrators to create personalized load balancing algorithms based on specific requirements, considering factors like server health, location, and capacity.



#### Random

* &#x20;Random algorithm: Selects servers randomly for load distribution, making it simple to implement but lacking considerations for factors like server health and response times.&#x20;



#### Least Bandwidth

* Least Bandwidth algorithm: Directs requests to servers with the least bandwidth usage, managing network resources effectively but requiring monitoring and potentially neglecting other factors like server health and response times.



### Load Balancer Types

* A load balancing type **refers to the method** or approach used to distribute incoming network traffic across multiple servers or resources.&#x20;
* **There are various load balancing methods such as** hardware load balancing, software load balancing, cloud-based load balancing, DNS load balancing, and Layer 4 and Layer 7 load balancing.

#### DNS Load Balancing

**DNS (Domain Name System) load balancing** relies on the DNS infrastructure to **distribute incoming traffic among multiple servers or resources**. It **works by resolving a domain name to multiple IP addresses**, effectively directing clients to different servers based on various policies.

* **Pros**:
  * **Relatively simple to implement**, as it doesn’t require specialized hardware or software.
  * Provides **basic load balancing and failover capabilities**.
  * Can **distribute traffic across geographically distributed servers**, improving performance for users in different regions.
* **Cons**:
  * **Limited to DNS resolution time**, which can be slow to update when compared to other load balancing techniques.
  * **No consideration for server health, response time, or resource utilization**.



#### Layer 4 Load Balancing

* **Layer 4 load balancing**, also referred to as **transport layer load balancing**, **operates at the transport layer of the OSI model (the fourth layer)**.&#x20;
* **Incoming traffic is distributed** based on information from the **TCP or UDP header**, including <mark style="background-color:orange;">**source and destination IP addresses**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">and</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**port numbers**</mark><mark style="background-color:orange;">.</mark>
* **Pros**:
  * **Fast and efficient**: It makes decisions based on **limited information from the transport layer**.
  * **Versatility**: It can handle a **wide variety of protocols and traffic types**.
* **Cons:**
  * **Lack of awareness of application-level information**: This may limit its effectiveness in some scenarios.
  * No consideration for server health, response time, or resource utilization.
  * May not be suitable for applications requiring session persistence or fine-grained load distribution.



#### Layer 7 Load Balancing

* **Layer 7 load balancing**, also referred to as **application layer load balancing**, **operates at the application layer of the OSI model (the seventh layer)**.&#x20;
* It takes into account application-specific information, such as HTTP headers, cookies, and URL paths, to make more informed decisions about how to distribute incoming traffic.
* **Pros**:
  1. **Intelligent and fine-grained load balancing**: It considers application-level details.
  2. **Support for advanced features**: Such as **session persistence**, **content-based routing**, and **SSL offloading**.
* **Cons:**
  1. **Slower and more resource-intensive**: Compared to **Layer 4 load balancing**, it requires **deeper inspection** of incoming traffic.
* **Example:** Consider a **web application with multiple microservices**. It utilizes **Layer 7 load balancing** to **route incoming API requests based on the URL path**, ensuring that each microservice receives only the requests it is responsible for handling.

### Statekess vs Stateful Load Balancing

**Stateless load balancing** operates without storing session information and makes routing decisions based on incoming request data. It efficiently distributes traffic without considering client history. Conversely, **stateful load balancing** preserves session information and directs subsequent requests from the same client to the same server, making it suitable for applications that depend on session data.



### High Availability and Fault Tolerance For Load Balancers

#### Redundancy and failover strategies for load balancers

* Active-passive configuration: One load balancer handles traffic while the other remains on standby. If the active load balancer fails, the passive instance takes over.
* Active-active configuration: Multiple load balancer instances process traffic simultaneously, distributing load and providing increased fault tolerance.

<figure><img src="../.gitbook/assets/image (1) (1) (1).png" alt=""><figcaption><p>Design Guru, 2023b</p></figcaption></figure>



#### Health checks and monitoring for load balancers

* Health checks: Periodic tests performed by the load balancer to determine backend server availability and performance, allowing the removal of unhealthy servers from the pool.
* Load balancer monitoring: Tracking performance metrics, such as response times and resource utilization, to detect potential issues and take corrective action.



#### Synchronization and State Sharing among load balancers

* Centralized configuration management: Using a centralized store to maintain and distribute configuration data among load balancer instances for consistency.
* State sharing and replication: Ensuring synchronization of session data and state information across load balancer instances through mechanisms like database replication or distributed caching systems.



### Scalability and Performance

#### Horizontal and vertical scaling of load balancers

* Horizontal scaling: Adding more load balancer instances to distribute traffic among them.
* Vertical scaling: Increasing the resources (e.g., CPU, memory, and network capacity) of existing load balancer instance(s) to handle increased traffic.



#### Connection and request rate limits

* Implementing rate limiting and connection limits at the load balancer level to prevent overloading and ensure consistent performance.
* Rate limits can be enforced based on criteria like IP addresses, client domains, or URL patterns. These limits can also help mitigate the impact of Denial of Service (DoS) attacks and prevent individual clients from monopolizing resources.



#### Caching and content optimization

* Load balancers can cache static content, such as images, CSS, and JavaScript files, and support content optimization features like compression or minification to improve performance and reduce load on backend servers.



#### Impact of load balancers on latency

* Load balancers introduce an additional network hop, potentially increasing latency.
* Strategies to optimize load balancer performance include geographical distribution, connection reuse (which reduce the overhead of establishing new connections between the load balancer and backend servers for each request), and protocol optimizations like HTTP/2 or QUIC.



### Common Issues Associated with Load Balancers

1. **Single Point of Failure:** Load balancers can become a single point of failure if not designed with redundancy and failover mechanisms.
2. **Configuration Complexity:** Load balancers have various configuration options, and misconfigurations can lead to poor performance or service outages.
3. **Scalability Limitations:** Load balancers themselves can become performance bottlenecks if not configured to handle increased traffic.
4. **Latency:** Introducing a load balancer adds an extra network hop, potentially increasing latency.
5. **Sticky Sessions:** Load balancers need to support session persistence for applications that require maintaining user context, but it can lead to uneven load distribution.
6. **Cost:** Deploying and managing load balancers can add to infrastructure costs, including hardware, software licensing, or managed services fees.
7. **Health Checks and Monitoring:** Inadequate health checks can result in directing traffic to unhealthy servers, impacting user experience.

### References

Design Gurus. Grokking System Design Fundamentals: Load Balance. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641da6bad2bb4146954f1130](https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641da6bad2bb4146954f1130)>. Acesso em: 10 dez. 2023a.



Design Gurus. Grokking the System Design Interview: Load Balance. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-the-system-design-interview/doc/638c0b7aac93e7ae59a1b0ad](https://www.designgurus.io/course-play/grokking-the-system-design-interview/doc/638c0b7aac93e7ae59a1b0ad)>. Acesso em: 12 dez. 2023b.


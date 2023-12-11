# Load Balancing

* Load balancing is a technique used to distribute workloads evenly across multiple computing resources.
* **Goal:** LB ensures, resource optimisation, high availability, reliability, and performance by avoiding overloading a single server and avoiding downtime.
* To achieve full scalability and redundancy, load balancers can be strategically placed at three key locations within the system:
  * **Between the user and the web server.**
  * **Between web servers and an internal platform layer** (such as application servers or cache servers).&#x20;
  * **Between the internal platform layer and the database**.

Load balancers play a crucial role in optimizing system performance and ensuring robustness.&#x20;

<figure><img src="../.gitbook/assets/image (2).png" alt=""><figcaption><p>Design Gurus, 2023a</p></figcaption></figure>

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



### References

Design Gurus. Grokking System Design Fundamentals: Load Balance. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641da6bad2bb4146954f1130](https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641da6bad2bb4146954f1130)>. Acesso em: 10 dez. 2023a.


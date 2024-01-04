# Availability

### Availability

Disponibilidade é relacionada à frequência com que o sistema está online, em execução e provendo serviços e funcionalidade aos seus usuários (INDRASIRI; SUHOTHAYAN, 2021 e NEWMAN, 2021).

* High Availability encompasses:
  * running (online)
  * system can handle increased load and traffic without compromising its performance.

High availability is often **measured** in terms of **uptime**, which is the ratio of time that a system is operational to the total time it is supposed to be operational.

Achieving high availability involves **minimizing** planned and _unplanned downtime, eliminating single points of failure, and implementing redundant systems and processes_.



### Strategies for Achieving High Availability

#### High Availability through Redundancy and Replication <a href="#1.-high-availability-through-redundancy-and-replication" id="1.-high-availability-through-redundancy-and-replication"></a>

* Duplicates critical components or entire systems for seamless takeover by the **redundant** **server** if one fails.
* Creates multiple copies of data to ensure availability (**replication**).
* Commonly used in data centers where multiple servers handle the workload.
  * In the event of a hardware failure or system crash, the **redundant** server takes over, ensuring uninterrupted service for users.

#### Availability through Load Balancing <a href="#2.-availability-through-load-balancing" id="2.-availability-through-load-balancing"></a>

* Distributes workloads across multiple servers to prevent any single server from being overwhelmed.
* Optimizes **resource utilization** and prevents bottlenecks (all this enhances availability).
* Particularly useful in web applications with a large number of simultaneous users.

#### Availability through Distributed Data Storage <a href="#3.-availability-through-distributed-data-storage" id="3.-availability-through-distributed-data-storage"></a>

* Stores data across **multiple locations** or data centers to **reduce the risk of data loss or corruption**.
* **Replicates** data across **geographically** diverse locations to ensure availability even if one site experiences an outage.
* Crucial for organizations dealing with large volumes of data.

#### &#x20;Availability and Consistency Models (Strong, Weak, Eventual) <a href="#4.-availability-and-consistency-models-strong-weak-eventual" id="4.-availability-and-consistency-models-strong-weak-eventual"></a>

* **Consistency Models** defines how a distributed system maintains a coherent and up-to-date view of its data across all replicas.
* Different models provide different trade-offs between availability, performance, and data correctness.
  * **Strong Consistency**: This model ensures that all replicas have identical data at all times. However, this comes at the expense of decreased availability and performance.
  * **Weak Consistency**: This model allows for temporary discrepancies between replicas, which in turn enhances availability and performance.
  * **Eventual Consistency**: This model guarantees that all replicas will ultimately align to display the same data, striking a balance between consistency, availability, and performance.

#### &#x20;Availability through Health Monitoring and Alerts <a href="#5.-availability-through-health-monitoring-and-alerts" id="5.-availability-through-health-monitoring-and-alerts"></a>

* Implements robust health monitoring systems to proactively **identify** and address potential **issues**.
* Real-time monitoring and automated alerts enable timely response and rapid resolution of problems.
* Continuously monitors system performance, resource utilisation, and various metrics to detect anomalies or potential issues.

#### Availability through Geographic Distribution <a href="#7.-availability-through-geographic-distribution" id="7.-availability-through-geographic-distribution"></a>

* Involves deploying system components across multiple locations or data centers.
* Ensures system access even if one region or data center experiences an outage.
* Particularly important for organizations with a global presence or those that heavily rely on cloud infrastructure.
* By strategically placing system components in different geographical areas, uninterrupted system access is ensured for users from various locations, regardless of localized incidents or natural disasters.



### Fault Tolerance vs. High Availability 

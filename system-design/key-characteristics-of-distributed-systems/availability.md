# Availability

### Availability

Disponibilidade é relacionada à frequência com que o sistema está online, em execução e provendo serviços e funcionalidade aos seus usuários (INDRASIRI; SUHOTHAYAN, 2021 e NEWMAN, 2021).

* High Availability encompasses:
  * running (online)
  * system can handle increased load and traffic without compromising its performance.

High availability is often **measured** in terms of **uptime**, which is the ratio of time that a system is operational to the total time it is supposed to be operational.

Achieving high availability involves **minimizing** planned and _unplanned downtime, eliminating single points of failure, and implementing redundant systems and processes_.



### Strategies for Achieving High Availability

#### High Availability through Redundancy and Replication <a href="#id-1.-high-availability-through-redundancy-and-replication" id="id-1.-high-availability-through-redundancy-and-replication"></a>

* Duplicates critical components or entire systems for seamless takeover by the **redundant** **server** if one fails.
* Creates multiple copies of data to ensure availability (**replication**).
* Commonly used in data centers where multiple servers handle the workload.
  * In the event of a hardware failure or system crash, the **redundant** server takes over, ensuring uninterrupted service for users.

#### Availability through Load Balancing <a href="#id-2.-availability-through-load-balancing" id="id-2.-availability-through-load-balancing"></a>

* Distributes workloads across multiple servers to prevent any single server from being overwhelmed.
* Optimizes **resource utilization** and prevents bottlenecks (all this enhances availability).
* Particularly useful in web applications with a large number of simultaneous users.

#### Availability through Distributed Data Storage <a href="#id-3.-availability-through-distributed-data-storage" id="id-3.-availability-through-distributed-data-storage"></a>

* Stores data across **multiple locations** or data centers to **reduce the risk of data loss or corruption**.
* **Replicates** data across **geographically** diverse locations to ensure availability even if one site experiences an outage.
* Crucial for organizations dealing with large volumes of data.

#### &#x20;Availability and Consistency Models (Strong, Weak, Eventual) <a href="#id-4.-availability-and-consistency-models-strong-weak-eventual" id="id-4.-availability-and-consistency-models-strong-weak-eventual"></a>

* **Consistency Models** defines how a distributed system maintains a coherent and up-to-date view of its data across all replicas.
* Different models provide different trade-offs between availability, performance, and data correctness.
  * **Strong Consistency**: This model ensures that all replicas have identical data at all times. However, this comes at the expense of decreased availability and performance.
  * **Weak Consistency**: This model allows for temporary discrepancies between replicas, which in turn enhances availability and performance.
  * **Eventual Consistency**: This model guarantees that all replicas will ultimately align to display the same data, striking a balance between consistency, availability, and performance.

#### &#x20;Availability through Health Monitoring and Alerts <a href="#id-5.-availability-through-health-monitoring-and-alerts" id="id-5.-availability-through-health-monitoring-and-alerts"></a>

* Implements robust health monitoring systems to proactively **identify** and address potential **issues**.
* Real-time monitoring and automated alerts enable timely response and rapid resolution of problems.
* Continuously monitors system performance, resource utilisation, and various metrics to detect anomalies or potential issues.

#### Availability through Geographic Distribution <a href="#id-7.-availability-through-geographic-distribution" id="id-7.-availability-through-geographic-distribution"></a>

* Involves deploying system components across multiple locations or data centers.
* Ensures system access even if one region or data center experiences an outage.
* Particularly important for organizations with a global presence or those that heavily rely on cloud infrastructure.
* By strategically placing system components in different geographical areas, uninterrupted system access is ensured for users from various locations, regardless of localized incidents or natural disasters.



### Fault Tolerance vs. High Availability

**Consistência** é o atributo de qualidade pela qual obtém-se a mesma resposta ao consultar todas as réplicas de um componente que estão executando em máquinas diferentes; **disponibilidade** é o atributo de qualidade que significa que cada requisição realizada para um componente do sistema recebe uma resposta; **tolerância** de partição é a qualidade do sistema que expressa a capacidade de lidar com situações onde não é possível estabelecer comunicação entre componentes em determinados momentos (NEWMAN, 2021).



#### Fault Tolerance

**Fault tolerance** is defined as the uninterrupted operation of a system, even when one or more of its components fail. The design of fault-tolerant systems is such that hardware, software, and network failures are handled seamlessly (Design Gurus, 2023a).



According to Design Gurus (2023a), a system that is fault tolerant has the following characteristics:

* **Redundancy:** It helps avoid single point of failure.
* **Automatic Failover**: Automatically switches to a redundant or standby system upon the failure of a system component.
* **No Data Loss**: Ensures that no data is lost in the event of a failure.
* **Cost**: Generally more expensive due to the need for redundant components.



#### High Availability

High Availability is characterized by the system's capability to stay operational and accessible for a very high percentage of time, with downtime being minimized as much as possible (Design Gurus, 2023a).



A system that is highly available has the following characteristics (Design Gurus, 2023a):

* **Uptime Guarantee**: Designed to ensure a high level of operational performance and uptime (often quantified in terms of “nines” – for example, 99.999% availability).
* **Load Balancing and Redundancy**: load balancing, redundant systems are some of the techniques that are applied in order to achieve high availability.
* **Rapid Recovery**:  The system should be designed in a way that allows for quick restoration of service after a failure, although a brief disruption may be acceptable.



#### Key differences - Fault Tolerance vs. High Availability

* Goal:
  * Fault Tolerance: The design is such that it can handle failures without any service interruption or data loss (\~ no downtime).
  * High Availability: The aim is to ensure that a system is usually available, with **minimal downtime**.
* Approach:
  * Fault Tolerance: Redundancy and automatic failover mechanisms are involved.
  * High Availability: Prevent downtime through redundant resources and rapid recovery strategies.
* Downtime:
  * Fault Tolerance:  No downtime even during failure.
  * High Availability: There is minimal downtime, but brief interruptions are acceptable
* Cost and Complexity:
  * Fault Tolerance: It is more expensive and complex due to the need for exact replicas and seamless failover.
  * High Availability: It is more cost-effective, balancing the level of availability with associated costs.
* Data Integrity:
  * Fault Tolerance: Data integrity is maintained even in failure scenarios.
  * High Availability: System uptime is prioritized, with potential for minimal data loss in certain failure conditions.
    * Se dois componentes em um sistema distribuído não puderem se comunicar, as atualizações não são propagadas para todos. Os sistemas que **cedem consistência** para manter a tolerância e a disponibilidade de partição são **eventualmente consistentes** (NEWMAN, 2021).



### References

Design Gurus. Grokking System Design Fundamentals. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-system-design-fundamentals/](https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641ed36e12e1f4e2a46ca14d)>. Acesso em: 12 dez. 2023a.

NEWMAN, Sam. Building Microservices. 2nd ed. Sebastopol: O'Reilly Media, 2021. 612 p. ISBN: 978-1-492-03402-5.

INDRASIRI, Kasun; SUHOTHAYAN, Sriskandarajah. Design Patterns for Cloud Native Applications. 1st ed. Sebastopol: O'Reilly Media, 2021. 311 p. ISBN: 978-1-492-09071-7.

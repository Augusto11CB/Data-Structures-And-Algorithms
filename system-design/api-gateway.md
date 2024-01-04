# API Gateway



* API Gateway is an **intermediary (midleware)** between clients (such as web browsers, mobile apps, or other services) and backend services, microservices, or APIs.
* **Main purpose:** to provide a single entry-point for external consumers to access the services and functionalities of the backend system.
* Request trajectory:&#x20;
  1. API Gateway receives client requests.
  2. Forwards them to the appropriate backend service.
  3. Returns the server’s response to the client.

<figure><img src="../.gitbook/assets/image (2) (1) (1).png" alt="" width="375"><figcaption><p>Font: Design Gurus, 2023a</p></figcaption></figure>



### API Gateway Vs. Load Balancer

* API Gateway: focused on **routing** requests to the appropriate backend service based on specific URLs.
* Load Balancer: focused on **distributing** requests _evenly_ across a group of backend servers.

<figure><img src="../.gitbook/assets/image (5) (1).png" alt="" width="375"><figcaption><p>Font: Design Gurus, 2023a</p></figcaption></figure>



### Usage of API gateway

* **Routing** is facilitated by API gateways, which receive and direct client requests to the appropriate services, simplifying system design.
* **Rate limiting** and throttling are enabled by API gateways to prevent malicious behavior and denial of service attacks.
* **Performance** is enhanced by API gateways through caching responses, reducing the number of forwarded requests.
* **Authentication** and **authorization** are enforced by API gateways, which authenticate clients and ensure authorized access only.
* **Monitoring** capabilities are provided by API gateways, collecting metrics and data on requests and responses to aid in problem identification and system reliability improvement.
* **Data transformation** is facilitated by API gateways, converting formats or aggregating data from multiple services into a single response for client convenience.
* **Request and response validation** are ensured by API gateways, adhering to expected formats and structures to prevent errors and maintain service functionality.
* **The circuit breaker pattern** can be implemented by API gateways, monitoring service health and automatically switching to backup services if needed to prevent system failure.
* **Service discovery** is enabled by API gateways, allowing clients to access services without specific addresses, facilitating the addition or modification of services without affecting clients.
* API versioning is supported by API gateways, allowing developers to introduce new features or changes without disrupting existing clients.
* Consistent error handling and generation of error responses are provided by API gateways, even when backend services are unavailable or return unexpected results.
* Font: BUENO, 2023 is supported by API gateways, combining responses from multiple backend services into a single response for clients, simplifying integration and reducing client requests.
* Protection against common web-based threats is offered by API gateways through the incorporation of a **Web Application Firewall (WAF)**.
* **API documentation** based on standardized formats, such as Swagger or OpenAPI, can be generated and served by API gateways, enhancing developer understanding and facilitating API usage.



### Advantages and Disadvantages

#### Advantages of using an API Gateway

* Improved performance through caching, rate limiting, and optimized communication.
* Simplified system design with a single entry point for API requests.
* Enhanced security through authentication and authorization enforcement.
* Improved scalability by distributing requests among multiple microservice instances.
* Better monitoring and visibility with collected metrics and data.
* Simplified client integration by providing a consistent interface.
* Protocol and data format transformation for flexible communication.
* API versioning and backward compatibility for smooth transitions.
* Enhanced error handling for a better user experience.
* Load balancing and fault tolerance for improved performance.

#### Disadvantages of using an API Gateway

* Additional complexity in the architecture.
* Single point of failure if not configured properly.
* Potential latency introduced in the request-response path.
* Vendor lock-in when using a specific provider.
* Increased cost for infrastructure and services.
* Maintenance overhead for monitoring and updates.
* Configuration complexity, especially in large-scale deployments.



### API Gateway Summary

<figure><img src="../.gitbook/assets/WhatsApp Image 2023-12-24 at 16.19.39 (1).jpeg" alt=""><figcaption><p>Font: BUENO, 2023</p></figcaption></figure>

<figure><img src="../.gitbook/assets/WhatsApp Image 2023-12-24 at 16.19.39 (2).jpeg" alt=""><figcaption><p>Font: BUENO, 2023</p></figcaption></figure>

### References

Design Gurus. Grokking System Design Fundamentals: API Gateway. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641ed36e12e1f4e2a46ca14d](https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641ed36e12e1f4e2a46ca14d)>. Acesso em: 12 dez. 2023a.


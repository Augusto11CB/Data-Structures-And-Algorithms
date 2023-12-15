# API Gateway

* API Gateway is an **intermediary (midleware)** between clients (such as web browsers, mobile apps, or other services) and backend services, microservices, or APIs.
* **Main purpose:** to provide a single entry-point for external consumers to access the services and functionalities of the backend system.
* Request trajectory:&#x20;
  1. API Gateway receives client requests.
  2. Forwards them to the appropriate backend service.
  3. Returns the server’s response to the client.

<figure><img src="../.gitbook/assets/image (2) (1).png" alt="" width="375"><figcaption><p>Design Gurus, 2023a</p></figcaption></figure>



### API Gateway Vs. Load Balancer

* API Gateway: focused on **routing** requests to the appropriate backend service based on specific URLs.
* Load Balancer: focused on **distributing** requests _evenly_ across a group of backend servers.

<figure><img src="../.gitbook/assets/image (5).png" alt="" width="375"><figcaption><p>Design Gurus, 2023a</p></figcaption></figure>



### Uses of API Gateways





### References

Design Gurus. Grokking System Design Fundamentals: API Gateway. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641ed36e12e1f4e2a46ca14d](https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641ed36e12e1f4e2a46ca14d)>. Acesso em: 12 dez. 2023a

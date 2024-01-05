# Scalability

**Escalabilidade** é a capacidade de suportar cargas crescentes sem impactar a performance. Um possível exemplo de escalabilidade é a capacidade de expandir componentes da infraestrutura, como aumentar o número de instâncias de um microsserviço para atender  um aumento do número de usuários simultâneos (NEWMAN, 2021).

It is possible to scale a system by adding more resources (scaling out/horizontal scaling), or by updating the capacity of the existing resources (scaling up).



### Horizontal Scaling

* It involves adding more machines or nodes to a system to distribute the workload evenly.
* dimensionamento elástico (capacidade de adicionar ou remover servidores dependendo da carga de trabalho) é um exemplo dessa dinamicidade (BUENO, 2023).



### Vertical Scaling

* Achieved by upgrading the hardware, such as adding more CPU, memory, or storage.
* This approach has limitations, as there is a physical limit to the amount of resources that can be added to a single machine.



### Horizontal Scaling vs. Vertical Scaling

* **Horizontal Scaling**:
  * Easier to scale dynamically by adding more machines into the existing pool.
  * Good examples: Cassandra and MongoDB, which allow easy horizontal scaling to meet growing needs.
* **Vertical Scaling**:
  * Usually limited to the capacity of a single server.
  * Scaling beyond that capacity often involves downtime and comes with an upper limit.
  * Good example: MySQL, which allows easy vertical scaling by switching from smaller to bigger machines, but often involves downtime.



### References

Design Gurus. Grokking System Design Fundamentals. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-system-design-fundamentals/](https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641ed36e12e1f4e2a46ca14d)>. Acesso em: 12 dez. 2023a.

NEWMAN, Sam. Building Microservices. 2nd ed. Sebastopol: O'Reilly Media, 2021. 612 p. ISBN: 978-1-492-03402-5.

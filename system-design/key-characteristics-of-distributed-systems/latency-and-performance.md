# Latency and Performance

Performance está relacionada com a rapidez e eficiência que um sistema ou aplicação executa uma determinada operação sob uma determinada carga de trabalho. Dentre as principais grandezas para avaliar performance estão as restrições envolvendo limites de tempo e espaço, como cargas de trabalho, tempo de resposta, taxa de transferência e espaço de armazenamento disponível (CHUNG; LEITE, 2009).



A latência pode ser definida como o tempo necessário para que dados se movam de um local para outro através da rede (RICHARDS; FORD, 2020).



In distributed systems, optimizing latency and performance involves considering factors such as data locality, load balancing, and caching strategies.



* **Data locality** is referred to as the minimization of data transfer between nodes through the organization and distribution of data. This is achieved by storing related data close together or near the nodes that frequently access it, resulting in reduced latency and improved performance. Data partitioning, sharding, and data replication are techniques used to achieve data locality.
* **Caching strategies** involve the temporary storage of frequently accessed data or computed results. This allows the system to quickly retrieve the data from the cache instead of recalculating or fetching it from the primary data source, significantly reducing latency and improving the performance of the distributed system. In-memory caching, distributed caching, and content delivery networks (CDNs) are common caching strategies.



### References

Design Gurus. Grokking System Design Fundamentals. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-system-design-fundamentals/](https://www.designgurus.io/course-play/grokking-system-design-fundamentals/doc/641ed36e12e1f4e2a46ca14d)>. Acesso em: 12 dez. 2023a.

CHUNG, Lawrence; LEITE, Julio. On Non-Functional Requirements in Software Engineering. Mylopoulos Festschrift, LNCS 5600, p. 363–379, 2009.

RICHARDS, Mark; FORD, Neal. Fundamentals of Software Architecture. 1st ed. Sebastopol: O'Reilly Media, 2020. 419 p. ISBN: 978-1-492-04345-4.

## Requirements
- Any library member should be able to search books by:
  - title,
  - author,
  - subject category
  - publication date.
  - [Book, Business Logic]

- Each book will have a **unique identification number** and other details including a **rack number** which will help to physically locate the book.
  - rack number,
  - unique identifier number,
  - etc.
  - [Book]

- **Book Item**
  - Each copy of a book is called a **book item**,
  - There could be more than one copy of a book,
  - Library members should be able to check-out and reserve any copy,
  - [Members, Book, Checkout/Reservation (?)]

- The system should be able to **retrieve information** like 
  - Who **took a particular book**,
  - What are the books checked-out by a specific library member,
  - [BookHistory, MemberReservedBooks]

- There should be a maximum limit (5) on how many books a member can check-out,
  - [Business Logic]

- There should be a maximum limit (10) on how many days a member can keep a book,
  - [Business Logic, Book Reservation Property (?)]

- The system should be able to collect fines for books returned after the due date,
  - [Business Logic]

- Members should be able to **reserve books** that are not currently available,
  - [ Property Reservation property (?) (Queue?)]

- The system should be able to send notifications:
  - Whenever the reserved books become available,
  - Whenever book is not returned within the due date,


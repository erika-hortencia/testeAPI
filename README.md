# testeAPI

## Class diagram

```mermaid
classDiagram
    class User {
        +int id
        +string name
        +string login
        +string password
        +string birthdate
        +int age
    }
    
    class Event {
        +string name
        +string type
    }

    class Goal {
        +string deadline
        +string periodicity
    }

    class Task {
        +string date
        +string priority_level
        +bool status
    }

    User "1" --> "0..*" Event : participates in
    Event <|-- Goal : specializes
    Event <|-- Task : specializes
```

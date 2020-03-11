# ME Android Code Challenge


# Employee List and Detail View Application

Implemented using Kotlin and Android Studio

RecyclerView is used for implement employee list

API integration using Retrofit, RxJava and RxAndroid

# Application Screens

Employee List

![](images/employee_list.png)

Employee Detail View

![](images/employee_detail_view.png)

# API Responses

Employee  list response 

    [{
        "id": 1,
        "first_name": "John",
        "last_name": "Doe",
        "gender": "male",
        "birth_date": "01 January 1980",
        "image": "/9j/4AAQSkZJRgABAgEAZABkAAD/4RssRXhpZgAATU0AKgAAAAgABwESAAMAAAABAAEAAAEaAAUA\nAAABAAAAYgEbAAUAAAABAAAAagEoAAMAAAABAAIAAAExAAIAAAAcAAAAcgEyAAIAAAAUAAAAjodp\nAAQAAAABAAAApAAAANAAD0JAAAAnEAAPQkAAACcQQWRvYmUgUGhvdG9zaG9wIENTMyBXaW5kb3dz\nADIwMTI6MDU6MTMgMTc6MDE6MjYAAAAAA6ABAAMAAAAB//8AAKACAAQAAAABAAADBqADAAQAAAAB\nAAAECAAAAAAAAAAGAQMAAwAAAAEABgAAARoABQAAAAEAAAEeARsABQAAAAEAAAEmASgAAwAAAAEA\nAgAAAgEABAAAAAEAAAEuAgIABAAAAAEAABn2AAAAAAAAAEgAAAABAAAASAYG7APFIwn2fPyqUG8\nydVqgggAAq1ERh9sxBV1faCQJr//2Q==\n",
        "thumbImage": "\"/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAqFRflzkkoorarUqRqNJs+3wOGw88JBygm7dkf/Z\""
    },
    {
        "id": 1,
        "first_name": "John",
        "last_name": "Doe",
        "gender": "male",
        "birth_date": "01 January 1980",
        "image": "/9j/4AAQSkZJRgABAgEAZABkAAD/4RssRXhpZgAATU0AKgAAAAgABwESAAMAAAABAAEAAAEaAAUA\nAAABAAAAYgEbAAUAAAABAAAAagEoAAMAAAABAAIAAAExAAIAAAAcAAAAcgEyAAIAAAAUAAAAjodp\nAAQAAAABAAAApAAAANAAD0JAAAAnEAAPQkAAACcQQWRvYmUgUGhvdG9zaG9wIENTMyBXaW5kb3dz\nADIwMTI6MDU6MTMgMTc6MDE6MjYAAAAAA6ABAAMAAAAB//8AAKACAAQAAAABAAADBqADAAQAAAAB\nAAAECAAAAAAAAAAGAQMAAwAAAAEABgAAARoABQAAAAEAAAEeARsABQAAAAEAAAEmASgAAwAAAAEA\nAgAAAgEABAAAAAEAAAEuAgIABAAAAAEAABn2AAAAAAAAAEgAAAABAAAASAYG7APFIwn2fPyqUG8\nydVqgggAAq1ERh9sxBV1faCQJr//2Q==\n",
        "thumbImage": "\"/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAqFRflzkkoorarUqRqNJs+3wOGw88JBygm7dkf/Z\""
    }]
    
Employee details Response

    {
        "id": 1,
        "first_name": "John",
        "last_name": "Doe",
        "gender": "male",
        "birth_date": "01 January 1980",
        "image": "/9j/4AAQSkZJRgABAgEAZABkAAD/4RssRXhpZgAATU0AKgAAAAgABwESAAMAAAABAAEAAAEaAAUA\nAAABAAAAYgEbAAUAAAABAAAAagEoAAMAAAABAAIAAAExAAIAAAAcAAAAcgEyAAIAAAAUAAAAjodp\nAAQAAAABAAAApAAAANAAD0JAAAAnEAAPQkAAACcQQWRvYmUgUGhvdG9zaG9wIENTMyBXaW5kb3dz\nADIwMTI6MDU6MTMgMTc6MDE6MjYAAAAAA6ABAAMAAAAB//8AAKACAAQAAAABAAADBqADAAQAAAAB\nAAAECAAAAAAAAAAGAQMAAwAAAAEABgAAARoABQAAAAEAAAEeARsABQAAAAEAAAEmASgAAwAAAAEA\nAgAAAgEABAAAAAEAAAEuAgIABAAAAAEAABn2AAAAAAAAAEgAAAABAAAASAYG7APFIwn2fPyqUG8\nydVqgggAAq1ERh9sxBV1faCQJr//2Q==\n",
        "thumbImage": "\"/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAqFRflzkkoorarUqRqNJs+3wOGw88JBygm7dkf/Z\""
    }

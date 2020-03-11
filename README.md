# ME Android Code Challenge


# Employeed List and Detail View Application

Implemented using Kotlin and Android Studio

Implemented Employee List using RecyclerView in Android

API integration using Retrofit, RxJava and RxAndroid

# Application Screens

Employeed List

![](app/src/main/res/images/employee_list.png)

Employee Detail View

![](app/src/main/res/images/employee_detail_view.png)

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

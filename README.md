# Movie Catalogue System

This is a Spring Boot application for browsing and favoriting movies, integrating with the TMDb API.

## Features

- Browse trending movies
- View movie details
- Add movies to favorites
- View favorite movies

## URLs

1.  Homepage:
   - `GET /movies`  
     Displays a list of trending movies fetched from TMDb.

2. Movie Details:
   - `GET /movie/{id}`  
     Displays details of a specific movie. Replace `{id}` with the movie ID from the TMDb API.

3. Add to Favorites:
   - `GET /add-to-favorites/{id}`  
     Adds a movie to your favorites list. Replace `{id}` with the movie ID.

4. View Favorites
   - `GET /favorites`  
     Displays a list of all the movies added to your favorites.

## Setup

1. Clone the repository:

   ```bash
   git clone (https://github.com/palakv213/Java_Movie_catalogue.git)
   cd movie-catalogue
   
2. Build the Project:
   ./gradlew build
3. Run the project:
   ./gradlew bootRun

5. Access the application on http://localhost:8080.


Key URLs:
- `/movies` – Home page showing trending movies.
- `/movie/{id}` – Movie details page for a given movie ID.
- `/add-to-favorites/{id}` – Add movie to favorites (via `GET`).
- `/favorites` – View the list of favorite movies.

Technologies Used:


Spring Boot
Thymeleaf
TMDb API
H2 Database (In-memory)

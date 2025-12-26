CREATE TABLE t_directors(
    director_id BIGSERIAL PRIMARY KEY,
    director_name VARCHAR(255),
    director_country VARCHAR(255)
);

CREATE TABLE t_genres(
    genre_id BIGSERIAL PRIMARY KEY,
    genre_name VARCHAR(255)
);

CREATE TABLE t_movies(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    year INTEGER,
    rating DOUBLE PRECISION,
    director_id BIGINT,
    CONSTRAINT fk_director FOREIGN KEY (director_id)
        REFERENCES t_directors(director_id) ON DELETE SET NULL,
    genre_id BIGINT,
    CONSTRAINT fk_genre FOREIGN KEY (genre_id)
        t_genres(genre_id) ON DELETE SET NULL
);


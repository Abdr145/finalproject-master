INSERT INTO t_directors (director_name, director_country) VALUES
            ('Abai Kunanbaev', 'Kazakhstan'),
            ('Christopher Nolan', 'UK'),
            ('Quentin Tarantino', 'USA');
INSERT INTO t_genres (genre_name) VALUES
            ('Action'),
            ('Drama'),
            ('Comedy'),
            ('Thriller');
INSERT INTO t_movies (title, year, rating, director_id, genre_id) VALUES
            ('Avatar 2', 1993, 8.1, 1, 1),
            ('Inception', 2010, 8.8, 2, 1),
            ('Pulp Fiction', 1994, 8.9, 3, 2);

INSERT INTO User (User, Role, Pass, FullName, Age) VALUES
('alice', 'Admin', '123', 'Alice Pleasance Liddell',17),
('bob', 'User', '123', 'Bob Marley', 36),
('kate', 'User', '123', 'Katy Perry', 39);

INSERT INTO Author (Id, Name) VALUES
(1, 'George Orwell'),
(2, 'J.K. Rowling'),
(3, 'F. Scott Fitzgerald'),
(4, 'Mary Shelley'),
(5, 'Leo Tolstoy');

INSERT INTO Book (Id, Title, Category) VALUES
(1, '1984', 'Dystopian'),
(2, 'Animal Farm', 'Political Satire'),
(3, 'Harry Potter and the Philosopher\'s Stone', 'Fantasy'),
(4, 'Harry Potter and the Chamber of Secrets', 'Fantasy'),
(5, 'The Great Gatsby', 'Novel'),
(6, 'Frankenstein', 'Gothic Novel'),
(7, 'Anna Karenina', 'Literary Fiction'),
(8, 'War and Peace', 'Historical Fiction'),
(9, 'The Death of Ivan Ilyich', 'Literary Fiction'),
(10, 'Harry Potter and the Prisoner of Azkaban', 'Fantasy');

INSERT INTO BookAuthor (BId, AId) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 4),
(7, 5),
(8, 5),
(9, 5),
(10, 2);

INSERT INTO Offers (UId, BId) VALUES
('bob', 1),
('kate', 5);

INSERT INTO Requests (UId, BId) VALUES
('alice', 10),
('alice', 3),
('bob', 7);

INSERT INTO FavoriteAuthors (UId, AId) VALUES
('alice', 1),
('alice', 2),
('alice', 3),
('bob', 1),
('bob', 4),
('kate', 5),
('kate', 3),
('kate', 2),
('bob', 5),
('alice', 4);

INSERT INTO FavoriteCategories (UId, Category) VALUES
('alice', 'Dystopian'),
('alice', 'Fantasy'),
('bob', 'Political Satire'),
('bob', 'Gothic Novel'),
('kate', 'Historical Fiction'),
('kate', 'Literary Fiction'),
('kate', 'Novel');


DROP TABLE Requests;
DROP TABLE Offers;
DROP TABLE FavoriteAuthors;
DROP TABLE FavoriteCategories;
DROP TABLE BookAuthor;
DROP TABLE Author;
DROP TABLE Book;
DROP TABLE User;


CREATE TABLE User (
    User VARCHAR(255) PRIMARY KEY,
    Role VARCHAR(255),
    Pass VARCHAR(255),
    FullName VARCHAR(255),
    Age INT
);

CREATE TABLE Book (
    Id INT PRIMARY KEY,
    Title VARCHAR(255),
    Category VARCHAR(255)
);

CREATE TABLE Author (
    Id INT PRIMARY KEY,
    Name VARCHAR(255)
);

CREATE TABLE BookAuthor (
    BId INT,
    AId INT,
    PRIMARY KEY (BId, AId),
    FOREIGN KEY (BId) REFERENCES Book(Id),
    FOREIGN KEY (AId) REFERENCES Author(Id)
);

CREATE TABLE FavoriteAuthors (
    UId VARCHAR(255),
    AId INT,
    PRIMARY KEY (UId, AId),
    FOREIGN KEY (UId) REFERENCES User(User),
    FOREIGN KEY (AId) REFERENCES Author(Id)
);

CREATE TABLE FavoriteCategories (
    UId VARCHAR(255),
    Category VARCHAR(255),
    PRIMARY KEY (UId, Category),
    FOREIGN KEY (UId) REFERENCES User(User)
);

CREATE TABLE Offers (
    UId VARCHAR(255),
    BId INT,
    PRIMARY KEY (UId, BId),
    FOREIGN KEY (UId) REFERENCES User(User),
    FOREIGN KEY (BId) REFERENCES Book(Id)
);

CREATE TABLE Requests (
    UId VARCHAR(255),
    BId INT,
    PRIMARY KEY (UId, BId),
    FOREIGN KEY (UId) REFERENCES User(User),
    FOREIGN KEY (BId) REFERENCES Book(Id)
);

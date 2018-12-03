/*
 * postgres script.
 * Load the database with reference data and unit test data.
 */

-- password is 'password'
INSERT INTO Account (username, password, adminFlag)
 VALUES ('admin', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', true);
-- password is 'password'
INSERT INTO Account (username, password, adminFlag)
VALUES ('user', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', false);
-- password is 'operations'

INSERT INTO Person(name,surname,middleName,address, phone, birthdate)
  VALUES ('Alex', 'Orel', 'Petrovich','Nachichevan','8-800-555-35-35','1995-01-01');
INSERT INTO Person(name,surname,middleName,address, phone, birthdate)
  VALUES ('Sergey', 'Lavrov', 'Petrovich','Armavir','8-800-000-00-00','1995-02-02');
INSERT INTO Person(name,surname,middleName,address, phone, birthdate)
  VALUES ('Michail', 'Orel', 'Nickolaevich','Armavir','8-800-000-00-00','1995-02-02');


INSERT INTO Vote(dateTime, address, description)
  VALUES ('2017-02-02', 'I love Rostov-on-Don','Major elections');

INSERT INTO Vote(dateTime, address, description)
  VALUES ('2016-12-15', 'Taganrog','President elections');


INSERT INTO PersonVote(personId,voteId,voted)
  VALUES (1, 1, TRUE);


INSERT INTO PersonVote(personId,voteId,voted)
  VALUES (1, 2, false);


INSERT INTO PersonVote(personId,voteId,voted)
  VALUES (2, 1, false);
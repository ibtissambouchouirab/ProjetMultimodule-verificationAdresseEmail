-- Users
INSERT INTO USER( name ,last_name ,pseudo_name ,email ,password, is_email_verified )
    VALUES  ('ibi','ibilast', 'ibipseudo','ibi.email@test.ib','Pass@2345', true);


-- CODES
INSERT INTO CODE( value ,creation_date ,experation_date )
   VALUES  ( 127635, NOW(), NOW());


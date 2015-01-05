-----------------------------------------
-- auto increment dictionary_colloquial_expressions
--DROP SEQUENCE synonym_seq
CREATE SEQUENCE synonym_seq;
ALTER TABLE dictionary_colloquial_expressions 
    ALTER COLUMN id 
        SET DEFAULT NEXTVAL('synonym_seq');
UPDATE dictionary_colloquial_expressions 
    SET id = NEXTVAL('synonym_seq');        

-- auto increment textexpr_seq
-- DROP SEQUENCE textexpr_seq

CREATE SEQUENCE textexpr_seq;
ALTER TABLE textexpressions 
    ALTER COLUMN id 
        SET DEFAULT NEXTVAL('textexpr_seq');
UPDATE textexpressions 
    SET id = NEXTVAL('textexpr_seq');   


-- DROP SEQUENCE expressions_seq

CREATE SEQUENCE expressions_seq;
ALTER TABLE expressions 
    ALTER COLUMN id 
        SET DEFAULT NEXTVAL('expressions_seq');
UPDATE expressions 
    SET id = NEXTVAL('expressions_seq');   



-- DROP SEQUENCE buildings_seq

CREATE SEQUENCE buildings_seq;
ALTER TABLE buildings 
    ALTER COLUMN id 
        SET DEFAULT NEXTVAL('buildings_seq');
UPDATE expressions 
    SET id = NEXTVAL('buildings_seq');       



-- add sequence to buiding postion	
ALTER TABLE buildings 
    ALTER COLUMN position 
        SET DEFAULT NEXTVAL('buildings_position_seq');
		
  
# Adoption

Pet adoption system helps to search pets based on the customer expectation.

This System provide two types of services
   1. Add bulk pets
   2. Search pets 
   
 Add Bulk Pets
 -------------
    1. Its read data in CSV format and load into System
    2. If it find any issue with the input data, It will not load any of the data from the CSV
    3. Loaded data updated in-memory 
    4. To find data validity, It checks 
         1. Gender - MALE, FEMALE, NEUTERED, SPAYED
         2. Type - DOG, CAT, RABBIT
         3. Id - Valid integer
         4. Name - Valid character with-out any space
         5. ZipCode - Valid integer and Size should be 5
         
Search 
-------

    1. It receives Gender, Type, ZipCode as input
    2. All the input keys are optional. If nothing passed then return all the pet information
    3. otherwise, return pets which are meet search criteria
    
    
 To Run program in Command line,
 ------------------------------
    Run PetAdoption class (located in com.cambia.exercise.adoption.main)
    
 Integeration Test
 -----------------
   Location : IntegerationTest (com.cambia.exercise.adoption)
   
 Junit Test
 ----------
   All the core piece of codes are unit tested 
 
    

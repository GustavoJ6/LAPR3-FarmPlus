# User Manual - BDDAD

## 1. Load all the tables

```
First, load all the tables in the database. 
This can be done by oppening the directory [BDDAD/US202] 
and running the sql script in the file [US202-PhysicalModelScript.sql].
```

## 2. Insert data into the tables

```
Now, insert data into the tables.
This can be done by oppening the directory [BDDAD/US204]
and running the sql script in the file BootstrapScript.sql].
```

## 3. Run a US

```
- In order to run a US, you need to run the sql script in the file [USXXXScript.sql]
where XXX is the number of the US you want to run.
This will create all the necessary views, procedures, functions, triggers, etc...
- Then, you can either manually utilize those, or you can run the 
demo script in the file [USXXXDemo.sql].
```

------------------------------------------------------------------------------------------------------------------------------------
 ## Website:
https://dicionario-base-dados.netlify.app/index.html

### In the website, you can find the following:
- The Conceptual Model
- The Logical Model
- The Physical Model
- The Dictionary
- The collection of constraints

-----------------------------------------------------------------------------------------------------------------------------------
## Extra Information:

* Everything related to each US is inside the directory [BDDAD/USXXX].
* US203 consists only of a demo script, since it's purpose is to check the constraints. if this US is run, since it messes with the automatically generated sequences for the ID's, the database entities must be re-constructed. For that purpose, please re-run US202's script for the physical model
* US204 consists only of a bootstrap script, since it's purpose is to insert data into the tables.
* US214 needs to have two users created in the database, in order to create the snowflake schema. 
In the files we are using the users "user1" and "user2". It can be changed, but it is easier to just create those users.
User1 is the owner of the database, and user2 is the user that will be creating the snowflake schema.
Lastly, the first script to be used is the [GrantScript.sql](US214/GrantPermissions.sql) file, which will grant the necessary permissions to user2.
* US216 follows the same guidelines as US214.
# codingchallenge35_GoogleKeep

Created this Google Keep for Coding Challenge 35 by John Cricket available on following link : https://codingchallenges.fyi/challenges/challenge-keep

You clone the repository use folloing api calls : 

1. Register a user : POST : localhost:3535/users
   {
        "username":"johndoe",
        "email":"johndoe@email.com",
        "password":"password"
    }

2. Get user by id : GET : localhost:3535/users/{userId}
3. Add new notes : POST :   localhost:3535/users/{userid}/notes
   {
        "title":"note1 title",
        "content":"content of note 1"
    }
4. Get All notes for a user : GET : localhost:3535/users/{userId}/notes
5. Get Notes for a user with Note Id : GET : localhost:3535/users/{userId}/notes/{noteId}
  

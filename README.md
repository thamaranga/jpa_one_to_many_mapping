# jpa_one_to_many_mapping
This is a sample project which demonstrates Spring data JPA one to many mapping.

Here there are two entities as Student and Department. One Student can have one Department , One Department can have many Students.  Department is the parent entity and Student is the child entity. Among Department and Student there is a one to many relationship.Among Student and Department there is a many to one relationship. Here I have mapped this relationship as a bidirectional relationship. For testing these relationsip I have added below mappings inside a rest controller called TestResource.
Further this sample code contains a one example of  related to sql join also. 

1.Save data -> @GetMapping("/save")
2.Retrieve Student data -> @GetMapping("/retrieveStd")
3.Retrieve Department data -> @GetMapping("/retrieveDept")
4.Update Student data -> @GetMapping("/update")
5.Delete Department data -> @GetMapping("/delete")
6.Delete Student data -> @GetMapping("/deleteStd")
7.Join query among Student and Department  tables -> @GetMapping("/joinTest")

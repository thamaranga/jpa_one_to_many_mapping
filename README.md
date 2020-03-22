# jpa_one_to_many_mapping
This is a sample project which demonstrates Spring data JPA one to many mapping.

Here there are two entities as Student and Department. One Student can have one Department , One Department can have many Students.  Department is the parent entity and Student is the child entity. Among Department and Student there is a one to many relationship.Among Student and Department there is a many to one relationship. Here I have mapped this relationship as a bidirectional relationship. For testing these relationsip I have added below mappings inside a rest controller called TestResource.

1.Save data -> @GetMapping("/save")
2.Retrieve data -> @GetMapping("/retrieve")
3.Update data -> @GetMapping("/update")
4.Delete data -> @GetMapping("/delete")

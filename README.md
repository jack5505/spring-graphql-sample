This project stack is  **spring-boot, java, graphql, postgres, java17**

In this sample project we use spring-boot-graphql.
As I discover for myself it's powerful tools to use in development.
key thing you should add this following dependencies into you project.
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-graphql</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
this two dependencies most important to use then you should create in folder ./resources/graphql/schema.graphqls
in this file extension of graphqls you should describe with what kind of type you will work on example
```
type User {
    id: ID!
    name: String!
    email: String!
}
```
then there is existed type for Query,Mutation and others in our project we should use only two of them
``` type Query {
    getUser(id: ID!): User
    getAllUsers: [User]
}
type Mutation {
    createUser(name: String!, email: String!): User
}
```
after it you might create @Controller for receiving graphql requests there is we used @MutationMapping annotation and @QueryMapping
and all parameters you will get from requests you should mark them with annotation @Argument 
example from our project is 
```
    @MutationMapping
    public UserEntity createUser(@Argument String name,@Argument String email){
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }
    @QueryMapping
    public UserEntity getUser(@Argument Long id){
        return userRepository.findById(id).orElse(null);
    }
```
and that's it one thing I should love that there is existed documentation of it if you will write down to your application.properties 
following code 
```
spring:
  graphql:
    graphiql:
      enabled: true
```
application file in this project is in yml format     

The more informatin of spring-boot-graphql is https://docs.spring.io/spring-graphql/docs/1.2.2/reference/html


        

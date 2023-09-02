# auth service 

This authentication and authorization implementation was done to understand auth layer using spring security 3. Exploration was later enhanced and carried towards JWT implementation.
## Getting started
for windows
```agsl
.\gradlew clean build
```
for mac
```agsl
./gradlew clean build
```
execute main

## Spring Security 3
* SecurityConfig Class
  * UserDetailsService Bean: a interface used to load user details data.
  * SecurityFilterChain Bean: a bean used to cover specifications of authorisation.
  * AuthenticationProvider: a bean used to provide user details data loaded by UserDetailsService.
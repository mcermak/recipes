# Recipes
Server side service covering recipes storage

### Reference Documentation
TBD

### Additional Links
TBD

## Usage
### Start application
./gradlew build
java -jar build/libs/recipes-0.0.1-SNAPSHOT.jar

### Insert new Recipe
`curl -X POST localhost:8080/recipes -d '{"title":"dummy bread", "note":"full of energy", "procedure":"buy bread in a store", "ingredients":[{"name":"money", "unit":"peaces", "amount":"20"}]}' -H'Content-Type: application/json'`

###  Get all Recipe
`curl localhost:8080/recipes | jq`

## Planned for following development
* provide list of tags
* Searching including filters
  ** by tags,
  ** by ingredients,
  ** by name
* pagination when lists all
* ordering
* saving pictures (raw mode recipes)
* support of rating

# Url-shortener


Api for reduce long urls to smaller ones.

![](header.png)

## Installation

Compile application:

```sh
./gradlew build
```

Run application

```sh
./gradlew bootrun
```

## Endpoints description

| Endpoint | Verb | Description
| --- | --- | --- |
| /urls | GET | Retrieves all the stored url and their alias |
| /urls | POST | Stores a new url and return the new alias |
| /{alias} | GET | Returns an url for a given alias  |


## Approach
I have followed the approach of using a factory pattern to define a family of algorithms and use the right one depending at the situation. This gives to the 
application flexibility if someone wants to add a new algorithm to short the url. So, we don't have to update the occurrences or adding unnecesary if's at the app. Only just add
the new algorithm, update the factory and that's all.



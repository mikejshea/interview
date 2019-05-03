# Hammerhead Interview Development Assignment

Start by forking this repo and solving the problem with completed instructions for building/running.

Open a PR against the original hammerheadnav/interview repo when you're finished.

## Instructions

Write a simple program in a language of your choice that has implementations for three "services" (Strava, RWGPS, and Komoot).

Results should be printed to standard output after following the build instructions.

### Services

Each service has the ability to get routes. Services can retreive all routes or retrieve routes for a specific user.

#### Strava

* Has fixed routes  `["SRT", "CVT", "Perkiomen"]`
* For user routes, Strava prepends the user id onto the route.

#### RWGPS

* Has fixed routes  `["CVT", "Perkiomen", "Welsh Mountain"]`
* For user routes, RWGPS appends the user id onto the route.

#### Komoot

* Has fixed routes  `["SRT", "Welsh Mountain", "Oaks to Philly"]`
* For user routes, Komoot prepends *and* appends the user id onto the route.

### Results

The code should have the following functionality:

#### All Routes

Return the list of the routes across all services.

#### Unique Routes

Return a *unique* list of the routes across all services.

#### All User Routes

Given a user id and return a list of all the routes the user has across all services.

#### Users Routes by Service

Given a user id and a subset of the list of services (e.g. `["Strava", "Komoot"]`)
return the user's routes for only the services listed.


## Building/Running

#### Prerequisites
1. Java
1. Kotlin
1. Gradle

#### Build
`./gradlew build`

#### Run Application
1. `./gradlew run`
1. After the build the executable can be found in the zip file: `./build/distributions/interview.zip` at `./interview/bin/interview`

#### Execute Tests
1. To run tests: `./gradlew test`
1. Force tests to rerun with: `./gradlew test --rerun-tasks`
1. Veiw html report of tests: `/build/reports/tests/test/index.html`

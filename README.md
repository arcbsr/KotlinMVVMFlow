# Kotlin (MVVM)
 
## Overview
This Android application is a robust and efficient mobile solution developed using the Kotlin programming language and incorporating modern architectural and development principles. The app follows the Model-View-ViewModel (MVVM) architecture pattern to ensure separation of concerns and maintainable code. It also leverages Dagger for dependency injection, Retrofit for handling API services, Clean Architecture for code organization, and Coroutines for asynchronous operations.

## Key Features:

## MVVM Architecture
The app is structured around the MVVM architecture, separating the presentation logic (ViewModel) from the UI (View) and the data layer (Model). This enhances code maintainability, testability, and scalability.

## Dependency Injection with Dagger
Dagger / Hilt is used to manage dependencies and provide dependency injection throughout the app. This promotes code modularity and allows for easy testing and reusability.

## Retrofit API Service
Retrofit is employed for making network requests and handling API services. It simplifies the process of fetching and sending data to a remote server while providing a robust and type-safe HTTP client.

## Clean Architecture
The app follows Clean Architecture principles, which involve dividing the codebase into distinct layers (presentation, domain, and data) to facilitate separation of concerns. This design promotes code maintainability, testability, and scalability.

## Coroutines
Coroutines are used for managing asynchronous operations efficiently. They simplify background thread management, making the app responsive and performant while avoiding callback hell.

## Development Workflow:

## ViewModel
The ViewModel layer manages the presentation logic, including data preparation and transformation for the UI. It communicates with the data layer to fetch and update data.

## Repository
The repository layer acts as a bridge between the data source (API service) and the ViewModel. It abstracts the data source implementation details and provides a clean API for data access.

## Data Source
The app interacts with external data sources through Retrofit to fetch data from APIs.

## Dependency Injection
Dagger(Hilt) ensures that dependencies are injected into the components where they are needed, making the codebase modular and testable.

## Coroutines
Coroutines are employed for managing asynchronous operations, such as network requests and database interactions, in a structured and readable manner.

## Testing
Unit tests are written to validate the functionality of individual components, ensuring that the app remains robust and reliable.


## App Architecture
Here we will follow the guidance provided by Google on application architecture  to prepare a clean code architecture. 
Application architecture follows Solid principles (domain layer added using use cases)



## Functionalities
* Home Screen showing movie list 
* If item view is pressed, a Detailed Screen is shown with more details.


## Libraries Used
* [Kotlin Coroutine/Flow](https://kotlinlang.org/docs/coroutines-overview.html)
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Retrofit2](https://square.github.io/retrofit/)
* [Okhttp3](https://square.github.io/okhttp/4.x/okhttp/okhttp3/)
* [Gson](https://github.com/google/gson)
* [Glide](https://github.com/bumptech/glide)
* [Junit4](https://junit.org/junit4/)
* [Mockito](https://site.mockito.org/)
* [hamcrest](http://hamcrest.org/)
* [mockwebserver](https://github.com/square/okhttp/tree/master/mockwebserver)
* [Turbine](https://github.com/cashapp/turbine)

## Testing
* UnitTest
    * apis
    * viewmodels

## Contributing
Any improvements to the application architecture are welcome. Let's do some discussion and make requests. 

# Sigma Assessment

Welcome to the Technical Assessment Project! This project aims to demonstrate proficiency in various architectural patterns and popular Android libraries. Below, you'll find details about the architecture, libraries used, and how to set up the project.

## Project Overview

This project implements the MVI (Model-View-Intent) architecture pattern along with Clean Architecture principles. It integrates Dagger Hilt for dependency injection, Retrofit for networking, Jetpack Compose for UI, and Jetpack Navigation for seamless navigation within the app.

## Screens

<table align="center">
  <tr>
    <th>Profile</th>
    <th>Profile Details</th>
  </tr>
  <tr>
    <td align="center"><img src="https://github.com/user-attachments/assets/09841a0f-54bf-4b1d-9d72-a383d83eedd5" width="250" alt="Profile"></td>
    <td align="center"><img src="https://github.com/user-attachments/assets/bc0e207d-afab-4664-9833-2b3b13127234" width="250" alt="Profile Details"></td>
  </tr>
</table>

## Architecture Diagrams

### MVI Architecture

![MVI Diagram](https://github.com/user-attachments/assets/84557e4f-d130-443b-93f6-4a080a603b70)

The MVI architecture separates the UI from the business logic by introducing a ViewModel layer. This allows for better testability and maintainability of the codebase.

### Clean Architecture

![Modular Clean Architecture Diagram](https://github.com/IamMaher/Assignment_Universities/assets/15931456/2751283f-2393-4ff5-94de-1f3931bc7518")

## Libraries Used

- Dagger Hilt: For dependency injection, providing a modular and scalable approach to managing dependencies.
- Retrofit: For making network requests and handling API communication efficiently.
- Coroutine: Leverage Kotlin Coroutines for asynchronous programming, ensuring smooth and efficient handling of background tasks.
- Kotlin: Develop the app using Kotlin, taking advantage of its concise syntax and modern language features.
- Jetpack Compose: For local database operations, enabling seamless data persistence on the device.
- Jetpack Navigation: For managing navigation within the app, simplifying the navigation flow and ensuring a consistent user experience.


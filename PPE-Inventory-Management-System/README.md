# PPE Inventory Management System

## Overview
The PPE Inventory Management System is a Java-based application designed to manage the inventory of Personal Protective Equipment (PPE) for hospitals. The system allows for user management, inventory tracking, and supplier and hospital management, ensuring that PPE is efficiently distributed and accounted for.

## Features
- **User Management**: Admin users can add, modify, search, and delete user accounts.
- **Inventory Management**: Track PPE items, update quantities upon receipt or distribution, and monitor stock levels.
- **Supplier Management**: Create and update supplier details.
- **Hospital Management**: Manage hospital information and codes.
- **Reporting**: Generate reports on inventory levels, transactions, and item distributions.

## Project Structure
The project is organized into the following main components:
- **src/main/java/com/ppeinventory**: Contains the main application code, including controllers, models, services, and views.
- **src/main/resources**: Contains text files for storing user, PPE, supplier, hospital, and transaction data.
- **.gitignore**: Specifies files to be ignored by version control.
- **README.md**: Documentation for the project.
- **build.gradle**: Configuration file for Gradle.

## Setup Instructions
1. **Clone the Repository**: 
   ```
   git clone <repository-url>
   ```
2. **Navigate to the Project Directory**:
   ```
   cd PPE-Inventory-Management-System
   ```
3. **Build the Project**: Use Gradle to build the project.
   ```
   ./gradlew build
   ```
4. **Run the Application**: Execute the main application class.
   ```
   java -cp build/libs/PPE-Inventory-Management-System.jar com.ppeinventory.App
   ```

## Usage
- Upon launching the application, users will be prompted to log in.
- Admin users can manage users, inventory, suppliers, and hospitals through the GUI.
- Regular staff users can view inventory and request PPE as needed.

## Contributing
Contributions to the project are welcome. Please fork the repository and submit a pull request with your changes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Acknowledgments
- Thanks to the contributors and the community for their support and feedback.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientsDB {


    public static class DbAddPatients {
        String section;
        String name;
        int age;
        long nationalCode;
        String history;
        public DbAddPatients(String section, String name, int age, long nationalCode,  String history) {
            String url = "jdbc:mysql://localhost:3306/apdb";
            String username = "root";
            String password = "";

            // Data to insert
            int id = 0;
            this.section = section;
            this.name = name;
            this.age = age;
            this.nationalCode = nationalCode;
            this.history = history;

            // SQL INSERT query
            String insertQuery = "INSERT INTO patients (id, section, name, age, nationalcode, history) VALUES (?, ?, ?, ?, ?, ?)";

            try {
                // Establish a connection
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the database.");

                // Prepare the statement
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                // Set the values for the placeholders (?)
                preparedStatement.setNull(1,id);
                preparedStatement.setString(2,section);
                preparedStatement.setString(3, name);
                preparedStatement.setInt(4, age);
                preparedStatement.setLong(5, nationalCode);
                preparedStatement.setString(6, history);

                // Execute the query
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Data inserted successfully!");
                }

                // Close the connection
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class DbEditPatients {
        String section;
        String name;
        int age;
        long nationalCode;
        String history;
        DbEditPatients(long nationalCode){
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/apdb";
            String username = "root";
            String password = "";
            this.nationalCode = nationalCode;


            // SQL SELECT query
            String query = "SELECT id, section, name, age, nationalcode, history FROM patients WHERE nationalcode = ?"; // Replace table and column names as needed

            try {
                // Establish a connection to the database
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the database successfully!");

                // Prepare and execute the SELECT query
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setLong(1, nationalCode);
                ResultSet resultSet = statement.executeQuery();

                // Process the ResultSet
                System.out.println("Reading data from the table:");
                while (resultSet.next()) {
                    int id = resultSet.getInt("id"); // Replace with your column names
                    section = resultSet.getString("section");
                    name = resultSet.getString("name");
                    age = resultSet.getInt("age");
                    nationalCode = resultSet.getLong("nationalcode");
                    history = resultSet.getString("history");

                }


                // Close the connection
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String getSection(){
            return section;
        }
        String getName(){
            return name;
        }
        int getAge(){
            return age;
        }
        String getHistory(){
            return history;
        }

    }

    public static class DbDeletePatients {
        DbDeletePatients(Long nationalCode) {
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/apdb"; // Replace with your database name
            String username = "root"; // Default username for XAMPP
            String password = "";    // Default password for XAMPP (leave empty if not set)

            // The national code of the patient to delete
            long targetNationalCode = nationalCode; // Replace with the actual national code

            // SQL DELETE query
            String query = "DELETE FROM patients WHERE nationalcode = ?";

            try {
                // Establish the database connection
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the database successfully!");

                // Create a PreparedStatement for the DELETE query
                PreparedStatement statement = connection.prepareStatement(query);

                // Set the parameter for the WHERE clause
                statement.setLong(1, targetNationalCode);

                // Execute the query
                int rowsAffected = statement.executeUpdate();

                // Check if the row was deleted
                if (rowsAffected > 0) {
                    System.out.println("Row deleted successfully!");
                } else {
                    System.out.println("No row found with the specified national code.");
                }

                // Close the connection
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


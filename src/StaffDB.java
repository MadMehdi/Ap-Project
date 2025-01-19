import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffDB {


    public static class DbAddStaff {
        String name;
        int age;
        String job;
        long nationalCode;

        public DbAddStaff(String name, int age, String job, long nationalCode) {
            String url = "jdbc:mysql://localhost:3306/apdb";
            String username = "root";
            String password = "";

            // Data to insert
            int id = 0;
            this.name = name;
            this.age = age;
            this.job = job;
            this.nationalCode = nationalCode;

            // SQL INSERT query
            String insertQuery = "INSERT INTO staff (id, name, age, job, nationalcode) VALUES (?, ?, ?, ?, ?)";

            try {
                // Establish a connection
                Connection connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the database.");

                // Prepare the statement
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

                // Set the values for the placeholders (?)
                preparedStatement.setNull(1,id);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, age);
                preparedStatement.setString(4, job);
                preparedStatement.setLong(5, nationalCode);

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

    public static class DbEditStaff {
        long nationalCode;
        String job;
        String name;
        int age;
        DbEditStaff(long nationalCode){
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/apdb";
            String username = "root";
            String password = "";
            this.nationalCode = nationalCode;


            // SQL SELECT query
            String query = "SELECT id, job, name, age, nationalcode FROM staff WHERE nationalcode = ?"; // Replace table and column names as needed

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
                    job = resultSet.getString("job");
                    name = resultSet.getString("name");
                    age = resultSet.getInt("age");
                    nationalCode = resultSet.getLong("nationalcode");

                }


                // Close the connection
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String getName(){
            return name;
        }
        int getAge(){
            return age;
        }
        String getJob(){
            return job;
        }

    }

    public static class DbDeleteStaff {
        DbDeleteStaff(Long nationalCode) {
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/apdb"; // Replace with your database name
            String username = "root"; // Default username for XAMPP
            String password = "";    // Default password for XAMPP (leave empty if not set)

            // The national code of the patient to delete
            long targetNationalCode = nationalCode; // Replace with the actual national code

            // SQL DELETE query
            String query = "DELETE FROM staff WHERE nationalcode = ?";

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




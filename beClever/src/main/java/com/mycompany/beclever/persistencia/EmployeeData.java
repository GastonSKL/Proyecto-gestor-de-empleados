package com.mycompany.beclever.persistencia;

import com.mycompany.beclever.entidades.Employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class EmployeeData {

    private Connection conexionData;

    public EmployeeData(Connection connection) {
        this.conexionData = connection;
    }

    public void registarEmpleado(Employee empleado) {
        String query = "INSERT INTO employee(name, lastName, date, registerType, businessLocation, sexo) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getName());
            ps.setString(2, empleado.getLastName());
            ps.setDate(3, Date.valueOf(empleado.getDate()));
            ps.setBoolean(4, empleado.isRegisterType());
            ps.setString(5, empleado.getBusinessLocation());
            ps.setBoolean(6, empleado.isSexo());

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Empleado registrado");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no registrado");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                empleado.setIdEmployee(rs.getInt(1));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Un error a ocurrido" + ex);
        }

    }
    
    public void bajaEmpleado(int id) {
        String sql = "UPDATE employee SET registerType= false WHERE idEmployee = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo dar de baja al empleado");
            } else {
                JOptionPane.showMessageDialog(null, "Se dio de baja al empleado correctamente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception " + ex);
        }
    }
    
    public void altaEmpleado(int id) {
        String sql = "UPDATE employee SET registerType= true WHERE idEmployee = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo dar de alta al empleado");
            } else {
                JOptionPane.showMessageDialog(null, "Se dio de alta al empleado correctamente");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de tipo exception " + ex);
        }
    }
    
    public Employee buscarEmpleadoId(int id) {
        Employee empleado = null;
        String sql = "SELECT * FROM employee WHERE idEmployee = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new Employee();
                empleado.setIdEmployee(rs.getInt("idEmployee"));
                empleado.setName(rs.getString("name"));
                empleado.setLastName(rs.getString("lastName"));
                empleado.setDate(rs.getDate("date").toLocalDate());
                empleado.setRegisterType(rs.getBoolean("registerType"));
                empleado.setBusinessLocation(rs.getString("businessLocation"));
                empleado.setSexo(rs.getBoolean("sexo"));
               
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Un error a ocurrido");
        }
        return empleado;
    }
    
    public HashSet<Employee> buscarEmpleadoFecha(LocalDate fecha) {

        HashSet<Employee> empleados = new HashSet();

        String sql = "SELECT idEmployee FROM `employee` WHERE date = ?";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(fecha)); 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee empleado = buscarEmpleadoId(rs.getInt("idEmployee"));
                
                empleados.add(empleado);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la lista de empleados por fecha "+ex);
        }
        return empleados;
    }
    
    public HashSet<Employee> buscarEmpleadoEntreFechas(LocalDate fechaInicio, LocalDate fechaFinal) {

        HashSet<Employee> empleados = new HashSet();

        String sql = "SELECT * FROM `employee` WHERE date >= ? AND date <= ?";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(fechaInicio)); 
            ps.setDate(2, Date.valueOf(fechaFinal)); 
            

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee empleado = buscarEmpleadoId(rs.getInt("idEmployee"));
                
                empleados.add(empleado);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener la lista de empleados entre fechas "+ex);
        }
        return empleados;
    }
    
    public void actualizarEmpleado(Employee empleado) {
        String sqlQuery = "UPDATE employee SET name= ?, lastName= ?, date= ?, businessLocation= ?, sexo = ? WHERE idEmployee  = ?";
        if (buscarEmpleadoId(empleado.getIdEmployee()) != null) {
            try {
                PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
                ps.setString(1, empleado.getName());
                ps.setString(2, empleado.getLastName());
                ps.setDate(3, Date.valueOf(empleado.getDate()));
                ps.setString(4, empleado.getBusinessLocation());
                ps.setBoolean(5, empleado.isSexo());
                ps.setInt(6, empleado.getIdEmployee());
                
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Empleado actualizado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar empleado");
                }

                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Un error a ocurrido");
            }
        }

    }
    
    public ArrayList<Employee> listarEmpleados(boolean estado) {

        ArrayList<Employee> empleados = new ArrayList();

        String sql = "SELECT * FROM employee WHERE registerType = ?";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ps.setBoolean(1, estado); //Si el estado es true me devuelve los empleados activos, y false los que fueron dados de baja

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee empleado = new Employee();

                empleado.setIdEmployee(rs.getInt("idEmployee"));
                empleado.setName(rs.getString("name"));
                empleado.setLastName(rs.getString("lastName"));
                empleado.setDate(rs.getDate("date").toLocalDate());
                empleado.setRegisterType(estado);
                empleado.setBusinessLocation(rs.getString("businessLocation"));
                empleado.setSexo(rs.getBoolean("sexo"));
                

                empleados.add(empleado);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error");
        }
        return empleados;
    }
    
    public double promediarEmpleadosMasculinos(LocalDate fechaInicio, LocalDate fechaFinal, boolean estado) {
        int contador = 0;
        double promedio = 0;

        HashSet<Employee> empleados = new HashSet();

        String sql = "SELECT * FROM `employee` WHERE date >= ? AND date <= ? AND registerType = ?";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(fechaInicio)); 
            ps.setDate(2, Date.valueOf(fechaFinal)); 
            ps.setBoolean(3, estado);
            

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee empleado = buscarEmpleadoId(rs.getInt("idEmployee"));
                contador++;
                if(empleado.isSexo()){
                    promedio++;
                }
                empleados.add(empleado);
            }
            
            promedio = promedio / contador;
            
            ps.close();
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener el promedio de masculinos "+ex);
        }
        return promedio;
    }
    
    public double promediarEmpleadosFemeninos(LocalDate fechaInicio, LocalDate fechaFinal, boolean estado) {
        int contador = 0;
        double promedio = 0;

        HashSet<Employee> empleados = new HashSet();

        String sql = "SELECT * FROM `employee` WHERE date >= ? AND date <= ? AND registerType = ?";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(fechaInicio)); 
            ps.setDate(2, Date.valueOf(fechaFinal)); 
            ps.setBoolean(3, estado);
            

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee empleado = buscarEmpleadoId(rs.getInt("idEmployee"));
                contador++;
                if(!empleado.isSexo()){
                    promedio++;
                }
                empleados.add(empleado);
            }
            
            promedio = promedio / contador;
            
            ps.close();
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener el promedio de femeninos"+ex);
        }
        return promedio;
    }
    
    
    

}

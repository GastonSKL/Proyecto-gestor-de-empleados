package com.mycompany.beclever.persistencia;

import com.mycompany.beclever.entidades.Employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeData {

    private Connection conexionData;

    public EmployeeData(Connection connection) {
        this.conexionData = connection;
    }

    public void registarEmpleado(Employee empleado) {
        String query = "INSERT INTO employee(name, lastName, date, registerType, businessLocation) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getName());
            ps.setString(2, empleado.getLastName());
            ps.setDate(3, Date.valueOf(empleado.getDate()));
            ps.setBoolean(4, empleado.isRegisterType());
            ps.setString(5, empleado.getBusinessLocation());

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
               
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Un error a ocurrido");
        }
        return empleado;
    }

}

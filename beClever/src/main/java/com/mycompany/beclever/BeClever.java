package com.mycompany.beclever;

import com.mycompany.beclever.entidades.Employee;
import com.mycompany.beclever.persistencia.EmployeeData;
import com.mycompany.beclever.persistencia.Conexion;
import java.sql.Connection;
import java.time.LocalDate;

public class BeClever {

    public static void main(String[] args) {
        
        
        //CONEXION A DATABASE//
        Connection conDataBase = Conexion.getConexion();
        
        //--------------------------------------------------------------//
        
        //-------EMPLOYEE-----------------------------------------------//
        
        EmployeeData eData = new EmployeeData(conDataBase);
        //genero conexion entre la clase de persistencia y la base de datos pasandole la conexion por parametro constructor
        
        Employee empleado = new Employee("Carlos", "Lucero", LocalDate.of(2022, 12, 20), true, "SanLuis");
        //creo un nuevo empleado para ser agregado
        
        eData.registarEmpleado(empleado);
        //agrego un empleado con exito
        
        eData.bajaEmpleado(8);
        //se da de baja empleado con exito
        
        eData.altaEmpleado(8);
        //se da de alta el mismo empleado con exito
        
        System.out.println("Mostrando empleado " + eData.buscarEmpleadoId(8).toString());
        //se muestra empleado con id seleccionada
    }
}

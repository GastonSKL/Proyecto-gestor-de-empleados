package com.mycompany.beclever;

import com.mycompany.beclever.entidades.Employee;
import com.mycompany.beclever.persistencia.EmployeeData;
import com.mycompany.beclever.persistencia.Conexion;
import java.sql.Connection;
import java.time.LocalDate;
import java.sql.Date;

public class BeClever {

    public static void main(String[] args) {
        
        
        //CONEXION A DATABASE//
        Connection conDataBase = Conexion.getConexion();
        
        //--------------------------------------------------------------//
        
        //-------EMPLOYEE-----------------------------------------------//
        
        EmployeeData eData = new EmployeeData(conDataBase);
        //genero conexion entre la clase de persistencia y la base de datos pasandole la conexion por parametro constructor
        
        //Employee empleado = new Employee("Carlos", "Lucero", LocalDate.of(2022, 12, 20), true, "SanLuis");
        //creo un nuevo empleado para ser agregado
        
        //eData.registarEmpleado(empleado);
        //agrego un empleado con exito
        
        /*eData.bajaEmpleado(8);
        eData.bajaEmpleado(10);
        eData.bajaEmpleado(12);
        //se da de baja empleado con exito
        
        eData.altaEmpleado(8);*/
        //se da de alta el mismo empleado con exito
        
        System.out.println("Mostrando empleado " + eData.buscarEmpleadoId(8).toString());
        //se muestra empleado con id seleccionada
        
        /*Employee empleadoActualizado = new Employee(8,"Carlos", "Skamlec", LocalDate.of(2021, 01, 2), true, "Copacabana");
        //se crea nuevo empleado con un id presente en base de datos, para que pueda ser actualizado
        
        eData.actualizarCliente(empleadoActualizado);
        //se actualiza empleado con id 8 con exito*/
        
        System.out.println("Buscando empleado por fecha 2021.01.02: " + eData.buscarEmpleadoFecha(LocalDate.of(2021, 01, 02)));
        //se lista empleados por fecha
        
        System.out.println("Lista de empleados dados de alta : " + eData.listarEmpleados(true));
        //se listan empleados de alta
        
        System.out.println("Lista de empleados dados de baja :"+eData.listarEmpleados(false));
        //se listan empleados de baja
        
        System.out.println("Lista de empleados entre 2022-12-18 y 2022-12-22 de alta :" + eData.buscarEmpleadoEntreFechas(LocalDate.of(2022, 12, 18), LocalDate.of(2022, 12, 22), true));
        //se listan empleados entre 2022-12-18 y 2022-12-22 de alta
        
        System.out.println("Lista de empleados entre 2022-12-18 y 2022-12-22 de baja :" + eData.buscarEmpleadoEntreFechas(LocalDate.of(2022, 12, 18), LocalDate.of(2022, 12, 22), false));
        //se listan empleados entre 2022-12-18 y 2022-12-22 de baja
    }
        
}

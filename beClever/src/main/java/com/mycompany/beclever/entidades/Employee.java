package com.mycompany.beclever.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    
    private int idEmployee;
    private String name;
    private String lastName;
    private LocalDate date;
    private boolean registerType;
    private boolean sexo;
    private String businessLocation;

    public Employee() {
    }

    public Employee(String name,String lastName, LocalDate date, boolean registerType, String businessLocation, boolean sexo) {
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.registerType = registerType;
        this.businessLocation = businessLocation;
        this.sexo = sexo;
    }

    public Employee(int idEmployee,String name,String lastName, LocalDate date, boolean registerType, String businessLocation, boolean sexo) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
        this.registerType = registerType;
        this.businessLocation = businessLocation;
        this.sexo = sexo;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isRegisterType() {
        return registerType;
    }

    public void setRegisterType(boolean registerType) {
        this.registerType = registerType;
    }

    public String getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        this.businessLocation = businessLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idEmployee;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.date);
        hash = 29 * hash + (this.registerType ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.businessLocation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.idEmployee != other.idEmployee) {
            return false;
        }
        if (this.registerType != other.registerType) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.businessLocation, other.businessLocation)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    @Override
    public String toString() {
        return "Id del empleado: " + idEmployee + ", Nombre :" + name + ", Fecha de registro: " + date + ", Tipo de registro: " + registerType + ", Localizacion: " + businessLocation;
    }
    

    
    
    
}

package com.commerce.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.demo.Bean.Cliente;
import com.commerce.demo.Bean.Respuesta;
import com.commerce.demo.dao.ClientesDao;
import com.commerce.demo.dao.ClientesDaoImpl;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import com.commerce.demo.Bean.TelCliente;
import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
    	ClientesDao clientesDao= new ClientesDaoImpl();
    	
    	
    	Cliente cliente = new Cliente();

    	cliente.setNombres("Angel Andres");
    	cliente.setApellidos("Talavera Mendieta");
    	cliente.setTipDocumento("CI");
    	cliente.setNroDocumento("4462734");
    	cliente.setFecNacimiento("20/09/1996");
    	cliente.setDirParticular("Juan Manuel Frutos esq denis roa");
    	cliente.setCiudadParticular("ASUNCION");
    	cliente.setObsDirParticular("na");
    	cliente.setDirLaboral("Juan Manuel Frutos esq denis roa");
    	cliente.setCiudadLaboral("ASUNCION");
    	cliente.setObsDirLaboral("Es la escribania, edificio de tres pisos");
    	cliente.setNomEmpresa("EST JURIDICO MARISOL MENDIETA Y ASOC");
    	cliente.setFecIngEmpresa("01/01/2017");
    	cliente.setTipIngreso("IVA MENSUAL");
    	cliente.setMtoIngreso("15000000");
    	cliente.setDatAdicional("na");
    	
    	
    	
    	 List<TelCliente> telefonos = new ArrayList<>();

    	    // Agrega objetos TelCliente a la lista
    	    TelCliente tel1 = new TelCliente(null, "Particular", "0985448950", "S");
    	    TelCliente tel2 = new TelCliente(null, "Laboral", "0987654321", "N");

    	    telefonos.add(tel1);
    	    telefonos.add(tel2);
    	    	
    	
    	Respuesta rpta = clientesDao.altaCliente(null, cliente,telefonos);
    	
    	System.out.println(rpta.getCodigo() + " mensaje " + rpta.getMensaje());
    	
    	
    }
    	
    	
    	
    }
        /*Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            // Establece la conexión a la base de datos Oracle
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sys2023");

            // Define la llamada al procedimiento almacenado con una variable de salida
            String sql = "{call pruebaMensaje(?)}"; // Asume que el procedimiento solo tiene un parámetro de salida

            // Crea el objeto CallableStatement
            callableStatement = connection.prepareCall(sql);

            // Registra el parámetro de salida
            callableStatement.registerOutParameter(1, Types.VARCHAR); // El primer parámetro es la variable de salida

            // Ejecuta el procedimiento almacenado
            callableStatement.execute();

            // Recupera el valor de la variable de salida
            String variableSalida = callableStatement.getString(1);

            // Realiza cualquier otro trabajo necesario con la variable de salida
            System.out.println("El valor de la variable de salida es: " + variableSalida);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  }*/

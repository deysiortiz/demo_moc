package com.commerce.demo.test;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;

import com.commerce.demo.Bean.Cliente;
import com.commerce.demo.Bean.Respuesta;
import com.commerce.demo.Bean.*;
import com.commerce.demo.dao.ClientesDao;
import com.commerce.demo.dao.ClientesDaoImpl;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import com.commerce.demo.Bean.TelCliente;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class test {

	//simulador de creditos
    public static void main(String[] args) {
	ClientesDao clientesDao= new ClientesDaoImpl();
	
	 List<CredCuota> listaSolicitudes = new ArrayList<>();

	

	 Integer cancuotas=12;
	    BigDecimal monto = new BigDecimal("5000000");
	    BigDecimal tasinteres = new BigDecimal("12");
	    
	
	 listaSolicitudes = clientesDao.simuladorCredito(cancuotas, monto, tasinteres);
	
	System.out.println(listaSolicitudes.toString());
	
	
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

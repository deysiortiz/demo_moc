package com.commerce.demo.dao;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import oracle.jdbc.OracleTypes;
import oracle.sql.STRUCT;

import java.sql.Date;

import com.commerce.demo.Bean.Cliente;
import com.commerce.demo.Bean.Respuesta;
import com.commerce.demo.Bean.SolicitudCredito;
import com.commerce.demo.Bean.TelCliente;
import com.commerce.demo.Bean.Usuario;
import com.commerce.demo.connection.OracleConnection;
import com.commerce.demo.service.ClienteServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.*;


import oracle.sql.StructDescriptor;

public class ClientesDaoImpl implements ClientesDao {

	private static final Logger logger = Logger.getLogger(ClienteServiceImpl.class);
	
	
	
	@Override
	public Respuesta validarUsuario(String usuario, String contrasenha) {
		 
		Usuario user= new Usuario();
		Respuesta respuesta= new Respuesta();
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		Date fecha = new Date(System.currentTimeMillis());
        
        try {
            connection = OracleConnection.getConnection();
            
            // Llama al procedimiento almacenado
            String storedProcedure = "{CALL PR_GEN_CTL_USUARIO(?, ?, ?, ?, ?)}";
            callableStatement = connection.prepareCall(storedProcedure);
            
            // Establece los valores de los parámetros del procedimiento
            callableStatement.setString(1, usuario);
            callableStatement.setString(2, contrasenha );
            callableStatement.setString(3, "A");
            callableStatement.setDate(4, new java.sql.Date(fecha.getTime()));
            
            // Configura el parámetro de salida como un objeto STRUCT
            callableStatement.registerOutParameter(5, OracleTypes.STRUCT, "APPRESPUESTA");
            
            // Ejecuta el procedimiento almacenado
            callableStatement.execute();
            
            // Obtiene el resultado del parámetro de salida
            STRUCT resultado = (STRUCT) callableStatement.getObject(5);
            
            Object[] attributes = resultado.getAttributes();
            respuesta = new Respuesta((String) attributes[0], (String) attributes[1]);

            System.out.println("Respuesta del procedimiento: Codigo: " + respuesta.getCodigo() + ", Mensaje: " + respuesta.getMensaje());


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return respuesta;
    }
		
	@Override
	//Consultar cliente
	public Cliente obtenerCliente(String documento){
	 
		Cliente cliente = new Cliente();
		String rtaproceso;
		Connection connection = null;
		CallableStatement callableStatement = null;
        
        try {
            connection = OracleConnection.getConnection();
            
            // Llama al procedimiento almacenado "insertar_cliente"
            String storedProcedure = "{CALL PR_CON_CLIENTE(?, ?, ?)}";
            callableStatement = connection.prepareCall(storedProcedure);
            
            // Establece los valores de los parámetros del procedimiento
            callableStatement.setString(1, documento);
            
          // Configura el parámetro de salida como un objeto STRUCT
            callableStatement.registerOutParameter(2, OracleTypes.STRUCT, "TY_APP_CLIENTE");
            callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
            
            // Ejecuta el procedimiento almacenado
            callableStatement.execute();
            
            STRUCT resultado = (STRUCT) callableStatement.getObject(2);
            rtaproceso = (String) callableStatement.getObject(3);
            System.out.println("rtaproceso" + rtaproceso);
           
            
            Object[] attributes = resultado.getAttributes();
            cliente = new Cliente((String) attributes[0],
            					  (String) attributes[1],
            					  (String) attributes[2],
            					  (String) attributes[3],
            					  (String) attributes[4],
            					  (String) attributes[5],
            					  (String) attributes[6],
            					  (String) attributes[7],
            					  (String) attributes[8], 
            					  (String) attributes[9], 
            					  (String) attributes[10], 
            					  (String) attributes[11], 
            					  (String) attributes[12],
            					  (String) attributes[13],
            					  (String) attributes[14],
            					  (String) attributes[15]);
            
            System.out.println("Consulta de cliente realizada.");
            System.out.println(cliente.getApellidos());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return cliente;
		
	}
	@Override
	//Dar de alta al cliente
	public Respuesta altaCliente(HttpServletRequest request, Cliente cliente, List<TelCliente> telefonos) {
		Respuesta rpta= new Respuesta();
		
		Connection connection = null;
		CallableStatement callableStatement = null;
        
        try {
            connection = OracleConnection.getConnection();
            
            ObjectMapper objectMapper = new ObjectMapper();
            String telefonosJson = objectMapper.writeValueAsString(telefonos);
            
            // Llama al procedimiento almacenado "insertar_cliente"
            String storedProcedure = "{CALL PR_ALT_CLIENTE(?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            callableStatement = connection.prepareCall(storedProcedure);

            // Configura los parámetros del procedimiento
            callableStatement.setString(1, cliente.getNombres());
            callableStatement.setString(2, cliente.getApellidos());
            callableStatement.setString(3, cliente.getTipDocumento());
            callableStatement.setString(4, cliente.getNroDocumento());
            callableStatement.setString(5, cliente.getFecNacimiento());
            callableStatement.setString(6, cliente.getDirParticular());
            callableStatement.setString(7, cliente.getCiudadParticular());
            callableStatement.setString(8, cliente.getObsDirParticular());
            callableStatement.setString(9, cliente.getDirLaboral());
            callableStatement.setString(10, cliente.getCiudadLaboral());
            callableStatement.setString(11, cliente.getObsDirLaboral());
            callableStatement.setString(12, cliente.getNomEmpresa());
            callableStatement.setString(13, cliente.getFecIngEmpresa());
            callableStatement.setString(14, cliente.getTipIngreso());
            callableStatement.setString(15, cliente.getMtoIngreso());
            callableStatement.setString(16, cliente.getDatAdicional());
            // 1. Parámetro i_cliente (cliente)
            /*StructDescriptor tyAppClienteDescriptor = StructDescriptor.createDescriptor("TY_APP_CLIENTE", connection);
            System.out.println("ANTES DEL MAP.");
         // Convierte el objeto Cliente a un STRUCT
            Map<String, Object> tyAppClienteAttributes = new HashMap<>();
            tyAppClienteAttributes.put("nombres", cliente.getNombres());
            tyAppClienteAttributes.put("apellidos", cliente.getApellidos());
            tyAppClienteAttributes.put("tipDocumento", cliente.getTipDocumento());
            tyAppClienteAttributes.put("nroDocumento", cliente.getNroDocumento());
            tyAppClienteAttributes.put("fecNacimiento", cliente.getFecNacimiento());
            tyAppClienteAttributes.put("dirParticular", cliente.getDirParticular());
            tyAppClienteAttributes.put("ciudadParticular", cliente.getCiudadParticular());
            tyAppClienteAttributes.put("obsDirParticular", cliente.getObsDirParticular());
            tyAppClienteAttributes.put("dirLaboral", cliente.getDirLaboral());
            tyAppClienteAttributes.put("ciudadLaboral", cliente.getCiudadLaboral());
            tyAppClienteAttributes.put("obsDirLaboral", cliente.getObsDirLaboral());
            tyAppClienteAttributes.put("nomEmpresa", cliente.getNomEmpresa());
            tyAppClienteAttributes.put("fecIngEmpresa", cliente.getFecIngEmpresa());
            tyAppClienteAttributes.put("tipIngreso", cliente.getTipIngreso());
            tyAppClienteAttributes.put("mtoIngreso", cliente.getMtoIngreso());
            tyAppClienteAttributes.put("datAdicional", cliente.getDatAdicional());
            System.out.println("LUEGO DE MAP");
            try{
             STRUCT tyAppClienteStruct = new STRUCT(tyAppClienteDescriptor, connection, tyAppClienteAttributes);
             System.out.println("tyAppClienteStruct: " + tyAppClienteStruct);
             callableStatement.setObject(1, tyAppClienteStruct, OracleTypes.STRUCT);
            }catch(Exception e){
            	e.printStackTrace();
            	System.out.println(e.getMessage());
            	System.out.println("ERROR" + e.getCause());
            	System.out.println("ERROR" + e.getStackTrace());
            	
            	
  
            }*/

           
           // 2. Parámetro i_telefonos (cadena JSON)
            System.out.println("telefonosJson" + telefonosJson);
            callableStatement.setString(17, telefonosJson);

            // 3. Parámetro o_respuesta (OUT)
            callableStatement.registerOutParameter(18, Types.STRUCT, "APPRESPUESTA"); 
            // Ejecuta el procedimiento
            callableStatement.execute();
            
            STRUCT respuestaStruct = (STRUCT) callableStatement.getObject(18);
            Object[] respuestaAttributes = respuestaStruct.getAttributes();
            String codigoRespuesta = (String) respuestaAttributes[0];
            String mensajeRespuesta = (String) respuestaAttributes[1];

            rpta.setCodigo(codigoRespuesta);
            rpta.setMensaje(mensajeRespuesta);

            System.out.println("Procedimiento almacenado ejecutado correctamente.");

            
            System.out.println("Usuario validado correctamente mediante el procedimiento almacenado.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                if (callableStatement != null) callableStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rpta;

	}
	@Override
	//Consultar solicitud
	public SolicitudCredito consultarSolicitud(HttpServletRequest request, String nroSolicitud, String nroDocumento){
	 
		SolicitudCredito solicitud = new SolicitudCredito();
		Connection connection = null;
		CallableStatement callableStatement = null;
        
        try {
            connection = OracleConnection.getConnection();
            
            // Llama al procedimiento almacenado "insertar_cliente"
            String storedProcedure = "{CALL insertar_cliente(?, ?, ?, ?)}";
            callableStatement = connection.prepareCall(storedProcedure);
            
            // Establece los valores de los parámetros del procedimiento
            //callableStatement.setInt(1, cliente.getId());
            //callableStatement.setString(2, cliente.getNombre());
            //callableStatement.setString(3, cliente.getApellido());
            //callableStatement.setString(4, cliente.getEmail());
            
            // Ejecuta el procedimiento almacenado
            callableStatement.execute();
            
            System.out.println("Usuario validado correctamente mediante el procedimiento almacenado.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return solicitud;
		
	}
	@Override
	//Dar de alta al solicitud
	public Respuesta altaSolicitud(HttpServletRequest request, Cliente cliente, SolicitudCredito solicitud) {
		Respuesta rpta= new Respuesta();
		Connection connection = null;
		CallableStatement callableStatement = null;
        
        try {
            connection = OracleConnection.getConnection();
            
            // Llama al procedimiento almacenado "insertar_cliente"
            String storedProcedure = "{CALL insertar_cliente(?, ?, ?, ?)}";
            callableStatement = connection.prepareCall(storedProcedure);
            
            // Establece los valores de los parámetros del procedimiento
            //callableStatement.setInt(1, cliente.getId());
            //callableStatement.setString(2, cliente.getNombre());
            //callableStatement.setString(3, cliente.getApellido());
            //callableStatement.setString(4, cliente.getEmail());
            
            // Ejecuta el procedimiento almacenado
            callableStatement.execute();
            
            System.out.println("Usuario validado correctamente mediante el procedimiento almacenado.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		return rpta;

	}
	

}

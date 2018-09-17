package service;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Usuario;
import util.Registro;
import util.Request;
import util.ValerianUtil;


public class UsuarioService {

	public Registro crearUsuario(Usuario usuario , String token) throws URISyntaxException  {
		Map<String,Object>parametros=new HashMap<>();				
		parametros.put("departamento", usuario.getMesa().getPuntoVotacion().getLocalizacion().getCiudad().getDepartamento().getNombre());
		parametros.put("ciudad", usuario.getMesa().getPuntoVotacion().getLocalizacion().getCiudad().getNombre());
		parametros.put("latitud", usuario.getMesa().getPuntoVotacion().getLocalizacion().getLatitud());
		parametros.put("longitud", usuario.getMesa().getPuntoVotacion().getLocalizacion().getLongitud());
		parametros.put("direccion", usuario.getMesa().getPuntoVotacion().getLocalizacion().getDireccion());
		parametros.put("puesto", usuario.getMesa().getPuntoVotacion().getNombre());
		parametros.put("mesa", usuario.getMesa().getNumero());		
		parametros.put("movil", usuario.getCelular());
		parametros.put("nombre", !"".equals(usuario.getNombreUno()) && usuario.getNombreUno() !=null?usuario.getNombreUno():"FALTA");
		parametros.put("nombre2", usuario.getNombreDos());
		parametros.put("apellido", !"".equals(usuario.getApellidoUno()) && usuario.getApellidoUno()!=null?usuario.getApellidoUno():"FALTA");
		parametros.put("apellido2", usuario.getApellidoDos());
		parametros.put("nit",usuario.getCedula());
		parametros.put("email",usuario.getCorreo());
		parametros.put("type","E");
		parametros.put("token",token);
		return Request.post(ValerianUtil.URL+"api/usuario/storeJX", parametros);
	}
	
	public Registro actualizarUsuario(Usuario usuario , String token) throws URISyntaxException  {
		Map<String,Object>parametros=new HashMap<>();				
		parametros.put("departamento", usuario.getMesa().getPuntoVotacion().getLocalizacion().getCiudad().getDepartamento().getNombre());
		parametros.put("ciudad", usuario.getMesa().getPuntoVotacion().getLocalizacion().getCiudad().getNombre());
		parametros.put("latitud", usuario.getMesa().getPuntoVotacion().getLocalizacion().getLatitud());
		parametros.put("longitud", usuario.getMesa().getPuntoVotacion().getLocalizacion().getLongitud());
		parametros.put("direccion", usuario.getMesa().getPuntoVotacion().getLocalizacion().getDireccion());
		parametros.put("puesto", usuario.getMesa().getPuntoVotacion().getNombre());
		parametros.put("mesa", usuario.getMesa().getNumero());		
		parametros.put("movil", usuario.getCelular());
		parametros.put("nombre", !"".equals(usuario.getNombreUno()) && usuario.getNombreUno() !=null?usuario.getNombreUno():"FALTA");
		parametros.put("nombre2", usuario.getNombreDos());
		parametros.put("apellido", !"".equals(usuario.getApellidoUno()) && usuario.getApellidoUno()!=null?usuario.getApellidoUno():"FALTA");
		parametros.put("apellido2", usuario.getApellidoDos());
		parametros.put("nit",usuario.getCedula());
		parametros.put("email",usuario.getCorreo());
		parametros.put("id", usuario.getId());	
		parametros.put("token",token);
		return Request.post(ValerianUtil.URL+"api/usuario/updateJX", parametros);
	}

	public Registro sesion(Usuario usuario) throws URISyntaxException{
		Map<String,Object>parametros=new HashMap<>();				
		parametros.put("email", usuario.getCorreo());
		parametros.put("password", usuario.getContrasena());	
		System.out.println("SESION");
		System.out.println(ValerianUtil.URL);
		return Request.post(ValerianUtil.URL+"api/usuario/sesion", parametros);
	}
	

	public Registro getUsuario(String token) throws URISyntaxException{
		Map<String,Object>parametros=new HashMap<>();				
		parametros.put("token", token);
		return Request.get(ValerianUtil.URL+"api/usuario/getUsuario", parametros);
	}
	
	public List<Registro> consultaMasivoPersona(int cantidad, String token,int idCandidato) throws URISyntaxException   {
		System.out.println("entro");
		Map<String,Object>parametros=new HashMap<>();				
		parametros.put("cantidad",cantidad);
		parametros.put("token",token);
		parametros.put("id_candidato",idCandidato);
		return Request.getList(ValerianUtil.URL+"api/usuario/masivo", parametros);
	}
}

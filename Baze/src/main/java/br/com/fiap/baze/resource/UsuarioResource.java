package br.com.fiap.baze.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.baze.banco.factory.ConectionFactory;
import br.com.fiap.baze.bo.UsuarioBO;
import br.com.fiap.baze.to.UsuarioTO;

@Path("/usuario")
public class UsuarioResource {
	
	private UsuarioBO usuarioBo;
	
	
	public UsuarioResource () {
		
		try {
			
			usuarioBo = new UsuarioBO(ConectionFactory.getConnetion());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioTO> usuario() throws SQLException {
		return usuarioBo.listar();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(UsuarioTO usuarioTo, @Context UriInfo uriInfo) throws SQLException {
		
		try {
			usuarioBo.cadastrarUsuario(usuarioTo);
		} catch (SQLException e) {
			return Response.status(400, e.getMessage()).build();
		}
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		builder.path(Integer.toString(usuarioTo.getId()));
		
		return Response.created(builder.build()).build();
	}
}

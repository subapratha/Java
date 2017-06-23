package com.welcome.rest;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.welcome.rest.Track;

@SuppressWarnings("unused")
@Path("/")
public class Restfulwelcome {
	@GET
	 @Path("/getmusic") 
	@Produces(MediaType.APPLICATION_XML)
	public Track getTrackInJSON() {
		Track track = new Track();
		track.setTitle("Enter Singer");
		track.setSinger("Elvis");
		return track;
	}

	@POST
	 @Path("/post") 
	@Consumes(MediaType.APPLICATION_XML)
	public Response createTrackInJSON(Track track) {
		String result = "Track saved:=  " + track;
		return Response.status(201).entity(result).build();
	}

	
	  @GET
	  
	  @Produces("text/html") public Response getStartingPage() { String output
	  = "<h1>Welcome World!<h1>" +
	  "<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() +
	  "</p<br>"; return Response.status(200).entity(output).build(); }
	 

}

package org.restws.resources;

import org.restws.model.Library;
import org.restws.service.LibraryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/libraries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LibraryResource {
    LibraryService libraryService = new LibraryService();

    @GET
    public List<Library> getLibraries() {
        return libraryService.getAllLibraries();
    }

    @POST
    public Library addLibrary(Library library) {
        return libraryService.addLibrary(library);
    }

    @PUT
    @Path("/{libraryId}")
    public Library updateLibrary(@PathParam("libraryId") long id, Library library) {
        library.setId(id);
        return libraryService.updateLibrary(library);
    }
    @DELETE
    @Path("/{libraryId}")
    public void deleteLibrary(@PathParam("libraryId") long id) {
        libraryService.removeLibrary(id);
    }

    @GET
    @Path("/{libraryId}")
    public Library getLibrary(@PathParam("libraryId") long id) {
        return libraryService.getLibrary(id);
    }

    @Path("/{libraryId}/books")
    public BookResource getBookResource() {
        return new BookResource();
    }

}

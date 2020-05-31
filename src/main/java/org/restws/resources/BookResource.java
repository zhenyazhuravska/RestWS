package org.restws.resources;


import org.restws.bean.FilterBean;
import org.restws.model.Book;
import org.restws.service.BookService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class BookResource {
    private BookService bookService = new BookService();


    @GET
    public List<Book> getAllBooks(@PathParam("libraryId") long libraryId) {
        return bookService.getAllBooks(libraryId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{bookId}/bean")
    public Response getBean(@BeanParam FilterBean filterBean) {
        return Response.ok().entity(filterBean).type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Book addBook(@PathParam("libraryId") long libraryId, Book book) {
        return bookService.addBook(libraryId, book);
    }

    @PUT
    @Path("/{bookId}")
    public Book updateBook(@PathParam("libraryId") long libraryId, @PathParam("bookId") long id, Book book) {
        book.setId(id);
        return bookService.updateBook(libraryId, book);
    }

    @DELETE
    @Path("/{bookId}")
    public void deleteBook(@PathParam("libraryId") long libraryId, @PathParam("bookId") long bookId) {
       bookService.removeBook(libraryId, bookId);
    }

    @GET
    @Path("/{bookId}")
    public Book getLibrary(@PathParam("libraryId") long libraryId, @PathParam("bookId") long bookId) {
        return bookService.getBook(libraryId, bookId);
    }
}

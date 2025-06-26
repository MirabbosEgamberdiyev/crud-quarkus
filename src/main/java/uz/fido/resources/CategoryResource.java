package uz.fido.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uz.fido.dto.CategoryDTO;
import uz.fido.services.CategoryService;

import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    CategoryService categoryService;

    @GET
    public List<CategoryDTO> getAll() {
        return categoryService.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        CategoryDTO dto = categoryService.getDTOById(id);
        return dto != null ? Response.ok(dto).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response create(CategoryDTO dto) {
        CategoryDTO created = categoryService.create(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CategoryDTO dto) {
        CategoryDTO updated = categoryService.update(id, dto);
        return updated != null ? Response.ok(updated).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = categoryService.delete(id);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}

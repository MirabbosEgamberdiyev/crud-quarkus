package uz.fido.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uz.fido.dto.ProductDTO;
import uz.fido.services.ProductService;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public List<ProductDTO> getAll() {
        return productService.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        ProductDTO dto = productService.findById(id);
        return dto != null ? Response.ok(dto).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response create(ProductDTO dto) {
        ProductDTO created = productService.create(dto);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ProductDTO dto) {
        ProductDTO updated = productService.update(id, dto);
        return updated != null ? Response.ok(updated).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = productService.delete(id);
        return deleted ? Response.noContent().build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}

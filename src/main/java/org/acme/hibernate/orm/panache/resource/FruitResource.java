package org.acme.hibernate.orm.panache.resource;

import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import org.acme.hibernate.orm.panache.form.FruitPostForm;
import org.acme.hibernate.orm.panache.form.FruitUpdateForm;
import org.acme.hibernate.orm.panache.model.Fruit;
import org.acme.hibernate.orm.panache.service.FruitService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/fruits")
public class FruitResource {

    @Inject
    FruitService fruitService;
    @GET
    public List<Fruit> get() {
        return fruitService.getAll();
    }

    @GET
    @Path("/{id}")
    public Fruit getSingle(Long id) {
        return fruitService.getById(id);
    }

    @POST
    @Transactional
    public Response create(FruitPostForm form) {
       return fruitService.create(form);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Fruit update(Long id,FruitUpdateForm form) { return fruitService.update(id,form);}

    @DELETE
    @Path("/{id}")
    @Transactional
    public Fruit delete(Long id) throws Exception {
        return fruitService.delete(id);
    }
}

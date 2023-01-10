package org.acme.hibernate.orm.panache.service;

import io.smallrye.mutiny.Uni;
import org.acme.hibernate.orm.panache.form.FruitPostForm;
import org.acme.hibernate.orm.panache.form.FruitUpdateForm;
import org.acme.hibernate.orm.panache.model.Fruit;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;
@ApplicationScoped
public interface FruitService {


    public Response create(FruitPostForm form);

    List<Fruit> getAll();

    Fruit getById(Long id);

    Fruit update(Long id ,FruitUpdateForm form);

    Fruit delete(Long id) throws Exception;
}

package org.acme.hibernate.orm.panache.service.impl;

import org.acme.hibernate.orm.panache.form.FruitPostForm;
import org.acme.hibernate.orm.panache.form.FruitUpdateForm;
import org.acme.hibernate.orm.panache.model.Fruit;
import org.acme.hibernate.orm.panache.service.FruitService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class FruitImpl implements FruitService {

    @Override
    public List<Fruit> getAll() {
        return Fruit.listAll();
    }
    @Override
    public Fruit getById(Long id) {
        return Fruit.findById(id);
    }

    @Override
    public Fruit update(Long id,FruitUpdateForm form) {
        Fruit fruit = Fruit.findById(id);
        fruit.name =form.getName() == null  ? fruit.name : form.getName();
        fruit.qnt=form.getQnt() == null ? fruit.qnt :form.getQnt();
        fruit.forSale=form.getForSale() == null ?  fruit.forSale : form.getForSale();
        fruit.persist();
        return fruit;
    }

    @Override
    public Fruit delete(Long id) throws Exception {
        Fruit fruit= Fruit.findById(id);
        if(fruit.isPersistent()) {
            fruit.delete();
            return fruit;
        }
        throw  new Exception("id not found");
    }

    @Override
    public Response create(FruitPostForm form) {
        Fruit fruit =new Fruit(form);
        fruit.persist();
        return Response.ok(fruit).build();
    }

}

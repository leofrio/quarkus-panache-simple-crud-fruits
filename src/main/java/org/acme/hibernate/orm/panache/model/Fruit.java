package org.acme.hibernate.orm.panache.model;


import io.quarkus.hibernate.orm.*;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.NoArgsConstructor;
import org.acme.hibernate.orm.panache.form.FruitPostForm;

import javax.persistence.*;

@Entity(name = "fruits")
@NoArgsConstructor
public class Fruit extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(length = 40,unique = true)
    public String name;
    @Column
    public Integer qnt= (int) (Math.random() * 10);
    @Column(name = "for_sale")
    public Boolean forSale;

    public Fruit(FruitPostForm form) {
        this.name =form.getName() ;
        this.qnt = form.getQnt();
        this.forSale =form.getForSale();
    }
}

package org.acme.hibernate.orm.panache.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Getter @Setter
public class FruitUpdateForm {
    private String name;
    private Integer qnt;
    private Boolean forSale;
}

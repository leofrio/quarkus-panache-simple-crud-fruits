package org.acme.hibernate.orm.panache.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.hibernate.orm.panache.model.Fruit;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor
public class FruitPostForm {
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private Integer qnt;
    @NotNull @NotEmpty
    private Boolean forSale;
}

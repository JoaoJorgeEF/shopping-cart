package br.edu.ifpb.padroes.service.visitor;

import br.edu.ifpb.padroes.model.Book;
import br.edu.ifpb.padroes.model.Electronic;
import br.edu.ifpb.padroes.model.Product;

import java.math.BigDecimal;

public interface Visitor {
    BigDecimal visit(Book book);
    BigDecimal visit(Electronic eletronic);
    BigDecimal getTotal(Product... products);
}

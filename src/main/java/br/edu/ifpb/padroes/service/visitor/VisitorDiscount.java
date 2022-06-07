package br.edu.ifpb.padroes.service.visitor;

import br.edu.ifpb.padroes.model.Book;
import br.edu.ifpb.padroes.model.Electronic;
import br.edu.ifpb.padroes.model.Product;

import java.math.BigDecimal;

public class VisitorDiscount implements Visitor {
    @Override
    public BigDecimal visit(Book book) {
        return null;
    }

    @Override
    public BigDecimal visit(Electronic eletronic) {
        return null;
    }

    @Override
    public BigDecimal getTotal(Product... products) {
        BigDecimal sum = new BigDecimal(0);
        for (Product product : products) {
            sum.add(product.accept(this));
        }
        return sum;
    }
}

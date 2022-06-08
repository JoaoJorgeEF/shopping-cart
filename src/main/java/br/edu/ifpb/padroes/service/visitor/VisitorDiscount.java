package br.edu.ifpb.padroes.service.visitor;

import br.edu.ifpb.padroes.model.Book;
import br.edu.ifpb.padroes.model.Electronic;
import br.edu.ifpb.padroes.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VisitorDiscount implements Visitor {

    private static final BigDecimal BOOK_DISCOUNT = BigDecimal.valueOf(0.3); // 30 %
    private static final BigDecimal ELECTRONIC_DISCOUNT = BigDecimal.valueOf(0.05); // 5 %

    @Override
    public BigDecimal visit(Book book) {

        return book.getPrice().multiply(BOOK_DISCOUNT);
    }

    @Override
    public BigDecimal visit(Electronic eletronic) {

        return eletronic.getPrice().multiply(ELECTRONIC_DISCOUNT);
    }

    @Override
    public BigDecimal getTotal(Product... products) {
        double sum = 0.0;
        for (Product product : products) {
            double result = product.accept(this).doubleValue();
            sum += result;
        }
        BigDecimal ret = new BigDecimal(sum);
        return ret.setScale(2, RoundingMode.CEILING);
    }
}

package com.profitsoft.dudka.pagination;

import com.profitsoft.dudka.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


public class ProductResponse {
    public static List<Optional<Product>> pageableProduct(List<Optional<Product>> productList, int page) {
        List<Optional<Product>> pagedProductList = new ArrayList<>();

        try {
            for (int i = page * 10 - 9; i <= page * 10; ++i) {

                if (productList.size() == 1) {
                    pagedProductList.add(productList.get(0));
                    return pagedProductList;
                } else if (productList.isEmpty()) return productList;

                if (productList.indexOf(productList.get(i - 1)) == (productList.size() - 1)) {
                    pagedProductList.add(productList.get(i - 1));
                    return pagedProductList;
                }

                pagedProductList.add(productList.get(i - 1));
            }
            return pagedProductList;
        } catch (IndexOutOfBoundsException exception) {
            Logger.getLogger("Logger").warning(exception.getMessage() + Arrays.toString(exception.getStackTrace()));
            return pagedProductList;
        }
    }
}


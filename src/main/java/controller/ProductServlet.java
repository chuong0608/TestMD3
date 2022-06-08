package controller;

import model.Product;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default: {
                try {
                    showListProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Product> products = productService.findAll();
        String key = request.getParameter("key");
        if (key != null) {
            products = productService.findByName("%" + key + "%");
        }
//        int key1 = Integer.parseInt(request.getParameter("key1"));
//        int key2 = Integer.parseInt(request.getParameter("key2"));
//        if (key1 != 0 && key2 != 0){
//            products = productService.findByPrice( key1,key2 );
//        }
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search-price": {
                try {
                    searchPrice(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            }
            default: {
                try {
                    showListProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void searchPrice(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        int key1 = Integer.parseInt(request.getParameter("key1"));
        int key2 = Integer.parseInt(request.getParameter("key2"));
        List<Product> products = productService.findByPrice(key1, key2);
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }
}


package edu.mum.cs;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String number1 = req.getParameter("num1");
//        String number2 = req.getParameter("num2");
//        String number3 = req.getParameter("num3");
//        String number4 = req.getParameter("num4");
//
//        Integer summation = Integer.parseInt(number1) + Integer.parseInt(number2);
//        Integer product = Integer.parseInt(number3) * Integer.parseInt(number4);
//
//        PrintWriter out = resp.getWriter();
//        out.println(number1 + " + " + number2 + " = " + summation);
//        out.println(number3 + " * " + number4 + " = " + product);
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer summation = null, product = null;
        String number1 = req.getParameter("num1");
        String number2 = req.getParameter("num2");
        String number3 = req.getParameter("num3");
        String number4 = req.getParameter("num4");

        PrintWriter out = resp.getWriter();

        if (number1.isEmpty() || number2.isEmpty()){
            if (!number3.isEmpty() && !number4.isEmpty()){
                product = Integer.parseInt(number3) * Integer.parseInt(number4);
                out.println(number3 + " * " + number4 + " = " + product);
            }
        }else if (number3.isEmpty() || number4.isEmpty()){
            if (!number1.isEmpty() && !number2.isEmpty()) {
                summation = Integer.parseInt(number1) + Integer.parseInt(number2);
                out.println(number1 + " + " + number2 + " = " + summation);
            }
        }else if (!number1.isEmpty() && !number2.isEmpty() && !number3.isEmpty() && !number4.isEmpty()){
            summation = Integer.parseInt(number1) + Integer.parseInt(number2);
            product = Integer.parseInt(number3) * Integer.parseInt(number4);
            out.println(number1 + " + " + number2 + " = " + summation);
            out.println(number3 + " * " + number4 + " = " + product);
        }
    }
}

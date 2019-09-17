package edu.mum.cs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorApp2Servlet", urlPatterns = {"/calc2"})
public class CalculatorApp2Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer summation = null, product = null;
        String number1 = req.getParameter("num5");
        String number2 = req.getParameter("num6");
        String number3 = req.getParameter("num7");
        String number4 = req.getParameter("num8");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        if (number1.isEmpty() || number2.isEmpty()){
            if (!number3.isEmpty() && !number4.isEmpty()){
                product = Integer.parseInt(number3) * Integer.parseInt(number4);
                out.println("<form action=\"calc2\" method=\"POST\">" +
                        "<input type=\"number\" name=\"num7\" value=" + number3 + ">" +
                        " * " +
                        "<input type=\"number\" name=\"num8\" value=" + number4 + ">" +
                        " = " +
                        "<input type=\"number\" name=\"result2\" value=" + product + ">" +
                        "<br>" + "<br>" +
                        "</form>"
                );
            }
        }else if (number3.isEmpty() || number4.isEmpty()){
            if (!number1.isEmpty() && !number2.isEmpty()) {
                summation = Integer.parseInt(number1) + Integer.parseInt(number2);
                //out.println(number1 + " + " + number2 + " = " + summation);
                out.println("<form action=\"calc2\" method=\"POST\">" +
                        "<input type=\"number\" name=\"num5\" value=" + number1 + ">" +
                        "+" +
                        "<input type=\"number\" name=\"num6\" value=" + number2 + ">" +
                        " = " +
                        "<input type=\"number\" name=\"result1\" value=" + summation + ">" +
                        "<br>" + "<br>" +
                        "</form>"
                );
            }
        }else if (!number1.isEmpty() && !number2.isEmpty() && !number3.isEmpty() && !number4.isEmpty()){
            summation = Integer.parseInt(number1) + Integer.parseInt(number2);
            product = Integer.parseInt(number3) * Integer.parseInt(number4);

            out.println("<form action=\"calc2\" method=\"POST\">" +
                    "<input type=\"number\" name=\"num5\" value=" + number1 + ">" +
                    "+" +
                    "<input type=\"number\" name=\"num6\" value=" + number2 + ">" +
                    " = " +
                    "<input type=\"number\" name=\"result1\" value=" + summation + ">" +
                    "<br>" + "<br>" +
                    "<input type=\"number\" name=\"num7\" value=" + number3 + ">" +
                    " * " +
                    "<input type=\"number\" name=\"num8\" value=" + number4 + ">" +
                    " = " +
                    "<input type=\"number\" name=\"result2\" value=" + product + ">" +
                    "<br>" + "<br>" +
                    "</form>"
            );


        }
    }
}


response.setContentType("text/html; charset= UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isValid = AccountJDBC.checkLogin(username,password);

        if (isValid){
            HttpSession session = request.getSession();

session.setAttribute("tendangnhap", username);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);



}
        else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
}

        out.close();
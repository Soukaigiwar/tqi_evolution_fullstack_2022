import React from "react"
import 'bootswatch/dist/flatly/bootstrap.css'

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Navbar from '../components/Navbar/navbar'

import Index from "../pages/index";
import Customer from "../pages/customer/customer";
import AddCustomer from "../pages/customer/add-customer";
import Book from "../pages/book/book";
import AddBook from "../pages/book/add-book";
import DeleteBook from "../pages/book/delete-book";

const App = () => {

  return (
    <>
      <Router>
        <Navbar />
        <Switch>
          <Route path="/" exact component={Index} />
          <Route path="/customer" component={Customer} />
          <Route path="/add-customer" element={<AddCustomer />} />
          <Route path="/book" component={Book} />
          <Route path="/add-book" component={AddBook} />
          <Route path="/delete-book" component={DeleteBook} />
        </Switch>
      </Router>
    </>
  );
}


export default App;
